package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView text;
    List<Statie> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.buton);
        text=findViewById(R.id.text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            DataBaseHelper dataBaseHelper=new DataBaseHelper(MainActivity.this);
            lista=dataBaseHelper.selecteazaStatii();
            text.setText(lista.get(0).toString());
            }
        });
    }

}