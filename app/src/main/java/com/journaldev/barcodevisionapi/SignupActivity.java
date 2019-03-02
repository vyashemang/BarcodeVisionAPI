package com.journaldev.barcodevisionapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    EditText et_username = findViewById(R.id.et_username);
    EditText et_email = findViewById(R.id.et_email);
    EditText et_phone = findViewById(R.id.et_phone);
    EditText et_lastname = findViewById(R.id.et_lastname);
    EditText et_password = findViewById(R.id.et_password);
    Button bt_signup = findViewById(R.id.bt_signup);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final String username = et_username.getText().toString();
        final String email = et_password.getText().toString();
        final String firstname = et_phone.getText().toString();
        final String lastname = et_lastname.getText().toString();
        final String password = et_password.getText().toString();

        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://192.168.43.178:8000/register/";

                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    String res = jsonResponse.getString("status");
                                    Toast.makeText(SignupActivity.this, res, Toast.LENGTH_SHORT).show();
                                    //network = jsonResponse.getString("network");
                                    //System.out.println("Site: "+site+"\nNetwork: "+network);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<>();
                        // the POST parameters:
                        params.put("username", "test");
                        params.put("firstName", "Test");
                        params.put("lastName", "TestL");
                        params.put("email", "test@test.com");
                        params.put("password","pass@1123");
                        return params;
                    }
                };
                Volley.newRequestQueue(getApplicationContext()).add(postRequest);
            }
        });




    }

    public void moveLogin(){
        Intent loginMover = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(loginMover);
    }
}
