package com.xzcorp.ders20

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var buyut:Button
    lateinit var kucult:Button
    lateinit var dinamikText:TextView
    var yeniTextBoyutu = 12f

    lateinit var konumBul:Button

    private var locationManager:LocationManager? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buyut = findViewById(R.id.buyut)
        kucult = findViewById(R.id.kucult)
        dinamikText = findViewById(R.id.dinamikText)

        buyut.setOnClickListener {
            val oran = dinamikText.layoutParams as RelativeLayout.LayoutParams
            oran.apply {
                width +=10
                height += 10
            }
            dinamikText.layoutParams = oran
            yeniTextBoyutu *= 1.05f
            dinamikText.setTextSize(TypedValue.COMPLEX_UNIT_SP,yeniTextBoyutu)
        }

        kucult.setOnClickListener {
            val oran = dinamikText.layoutParams as RelativeLayout.LayoutParams
            oran.apply {
                width -=10
                height -= 10
            }
            dinamikText.layoutParams = oran
            yeniTextBoyutu /= 1.05f
            dinamikText.setTextSize(TypedValue.COMPLEX_UNIT_SP,yeniTextBoyutu)
        }

        konumBul = findViewById(R.id.konumBul)
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?

        konumBul.setOnClickListener {
            try{
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                )
                locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener)
            }
            catch (e:Exception){ }
        }
    }

    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            dinamikText.text = ("Lat: " + location.latitude + " Long:" + location.longitude)
        }
        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String){}
    }
}