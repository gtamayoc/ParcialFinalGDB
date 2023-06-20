package com.example.parcialfinalgdb.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.parcialfinalgdb.R;

public class Login extends AppCompatActivity {

    EditText editTextTextPassword, editTextText;
    Button login, registro;
    ImageView config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadComponents();
        configComponents();
    }

    private void configComponents() {
        editTextTextPassword.getText();
        editTextText.getText();
        login.setOnClickListener(onClickListener);
        registro.setOnClickListener(onClickListener);
        config.setOnClickListener(onClickListener);
    }

    private void loadComponents() {
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextText = findViewById(R.id.editTextText);
        login = findViewById(R.id.button);
        registro = findViewById(R.id.button2);
        config = findViewById(R.id.imageView);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.button) {
                Intent intent = new Intent(Login.this, Main.class);
                startActivity(intent);
            }
            if (id == R.id.button2) {
                Intent intent = new Intent(Login.this, Main.class);
                startActivity(intent);
            }
        }
    };
}