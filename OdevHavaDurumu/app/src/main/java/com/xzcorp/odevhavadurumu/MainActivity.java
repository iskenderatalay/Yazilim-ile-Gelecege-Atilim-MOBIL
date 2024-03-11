package com.xzcorp.odevhavadurumu;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText sehirGir;
    TextView sicaklik,nem,basinc,aciklama,ruzgar;
    Button button;
    ImageView wImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sehirGir=(EditText) findViewById(R.id.sehirGir);
        button=(Button) findViewById(R.id.button);
        sicaklik=(TextView) findViewById(R.id.sicaklik);
        nem=(TextView) findViewById(R.id.nem);
        basinc=(TextView) findViewById(R.id.basinc);
        aciklama=(TextView) findViewById(R.id.aciklama);
        ruzgar=(TextView) findViewById(R.id.ruzgar);
        wImage=(ImageView) findViewById(R.id.wImage);

        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apikey="a5e022c964bf51ad852357728e02e0d1";
                String sehirAd=sehirGir.getText().toString();
                String url="https://api.openweathermap.org/data/2.5/weather?q="+sehirAd+"&lang=tr&appid="+apikey+"&units=metric";

                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);

                RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            JSONObject object=jsonObject.getJSONObject("main");
                            String sicak=object.getString("temp");
                            String hum=object.getString("humidity");
                            String pres=object.getString("pressure");

                            sicaklik.setText(sicak+" °C");
                            nem.setText("% "+hum);
                            basinc.setText(pres+" hPa");

                            JSONArray object2=jsonObject.getJSONArray("weather");
                            JSONObject object22=object2.getJSONObject(0);
                            String desc=object22.getString("description");
                            aciklama.setText(desc);

                            String iconName=object22.getString("icon");
                            String iconUrl="https://openweathermap.org/img/w/"+iconName+".png";
                            Picasso.with(MainActivity.this).load(iconUrl).resize(400,400).centerCrop().into(wImage);

                            JSONObject object3=jsonObject.getJSONObject("wind");
                            String win=object3.getString("speed");
                            ruzgar.setText(win+" m/s");

                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                            Toast.makeText(MainActivity.this,"Girilen Şehri Kontrol Et",Toast.LENGTH_SHORT).show();
                    }
                });
                queue.add(request);
            }
        });
    }
}