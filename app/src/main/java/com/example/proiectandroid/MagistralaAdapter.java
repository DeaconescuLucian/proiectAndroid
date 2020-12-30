package com.example.proiectandroid;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class MagistralaAdapter extends BaseAdapter {

    private ArrayList<Statie1> statii;
    Context context;
    private LayoutInflater inflater;
    public MagistralaAdapter(Context context, ArrayList<Statie1> statii)
    {
        this.statii=statii;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return statii.size();
    }

    @Override
    public Statie1 getItem(int i) {
        return statii.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View item=inflater.inflate(R.layout.item_magistrala,viewGroup,false);
        TextView nume=item.findViewById(R.id.nume_statie);
        ImageView image=item.findViewById(R.id.m_ico);

        image.setImageResource(R.drawable.metrou_galben);
        Statie1 statie= statii.get(i);
        if(statie.getId_linie()<=4 || statie.getId_linie()>16)
            image.setColorFilter(Color.parseColor("#D7B300"));
        if(statie.getId_linie()==5 || statie.getId_linie()==6)
            image.setColorFilter(Color.parseColor("#000069"));
        if(statie.getId_linie()==7 || statie.getId_linie()==8)
            image.setColorFilter(Color.parseColor("#9B0000"));
        if(statie.getId_linie()==10 || statie.getId_linie()==9)
            image.setColorFilter(Color.parseColor("#024A02"));
        if(statie.getId_linie()<=16 && statie.getId_linie()>10)
            image.setColorFilter(Color.parseColor("#B16A01"));
        nume.setText(statie.getNume());
        return item;
    }


}

