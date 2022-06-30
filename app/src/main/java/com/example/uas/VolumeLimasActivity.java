package com.example.uas;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VolumeLimasActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtSideLength , edtHeightPyramid , edtSideHeightPyramid;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_limas);

        edtSideLength = findViewById(R.id.edt_sideLength);
        edtHeightPyramid = findViewById(R.id.edt_heightPyramid);
        edtSideHeightPyramid = findViewById(R.id.edt_sideHeightPyramid);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputSideLength = edtSideLength.getText().toString().trim();
            String inputHeightPyramid = edtHeightPyramid.getText().toString().trim();
            String inputSideHeightPyramid = edtSideHeightPyramid.getText().toString().trim();
            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;
            if (TextUtils.isEmpty(inputSideLength)) {
                isEmptyFields = true;
                edtSideLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeightPyramid)) {
                isEmptyFields = true;
                edtHeightPyramid.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputSideHeightPyramid)) {
                isEmptyFields = true;
                edtSideHeightPyramid.setError("Field ini tidak boleh kosong");
            }
            Double sl = toDouble(inputSideLength);
            Double hp = toDouble(inputHeightPyramid);
            Double shp = toDouble(inputSideHeightPyramid);
            if (sl == null) {
                isInvalidDouble = true;
                edtSideLength.setError("Field ini harus berupa nomer yang valid");
            }
            if (hp == null) {
                isInvalidDouble = true;
                edtHeightPyramid.setError("Field ini harus berupa nomer yang valid");
            }
            if (shp == null) {
                isInvalidDouble = true;
                edtSideHeightPyramid.setError("Field ini harus berupa nomer yang valid");
            }
            if (!isEmptyFields && !isInvalidDouble) {
                double volume = sl * hp * shp / 3;
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