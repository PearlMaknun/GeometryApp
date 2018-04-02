package com.bso.android.geometryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SegitigaSikusikuActivity extends AppCompatActivity {

    RadioButton rbkeliling, rbluas;
    Button btnhasil;
    TextView tvhasil;
    EditText etalas, ettinggi, etgaring;
    public float alas = 0;
    public float tinggi = 0;
    public float hasil = 0;
    public Integer pilihan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);

        rbkeliling = findViewById(R.id.rb_keliling);
        rbluas = findViewById(R.id.rb_luas);
        etalas = findViewById(R.id.et_alas);
        ettinggi = findViewById(R.id.et_tinggi);
        etgaring = findViewById(R.id.et_garing);
        btnhasil = findViewById(R.id.btn_hasil);
        tvhasil = findViewById(R.id.tv_hasil);

    }

    public float Pilih(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_keliling:
                if (checked)
                    pilihan = 0;
                    etgaring.setEnabled(true);
                break;
            case R.id.rb_luas:
                if (checked)
                    pilihan = 1;
                    etgaring.setEnabled(false);
                break;
            default:
                displayToast("Pastikan kamu sudah mengisi kolom sisi!");
                break;
        }
        return pilihan;
    }

    public float keliling(){
        float k = 0;
        alas = Float.parseFloat(etalas.getText().toString());
        tinggi = Float.parseFloat(ettinggi.getText().toString());
        k = 0;
        return k;
    }

    public float luas(){
        float l = 0;
        alas = Float.parseFloat(etalas.getText().toString());
        tinggi = Float.parseFloat(ettinggi.getText().toString());
        l = alas * tinggi / 2;
        return l;
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Hasil(View view){
        if(etalas.getText().toString().equals("") || ettinggi.getText().toString().equals("")){
            displayToast("Pastikan kamu sudah mengisi kolom alas dan tinggi!");
            tvhasil.setText("Tidak Diketahui");
        }
        else {
            switch (pilihan){
                case 0:
                    hasil = keliling();
                    tvhasil.setText(""+hasil+ " cm");
                    break;
                case 1:
                    hasil = luas();
                    tvhasil.setText(""+hasil+ " cm2");
                    break;
                default:
                    tvhasil.setText(""+hasil);
            }
        }
    }
}
