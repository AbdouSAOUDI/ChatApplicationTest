package com.example.chattestapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterLogin extends AppCompatActivity {
    Button registerBtn = null, loginBtn = null;
    LinearLayout registerBtnLL = null, loginBtnLL = null;
    Boolean loginBtnBool = true, registerBtnBool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);

        registerBtn = findViewById(R.id.RegisterBtn);
        loginBtn = findViewById(R.id.LoginBtn);

        registerBtnLL = findViewById(R.id.RegisterBtnLL);
        loginBtnLL = findViewById(R.id.LoginBtnLL);
    }

    private void EnableButton(LinearLayout ll, Button btn) {
        int clr = R.color.colorPrimaryDark;
        ll.setBackgroundColor(getResources().getColor(clr));
        btn.setTextColor(Color.BLACK);
    }

    private void DisableButton(LinearLayout ll, Button btn) {
        int clr = R.color.colorPrimary;
        ll.setBackgroundColor(getResources().getColor(clr));
        clr = R.color.colorPrimaryDark;
        btn.setTextColor(getResources().getColor(clr));
    }

    public void LoginBtnClick(View view) {
        EnableButton(loginBtnLL, loginBtn);
        DisableButton(registerBtnLL, registerBtn);
    }

    public void RegisterBtnClick(View view) {
        EnableButton(registerBtnLL, registerBtn);
        DisableButton(loginBtnLL, loginBtn);
    }

    public void ContinueBtnClick(View view) {
    }
}
