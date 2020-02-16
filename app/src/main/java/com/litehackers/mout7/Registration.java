package com.litehackers.mout7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    EditText etEmail, etPass, etName, etConPass;
    Button btnLogin, btnReg;
    DatabaseReference mout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        etEmail = findViewById(R.id.etEmail);
        etConPass = findViewById(R.id.etConPass);
        btnLogin = findViewById(R.id.btnReg);
        mout = FirebaseDatabase.getInstance().getReference();
        String email = etEmail.getText().toString();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, email, pass, conPass;

                name = etName.getText().toString();
                email = etEmail.getText().toString();
                pass = etPass.getText().toString();
                conPass = etConPass.getText().toString();
                if (name.equals("")) {
                    Toast.makeText(Registration.this, "Name Required", Toast.LENGTH_SHORT).show();
                } else if (email.equals("")) {
                    Toast.makeText(Registration.this, "Email Required", Toast.LENGTH_SHORT).show();
                } else if (pass.equals("")) {
                    Toast.makeText(Registration.this, "Password Required", Toast.LENGTH_SHORT).show();
                } else if (conPass.equals("")) {
                    Toast.makeText(Registration.this, "Password Required", Toast.LENGTH_SHORT).show();
                } else if (!conPass.equals(pass)) {
                    Toast.makeText(Registration.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Registration.this, Choice.class);
                    intent.putExtra("REG", email);
                    startActivity(intent);
                    //Authentication
                }
            }

        });
    }
}
