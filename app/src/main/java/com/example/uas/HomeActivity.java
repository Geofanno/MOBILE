package com.example.uas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnBiodata = findViewById(R.id.btn_biodata);
        btnBiodata.setOnClickListener(this);

        Button btnKalkulator = findViewById(R.id.btn_Kalkulator);
        btnKalkulator.setOnClickListener(this);

        Button btnVolKubus = findViewById(R.id.btn_kubus);
        btnVolKubus.setOnClickListener(this);

        Button btnVolBola = findViewById(R.id.btn_bola);
        btnVolBola.setOnClickListener(this);

        Button btnVolLimas = findViewById(R.id.btn_limas);
        btnVolLimas.setOnClickListener(this);

        Button btnVolTabung = findViewById(R.id.btn_tabung);
        btnVolTabung.setOnClickListener(this);

        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_biodata:
                Intent biodataIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(biodataIntent);
                break;
            case R.id.btn_Kalkulator:
                Intent kalkulatorIntent = new Intent(HomeActivity.this, KalkulatorActivity.class);
                startActivity(kalkulatorIntent);
                break;
            case R.id.btn_kubus:
                Intent kubusIntent = new Intent(HomeActivity.this, VolumeKubusActivity.class);
                startActivity(kubusIntent);
                break;
            case R.id.btn_bola:
                Intent bolaIntent = new Intent(HomeActivity.this, VolumeBolaActivity.class);
                startActivity(bolaIntent);
                break;
            case R.id.btn_limas:
                Intent limasIntent = new Intent(HomeActivity.this, VolumeLimasActivity.class);
                startActivity(limasIntent);
                break;
            case R.id.btn_tabung:
                Intent tabungIntent = new Intent(HomeActivity.this, VolumeTabungActivity.class);
                startActivity(tabungIntent);
                break;
            case R.id.btn_logout:
                Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                Intent logoutIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(logoutIntent);
                finish();

        }
    }

}