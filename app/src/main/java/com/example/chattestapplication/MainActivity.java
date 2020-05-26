package com.example.chattestapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText testET = null;
    TextView testTV = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void EnglishBtnClick(View view) {
        Intent mainToRegister = new Intent(getApplicationContext(), RegisterLogin.class);
        mainToRegister.putExtra("Type", true);
        Button btn = findViewById(R.id.EnglishBtn);
        mainToRegister.putExtra("Language", btn.getText().toString());
        startActivity(mainToRegister);
    }

    public void ToufikBtnClick(View view) {
        Intent mainToToufik = new Intent(this, ToufikList.class);
        startActivity(mainToToufik);
    }
}
