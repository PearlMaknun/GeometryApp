package com.bso.android.geometryapp;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PersegiActivity extends AppCompatActivity {

    RadioButton rbkeliling, rbluas;
    Button btnhasil;
    TextView tvhasil;
    EditText etsisi;
    public float sisi = 0;
    public float hasil = 0;
    public Integer pilihan = 0; //untuk opsi pada prosedur Hasil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        //inisialisasi material
        rbkeliling = findViewById(R.id.rb_keliling);
        rbluas = findViewById(R.id.rb_luas);
        etsisi = findViewById(R.id.et_sisi);
        btnhasil = findViewById(R.id.btn_hasil);
        tvhasil = findViewById(R.id.tv_hasil);

    }

    public float Pilih(View view) {
        // radio button mana yang di ceklis saat ini?
        boolean checked = ((RadioButton) view).isChecked();
        // mengecek pada radio button mana yang di klik
        switch(view.getId()) {
            case R.id.rb_keliling:
                if (checked)
                    pilihan = 0;
                break;
            case R.id.rb_luas:
                if (checked)
                    pilihan = 1;
                break;
            default:

                break;
        }
        return pilihan;
    }

    public float keliling(){
        float k = 0;
        sisi = Float.parseFloat(etsisi.getText().toString());
        k = sisi+sisi+sisi+sisi;
        return k;
    }

    public float luas(){
        float l = 0;
        sisi = Float.parseFloat(etsisi.getText().toString());
        l = sisi*sisi;
        return l;
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Hasil(View view){
        if(etsisi.getText().toString().equals("")){
            displayToast("Pastikan kamu sudah mengisi kolom sisi!");
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
