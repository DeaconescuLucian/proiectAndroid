package com.example.proiectandroid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MagistralaAdapter2 extends BaseAdapter {
    private List<Statii_cu_bai> statii;
    Context context;
    private LayoutInflater inflater;
    public MagistralaAdapter2(Context context, List<Statii_cu_bai> statii)
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
    public Statii_cu_bai getItem(int i) {
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
        image.setImageResource(R.drawable.bai);
        Statii_cu_bai statie= statii.get(i);
        image.setColorFilter(Color.parseColor("#0FADC3"));

        nume.setText(statie.nume_statie);
        return item;
    }

}
