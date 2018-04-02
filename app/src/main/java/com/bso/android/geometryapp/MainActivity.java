package com.bso.android.geometryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnpersegi, btnpersegipanjang, btnlingkaran, btnsegitiga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnpersegi=findViewById(R.id.btn_persegi);
        btnpersegipanjang=findViewById(R.id.btn_persegipanjang);
        btnlingkaran=findViewById(R.id.btn_lingkaran);
        btnsegitiga=findViewById(R.id.btn_segitiga);

        btnpersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PersegiActivity.class);
                startActivity(intent);
            }
        });

        btnpersegipanjang.setOnClickListener(persegipanjang);
    }

    public View.OnClickListener persegipanjang = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, PersegiPanjangActivity.class);
            startActivity(intent);
        }
    };

    public void lingkaran(View v){
        Intent intent = new Intent(MainActivity.this, LingkaranActivity.class);
        startActivity(intent);
    }

    public void segitiga(View v){
        Intent intent = new Intent(MainActivity.this, SegitigaActivity.class);
        startActivity(intent);
    }


}
