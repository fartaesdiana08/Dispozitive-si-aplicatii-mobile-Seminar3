package com.example.seminar3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreluareDate extends AppCompatActivity {

    Persoana persoana;
    Button button;

    EditText nume, prenume, email, dataNastere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preluare_date);

        persoana=new Persoana();

        button=findViewById(R.id.bSave);
        nume=findViewById(R.id.etNume);
        prenume=findViewById(R.id.etFirstName);
        email=findViewById(R.id.etEmail);
        dataNastere=findViewById(R.id.etData);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                    persoana.setNume(nume.getText().toString());
                    persoana.setPrenume(prenume.getText().toString());
                    persoana.setEmail(email.getText().toString());
                    persoana.setDataNastere(dataNastere.getText().toString());

                    //Toast.makeText(PreluareDate.this, persoana.toString(), Toast.LENGTH_LONG).show();
                    Bundle bundle=new Bundle();
                    bundle.putParcelable("OK", persoana);
                    Intent intent=new Intent();
                    intent.putExtra("persoanabundle", bundle);
                    setResult(RESULT_OK, intent);

                    //inchidem activitatea curenta
                    finish();
                }
            }
        });
    }
    private Boolean isValid() {
        if(nume.getText().toString().isEmpty()){
            Toast.makeText(PreluareDate.this, "Campul pentru nume nu este completat", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(prenume.getText().toString().isEmpty()){
            Toast.makeText(PreluareDate.this, "Campul pentru prenume nu este completat", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(email.getText().toString().isEmpty()){
            Toast.makeText(PreluareDate.this, "Campul pentru email nu este completat", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!isEmailValid(email.getText().toString())){
            Toast.makeText(PreluareDate.this, "Emailul nu respecta formatul", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(dataNastere.getText().toString().isEmpty()){
            Toast.makeText(PreluareDate.this, "Campul pentru data nasterii nu este completat", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}