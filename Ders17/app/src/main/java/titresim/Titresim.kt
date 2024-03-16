package titresim

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xzcorp.ders17.R

class Titresim : AppCompatActivity() {
    lateinit var titresimButon:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_titresim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        titresimButon = findViewById(R.id.titret)
        titresimButon.setOnClickListener {
            titretMetodu()
        }
    }
    fun titretMetodu(){
        val titretObj=getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if(titretObj.hasVibrator()){
            if(Build.VERSION.SDK_INT>=31)
                titretObj.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
            else
                titretObj.vibrate(500)
        }
    }
}