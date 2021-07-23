package com.example.modul1_kel17.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.modul1_kel17.R;

public class DetailActivity extends AppCompatActivity {

    private TextView nama;
    private TextView Deskripsi;
    private ImageView gambar;

    String namaMobil;
    String deskripsi;
    int gambarMobil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        gambar = (ImageView) findViewById(R.id.IvDetailGambar);
        nama = (TextView)findViewById(R.id.TxtDetailMobil);
        Deskripsi = (TextView)findViewById(R.id.deskripsi);

        // ambil nilai yang di kirim pada saat di klik
        namaMobil = getIntent().getStringExtra("Nama");
        deskripsi = getIntent().getStringExtra("Deskripsi");
        gambarMobil = getIntent().getIntExtra("Gambar",0);

        // tampilkan di widged
        gambar.setImageResource(gambarMobil);
        nama.setText(namaMobil);
        Deskripsi.setText(deskripsi);

        Button btnPindahProfil= findViewById(R.id.btnPindahProfil);
        btnPindahProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this, ProfilActivity.class));
            }

        });

    }

    }

