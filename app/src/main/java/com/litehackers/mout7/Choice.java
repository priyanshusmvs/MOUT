package com.litehackers.mout7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Choice extends AppCompatActivity {

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Intent intent = getIntent();
        email = getIntent().getStringExtra("REG");


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_male: {
                if (checked) {
                    Intent intent = new Intent(Choice.this, QR_generator.class);
                    intent.putExtra("REG", email);
                    startActivity(intent);
                }
            }
            break;

            case R.id.radio_female: {
                if (checked) {
                    Toast.makeText(Choice.this, "Thank you!! Have Fun...", Toast.LENGTH_SHORT).show();
                }
            }
            break;
        }
    }
}
