package com.santosstampa.indicadores;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private WebView webView;
    EditText usuario;
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        usuario = (EditText) findViewById(R.id.EditText);
    }
    public void cliquebotao(View view){

        //aqui começa o clique;
        try {
            String loja = usuario.getText().toString();
            //test.setText(loja);
            if (loja.equals("Loja1")) {
                loja="Passou";
                webView.loadUrl("https://app.powerbi.com/view?r=eyJrIjoiOGM2NzVmMjAtOWIwYS00NGEzLWI1NWQtNTQzMzEwMmQ3OTg5IiwidCI6ImI4MTU5YmFmLWM5MTMtNDg1OC04Nzg3LTEzZDAyODlmZDZlMSJ9&pageName=ReportSection8fe31a6909760b1084c9");


            }else if (loja.equals("Loja2")){
                loja="Passou2";
                webView.loadUrl("https://app.powerbi.com/view?r=eyJrIjoiY2JlMTgwMDktMjVhOS00NzJjLWI0MDItMTUwMDg1NGJmOTZiIiwidCI6ImI4MTU5YmFmLWM5MTMtNDg1OC04Nzg3LTEzZDAyODlmZDZlMSJ9&pageName=ReportSection69e175ac51138c48d5d6");

            }else {
                loja = "senha errada";

                webView.loadUrl("");

                AlertDialog alertDialog;
                alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Usuário Desconhecido");
                alertDialog.setMessage("Favor verificar a Loja");
                alertDialog.show();
            }
        }
        catch (Exception e){
            usuario.setError("Favor Adicionar Usuário!");
            usuario.requestFocus();

        }

    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
