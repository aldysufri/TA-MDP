package com.example.modul1_kel17.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.modul1_kel17.Activity.DetailActivity;
import com.example.modul1_kel17.R;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String tipe_mobil[] = {
            "Honda Jazz",
            "Kijang Innova",
            "Grand Innova",
            "Xenia",
            "Yaris",
            "Elf"
    };
    String deskripsi[] = {
            "Harga : Rp 500.00/Hari \n Kapasitaas Penunmpang : 4 orang","Harga : Rp 600.00/Hari \n Kapasitas Penumpang : 6 orang","Harga : Rp 400.00/Hari \n Kapasitas Penumpang : 5 orang",
            "Harga : Rp 320.00/Hari \n Kapasitas Penumpang : 5 orang","Harga : Rp 400.00/Hari \n Kapasitas Penumpang : 4 orang","Harga : Rp 700.00/Hari \n Kapasitas Penumpang : 10 orang"
    };


    int list_gambar[] = {
            R.drawable.jazz,
            R.drawable.innova,
            R.drawable.innovag,
            R.drawable.xenia,
            R.drawable.yaris,
            R.drawable.elf
    };

    //pendeklrasian variabel listview
    ListView LvM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LvM= (ListView) findViewById(R.id.LvM);

        AdapterMobil adapter = new AdapterMobil(this, tipe_mobil, list_gambar, deskripsi);

        LvM.setAdapter(adapter);
        LvM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // inten ke detail.java dengan mengirimkan parameter yang berisi nama dan gambar
                Intent a = new Intent(getApplicationContext(), DetailActivity.class);
                //kirimkan parameter
                a.putExtra("Nama", tipe_mobil[position]);
                a.putExtra("Gambar", list_gambar[position]);
                a.putExtra("Deskripsi", deskripsi[position]);

                //kirimkan ke detail.java
                startActivity(a);
            }
        });

    }


    // class di dalam class
    class AdapterMobil extends ArrayAdapter {
        String tipe_mobil[];
        String deskripsi[];
        int list_gambar[];
        Activity activity;

        //konstruktor
        public AdapterMobil(MainActivity mainActivity, String[] tipe_mobil, int[] list_gambar, String[] deskripsi) {
            super(mainActivity, R.layout.item_rv_list_user, tipe_mobil);
            this.list_gambar = list_gambar;
            activity = mainActivity;
            this.tipe_mobil = tipe_mobil;
            this.deskripsi = deskripsi;

        }

        //menthode yang digunakan untuk memanggil layout list_item dan mengenalkan widgetnya
        @NonNull

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // panggil layout list_item
            LayoutInflater inflater = (LayoutInflater) activity.getLayoutInflater();
            View v = inflater.inflate(R.layout.item_rv_list_user, null);
            // kenalkan widget yang ada pada list buah
            ImageView gambar;
            TextView nama;

            //casting widget id
            gambar = (ImageView) v.findViewById(R.id.img_mobil);
            nama = (TextView) v.findViewById(R.id.TxtNamaMobil);

            // set data kedalam image
            gambar.setImageResource(list_gambar[position]);
            nama.setText(tipe_mobil[position]);

            return v;
        }
    }


}