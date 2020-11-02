package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AdaugareMagistrala extends AppCompatActivity {

    Button btn_adaugare_magistrala;
    EditText tiet_id_magistrala, tiet_nume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_magistrala);

        btn_adaugare_magistrala=findViewById(R.id.btn_adaugare_magistrala);
        tiet_id_magistrala=findViewById(R.id.tiet_id_magistrala);
        tiet_nume=findViewById(R.id.nume_magistrala);

//        btn_adaugare_magistrala.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            Magistrala magistrala=new Magistrala(Integer.parseInt(tiet_id_magistrala.getText().toString()),
//                    tiet_nume.getText().toString());
//
//            DataBaseHelper dataBaseHelper=new DataBaseHelper(AdaugareMagistrala.this);
//            boolean success=dataBaseHelper.insereazaMagistrale(magistrala);
//            if(success)
//            {
//                Toast.makeText(AdaugareMagistrala.this, magistrala.toString()+" a fost adaugata", Toast.LENGTH_SHORT).show();
//            }
//            else
//            {
//                Toast.makeText(AdaugareMagistrala.this,"Magistrala nu a fost adaugata!", Toast.LENGTH_SHORT).show();
//            }
//            }
//        });
    }
}