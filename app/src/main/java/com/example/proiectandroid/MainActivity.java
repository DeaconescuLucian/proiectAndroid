package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn_adaugare_magistrala;
    EditText tiet_id_magistrala, tiet_nume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_magistrala);
        btn_adaugare_magistrala=findViewById(R.id.btn_adaugare_magistrala);
        tiet_id_magistrala=findViewById(R.id.tiet_id_magistrala);
        tiet_nume=findViewById(R.id.nume_magistrala);

        btn_adaugare_magistrala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Magistrala magistrala;
            try {
                magistrala=new Magistrala(Integer.parseInt(tiet_id_magistrala.getText().toString()),
                        tiet_nume.getText().toString());
            }
            catch (Exception exception)
            {
                magistrala=new Magistrala(-1,null);
            }

            DataBaseHelper dataBaseHelper=new DataBaseHelper(MainActivity.this);
            boolean success=dataBaseHelper.insereazaMagistrale(magistrala);
            if(success)
            {
                Toast.makeText(MainActivity.this, magistrala.toString()+" a fost adaugata", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this,"Magistrala nu a fost adaugata!", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }

}