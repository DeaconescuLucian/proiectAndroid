package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AdaugareStatie extends AppCompatActivity {

    Button btn_adaugare_statie;
    TextInputEditText tiet_id_statie, tiet_nume, tiet_id_magistrala, tiet_id_vecin1, tiet_id_vecin2, tiet_id_vecin3;
    CheckBox cb_baie, cb_mancare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_statie);

    btn_adaugare_statie=findViewById(R.id.btn_adaugare_statie);
    tiet_id_statie=findViewById(R.id.tiet_id_statie);
    tiet_nume=findViewById(R.id.nume_statie);
    tiet_id_magistrala=findViewById(R.id.tiet_id_magistrala);
    tiet_id_vecin1=findViewById(R.id.id_vecin1);
    tiet_id_vecin2=findViewById(R.id.id_vecin2);
    tiet_id_vecin3=findViewById(R.id.id_vecin3);

    btn_adaugare_statie.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        Statie statie=new Statie(Integer.parseInt(tiet_id_statie.getText().toString()),tiet_nume.getText().toString(),
                Integer.parseInt(tiet_id_magistrala.getText().toString()), cb_baie.isChecked(),cb_mancare.isChecked(),
                Integer.parseInt(tiet_id_vecin1.getText().toString()), Integer.parseInt(tiet_id_vecin2.getText().toString()),
                Integer.parseInt(tiet_id_vecin3.getText().toString()));

        DataBaseHelper dataBaseHelper=new DataBaseHelper(AdaugareStatie.this);
        boolean success=dataBaseHelper.insereazaStatie(statie);
        if(success)
        {
            Toast.makeText(AdaugareStatie.this, statie.toString() +" a fost adaugata!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(AdaugareStatie.this,"Statia nu a fost adaugata!",Toast.LENGTH_SHORT).show();
        }
        }
    });

    }
}