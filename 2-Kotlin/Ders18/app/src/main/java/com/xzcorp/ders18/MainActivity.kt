package com.xzcorp.ders18

import android.content.Context
import android.hardware.camera2.CameraManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var durum:TextView
    lateinit var internetDurum:Button
    lateinit var flash:Button

    var flashDurum:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        durum = findViewById(R.id.durum)
        internetDurum = findViewById(R.id.internetKontrol)

        internetDurum.setOnClickListener {
            var nedirDurum = internetVarMi(applicationContext)

            if(nedirDurum == true)
                durum.text = "İnternet Var"
            else
                durum.text = "İnternet Yok"
        }

        flash = findViewById(R.id.flash)

        flash.setOnClickListener {
            flashAcKapat()
        }


    }
    private fun internetVarMi(context:Context):Boolean
    {
        var result=false

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            val networkCapabilities = connectivityManager.activeNetwork ?:return false
            val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities)?:return false
            result = when  {
                actNw.hasTransport((NetworkCapabilities.TRANSPORT_WIFI)) -> true
                actNw.hasTransport((NetworkCapabilities.TRANSPORT_CELLULAR)) -> true
                actNw.hasTransport((NetworkCapabilities.TRANSPORT_ETHERNET)) -> true
                else -> false
            }
        }
        else {
            connectivityManager.run {
                connectivityManager.activeNetworkInfo?.run {
                    result = when (type) {
                        ConnectivityManager.TYPE_WIFI -> true
                        ConnectivityManager.TYPE_MOBILE -> true
                        ConnectivityManager.TYPE_ETHERNET -> true
                        else -> false
                    }
                }
            }
        }
        return result
    }

    private fun flashAcKapat(){
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        val camraId = cameraManager.cameraIdList[0]
        if(!flashDurum){
            cameraManager.setTorchMode(camraId,true)
            flashDurum = true
        }
        else {
            cameraManager.setTorchMode(camraId,false)
            flashDurum = false
        }
    }
}