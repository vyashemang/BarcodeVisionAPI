package com.journaldev.barcodevisionapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnScanBarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        btnScanBarcode = findViewById(R.id.btnScanBarcode);
        btnScanBarcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, ScannedBarcodeActivity.class));
    }

    public void moveSignup(View v){
        Intent signupMover = new Intent(getApplicationContext(),SignupActivity.class);
        startActivity(signupMover);
    }

    public void moveLogin(View v){
        Intent loginMover = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(loginMover);
    }
}
