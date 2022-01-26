package com.geektech.java2hw6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private MaterialButton btn;
    private LinearLayout ll;
    private TextView top,one,two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.e_text_one);
        et2 = findViewById(R.id.e_text_two);
        btn = findViewById(R.id.btn);
        ll = findViewById(R.id.txt_linear);
        top = findViewById(R.id.txt_top);
        one = findViewById(R.id.txt_middle_one);
        two = findViewById(R.id.txt_middle_two);


        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (et1.getText().toString().equals("")) {
                    btn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                }
            }
        });
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (et2.getText().toString().equals("")) {
                    btn.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().equals("admin@gmail.com") || et2.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    one.setVisibility(View.GONE);
                    two.setVisibility(View.GONE);
                    top.setVisibility(View.GONE);
                    et1.setVisibility(View.GONE);
                    et2.setVisibility(View.GONE);
                    btn.setVisibility(View.GONE);
                    ll.setVisibility(View.GONE);
                } else{
                    Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}