package com.journaldev.barcodevisionapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(){
        EditText et_username = findViewById(R.id.et_username);
        EditText et_password = findViewById(R.id.et_password);
        Button bt_login = findViewById(R.id.bt_login);

        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        //Perform Auth
    }

    public void moveSignup(){
        TextView tv_signup = findViewById(R.id.tv_signup);
        Intent signupMover = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(signupMover);
    }
}
