package com.bso.android.geometryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PersegiPanjangActivity extends AppCompatActivity {

    RadioButton rbkeliling, rbluas;
    Button btnhasil;
    TextView tvhasil;
    EditText etpanjang, etlebar;
    public float panjang = 0;
    public float lebar = 0;
    public float hasil = 0;
    public Integer pilihan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);

        rbkeliling = findViewById(R.id.rb_keliling);
        rbluas = findViewById(R.id.rb_luas);
        etpanjang = findViewById(R.id.et_panjang);
        etlebar = findViewById(R.id.et_lebar);
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
                break;
            case R.id.rb_luas:
                if (checked)
                    pilihan = 1;
                break;
            default:
                displayToast("Pastikan kamu sudah mengisi kolom sisi!");
                break;
        }
        return pilihan;
    }

    public float keliling(){
        float k = 0;
        panjang = Float.parseFloat(etpanjang.getText().toString());
        lebar = Float.parseFloat(etlebar.getText().toString());
        k = panjang*2 + lebar*2;
        return k;
    }

    public float luas(){
        float l = 0;
        panjang = Float.parseFloat(etpanjang.getText().toString());
        lebar = Float.parseFloat(etlebar.getText().toString());
        l = panjang * lebar;
        return l;
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void Hasil(View view){
        if(etpanjang.getText().toString().equals("") || etlebar.getText().toString().equals("")){
            displayToast("Pastikan kamu sudah mengisi kolom panjang dan lebar!");
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
