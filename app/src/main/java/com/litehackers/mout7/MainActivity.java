package com.litehackers.mout7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btnLogin, btnReg;
    TextView tvReg;
    String ss;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);

        btnLogin = findViewById(R.id.btnLogin);
        tvReg = findViewById(R.id.tvReg);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, pass;

                email = etEmail.getText().toString();
                pass = etPass.getText().toString();

                if (email.equals("")) {
                    Toast.makeText(MainActivity.this, "Email Required", Toast.LENGTH_SHORT).show();
                } else if (pass.equals("")) {
                    Toast.makeText(MainActivity.this, "Password Required", Toast.LENGTH_SHORT).show();
                } else {
                    //Authentication
                    Intent intent = new Intent(MainActivity.this, Choice.class);
                    ss = etEmail.getText().toString();
                    intent.putExtra("REG", ss);
                    startActivity(intent);
                }
            }

        });

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Registration.class);
                startActivity(i);
                finish();
            }
        });


    }
}
