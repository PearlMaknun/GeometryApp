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

public class LingkaranActivity extends AppCompatActivity {

    RadioButton rbkeliling, rbluas;
    Button btnhasil;
    TextView tvhasil;
    EditText etjari2;
    public float phi = 22/7;
    public float r = 0;
    public float hasil = 0;
    public Integer pilihan = 0; //untuk opsi pada prosedur Hasil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        //inisialisasi material
        rbkeliling = findViewById(R.id.rb_keliling);
        rbluas = findViewById(R.id.rb_luas);
        etjari2 = findViewById(R.id.et_jarijari);
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
        //rumus keliling lingkaran
        float k = 0;
        r = Float.parseFloat(etjari2.getText().toString());
        k = 2 * r * phi;
        return k;
    }

    public float luas(){
        //rumus luas lingkaran
        float l = 0;
        r = Float.parseFloat(etjari2.getText().toString());
        l = r * r * phi;
        return l;
    }

    public void displayToast(String message) {
        //menampilkan toast
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Hasil(View view){
        if(etjari2.getText().toString().equals("")){
            displayToast("Pastikan kamu sudah mengisi kolom jari-jari!");
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
