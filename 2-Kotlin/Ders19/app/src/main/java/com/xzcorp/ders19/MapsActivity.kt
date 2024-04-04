package com.xzcorp.ders19

import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ZoomControls

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.xzcorp.ders19.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var lokasyon:EditText
    lateinit var git:Button
    lateinit var uydu:Button
    lateinit var zoom:ZoomControls

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        lokasyon = findViewById(R.id.lokasyon)
        git = findViewById(R.id.git)
        uydu = findViewById(R.id.uydu)
        zoom = findViewById(R.id.zoom) as ZoomControls

        git.setOnClickListener {
            var lokasyonBilgisi = lokasyon.text.toString()
            if(lokasyonBilgisi.isNotEmpty()){
                var adresListesi = ArrayList<Address?>()
                adresListesi.add(null)
                val geoCoder = Geocoder(this@MapsActivity)
                try{
                    adresListesi = geoCoder.getFromLocationName(lokasyonBilgisi,1)as ArrayList<Address?>
                }
                catch(e:Exception){ }
                var enUygunAdres = adresListesi[0]
                val yerinEnlemBoylam = LatLng(enUygunAdres!!.latitude, enUygunAdres!!.longitude)

                mMap.addMarker(MarkerOptions().position(yerinEnlemBoylam).title(("Burası $lokasyonBilgisi")))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(yerinEnlemBoylam))
            }
        }

        uydu.setOnClickListener {
            if(mMap.mapType == GoogleMap.MAP_TYPE_NORMAL){
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                uydu.text="Normal"
            }
            else {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                uydu.text = "Uydu"
            }
        }

        zoom.setOnZoomInClickListener {
            mMap.animateCamera(CameraUpdateFactory.zoomIn())
        }
        zoom.setOnZoomOutClickListener {
            mMap.animateCamera(CameraUpdateFactory.zoomOut())
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(39.750359, 37.015598)
        mMap.addMarker(MarkerOptions().position(sydney).title("Burası Sivas"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}