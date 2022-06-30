package com.example.uas;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VolumeTabungActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtJariJari , edtTinggi;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_limas);

        edtJariJari = findViewById(R.id.edt_jarijari);
        edtTinggi = findViewById(R.id.edt_heightTube);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputJariJari = edtJariJari.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();
            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;
            if (TextUtils.isEmpty(inputJariJari)) {
                isEmptyFields = true;
                edtJariJari.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputTinggi)) {
                isEmptyFields = true;
                edtTinggi.setError("Field ini tidak boleh kosong");
            }
            Double r = toDouble(inputJariJari);
            Double t = toDouble(inputTinggi);
            if (r == null) {
                isInvalidDouble = true;
                edtJariJari.setError("Field ini harus berupa nomer yang valid");
            }
            if (t == null) {
                isInvalidDouble = true;
                edtTinggi.setError("Field ini harus berupa nomer yang valid");
            }
            if (!isEmptyFields && !isInvalidDouble) {
                double volume = 3.14 * r * r * t;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}