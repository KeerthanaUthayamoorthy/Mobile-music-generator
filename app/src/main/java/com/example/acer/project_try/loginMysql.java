package com.example.acer.project_try;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


import javax.net.ssl.HttpsURLConnection;

public class loginMysql extends AppCompatActivity {
    EditText email, password;
    Button login, register;
    String log_email, log_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_mysql);

        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);
        login = (Button) findViewById(R.id.login_btn);
        register = (Button) findViewById(R.id.register_btn);
        log_email = email.getText().toString();
        log_pass = password.getText().toString();
        if (TextUtils.isEmpty(log_email)) {
            Toast.makeText(getApplicationContext(), "Enter an email address!!!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(log_pass)) {
            Toast.makeText(getApplicationContext(), "Enter password!!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (log_pass.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRegister();
            }
        });

    }

    public void userRegister() {

        String method = "register";
        BackgroundWorkerLogin backgroundWorkerLogin = new BackgroundWorkerLogin(this);
        backgroundWorkerLogin.execute(method, log_email, log_pass);
    }

    public void userLogin() {

        String method = "login";
        BackgroundWorkerLogin backgroundWorkerLogin = new BackgroundWorkerLogin(this);
        backgroundWorkerLogin.execute(method, log_email, log_pass);
    }

}





