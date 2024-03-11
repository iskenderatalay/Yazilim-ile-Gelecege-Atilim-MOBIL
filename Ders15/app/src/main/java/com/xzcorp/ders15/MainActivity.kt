package com.xzcorp.ders15

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xzcorp.ders15.ui.theme.Ders15Theme

class MainActivity : ComponentActivity() {

    lateinit var gonderDegiskeni: Button
    lateinit var dataTextDegiskeni: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        gonderDegiskeni=findViewById(R.id.gonder)
        dataTextDegiskeni=findViewById(R.id.dataEdit)



        gonderDegiskeni.setOnClickListener{
            //Toast.makeText(this,"Heyy",Toast.LENGTH_LONG).show()
            val intent=Intent(this,ikinciSayfa::class.java)
            intent.putExtra("veri",dataTextDegiskeni.text.toString())
            startActivity(intent)
            finish()

        }



        /*
        setContent {
            Ders15Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }*/
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ders15Theme {
        Greeting("Android")
    }
}
 */