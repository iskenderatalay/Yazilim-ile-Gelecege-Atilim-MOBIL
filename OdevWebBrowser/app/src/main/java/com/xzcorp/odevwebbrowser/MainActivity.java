package com.xzcorp.odevwebbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText textObj;
    Button gitButtonObj;
    WebView webViewObj;
    RadioButton comButton,netButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textObj=(EditText) findViewById(R.id.text);
        gitButtonObj=(Button) findViewById(R.id.gitButton);
        comButton=(RadioButton) findViewById(R.id.comId);
        netButton=(RadioButton) findViewById(R.id.netId);

        webViewObj=(WebView) findViewById(R.id.webView);
        webViewObj.setWebViewClient(new WebViewClient());
        webViewObj.getSettings().setJavaScriptEnabled(true);

        gitButtonObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comButton.isChecked())
                    webViewObj.loadUrl("https://www."+textObj.getText()+".com");
                else if (netButton.isChecked())
                    webViewObj.loadUrl("https://www."+textObj.getText()+".net");
                InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });
    }
}