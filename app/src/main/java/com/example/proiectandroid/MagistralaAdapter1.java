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
import java.util.List;

public class MagistralaAdapter1 extends BaseAdapter {

    private List<Statie> statii;
    Context context;
    private LayoutInflater inflater;
    public MagistralaAdapter1(Context context, List<Statie> statii)
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
    public Statie getItem(int i) {
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
        Statie statie= statii.get(i);
        if(statie.id_linie<=4 || statie.id_linie>16)
            image.setColorFilter(Color.parseColor("#D7B300"));
        if(statie.id_linie==5 || statie.id_linie==6)
            image.setColorFilter(Color.parseColor("#000069"));
        if(statie.id_linie==7 || statie.id_linie==8)
            image.setColorFilter(Color.parseColor("#9B0000"));
        if(statie.id_linie==10 || statie.id_linie==9)
            image.setColorFilter(Color.parseColor("#024A02"));
        if(statie.id_linie<=16 && statie.id_linie>10)
            image.setColorFilter(Color.parseColor("#B16A01"));
        nume.setText(statie.nume_statie);
        return item;
    }


}
