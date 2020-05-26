package com.example.chattestapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterLogin extends AppCompatActivity {
    Button registerBtn = null, loginBtn = null, continueBtn;
    LinearLayout registerBtnLL = null, loginBtnLL = null, formLL = null;
    Boolean loginBtnBool = true, registerBtnBool = false;
    int defaultSize;
    float px_Scale = getResources().getDisplayMetrics().density;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);

        formLL = (LinearLayout) findViewById(R.id.FormLL);

        registerBtn = findViewById(R.id.RegisterBtn);
        loginBtn = findViewById(R.id.LoginBtn);

        registerBtnLL = findViewById(R.id.RegisterBtnLL);
        loginBtnLL = findViewById(R.id.LoginBtnLL);

        continueBtn = findViewById(R.id.ContinueBtn);
        defaultSize = continueBtn.getLayoutParams().height;
        Toast.makeText(this, defaultSize + "", Toast.LENGTH_SHORT).show();
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

    private void CreateLogin(LinearLayout rootLL) {
        LinearLayout layout = CreateEditTextLL("UserName", "username", R.drawable.person, 1, InputType.TYPE_CLASS_TEXT);
        rootLL.addView(layout);
        layout = CreateEditTextLL("Password", "password", R.drawable.ic_lock_open, 1, InputType.TYPE_TEXT_VARIATION_PASSWORD);
        rootLL.addView(layout);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
        CheckBox rememberCB = new CheckBox(this);
        rememberCB.setLayoutParams(params);
        rememberCB.setText("Remember me.");
        rootLL.addView(rememberCB);
    }

    private void CreateRegister (LinearLayout rootLL)
    {
        LinearLayout layout = CreateEditTextLL("UserNeme", "Username", R.drawable.person, 1, InputType.TYPE_CLASS_TEXT);
        rootLL.addView(layout);
    }

    private LinearLayout CreateEditTextLL (String title, String hint, int imageID, int id, int inputType)
    {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -2);
                ImageView image = new ImageView(this);
                image.setLayoutParams(params);
                image.setImageResource(imageID);

                params = new LinearLayout.LayoutParams(-2, -2, 1.0f);
                TextView titleText = new TextView(this);
                titleText.setLayoutParams(params);
                titleText.setText(title);
//                titleText.setPadding(paddingHorizontal_px, 8, paddingHorizontal_px, 0);
                titleText.setTextColor(getResources().getColor(R.color.colorPrimary));

            params = new LinearLayout.LayoutParams(-1, -2);
            LinearLayout titleLL = new LinearLayout(this);
            titleLL.setLayoutParams(params);
            titleLL.setOrientation(LinearLayout.HORIZONTAL);
            titleLL.addView(image);
            titleLL.addView(titleText);

            EditText input = new EditText(this);
            input.setLayoutParams(params);
            int     paddingRight = input.getPaddingRight(),
                    paddingTop = input.getPaddingTop(),
                    paddingBottom = input.getPaddingBottom(),
                    paddingLeft = (int) (8 * px_Scale + 0.5f);
            input.setPadding(32, paddingTop, paddingRight, paddingBottom);
            input.setHint(hint);
            input.setInputType(inputType);
            input.setHintTextColor(getResources().getColor(R.color.colorPrimaryDark));
            input.setTextColor(getResources().getColor(R.color.colorPrimary));

        params.bottomMargin = 24;
        LinearLayout rootLL = new LinearLayout(this);
        rootLL.setLayoutParams(params);
        rootLL.setOrientation(LinearLayout.VERTICAL);
//        rootLL.setBackgroundColor(Color.parseColor("#555555"));
        rootLL.addView(titleLL);
        rootLL.addView(input);

        return rootLL;
    }

    public void LoginBtnClick(View view) {
        if (registerBtnBool) {
            EnableButton(loginBtnLL, loginBtn);
            loginBtnBool = true;
            formLL.removeAllViews();
            CreateLogin(formLL);
            DisableButton(registerBtnLL, registerBtn);
            registerBtnBool = false;
        } else Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
    }

    public void RegisterBtnClick(View view) {
        if (loginBtnBool) {
            EnableButton(registerBtnLL, registerBtn);
            registerBtnBool = true;
            formLL.removeAllViews();
            CreateRegister (formLL);
            DisableButton(loginBtnLL, loginBtn);
            loginBtnBool = false;
        } else Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
    }

    public void ContinueBtnClick(View view) {
    }
}
