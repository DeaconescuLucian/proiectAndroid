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

public class AbonamenteAdapter extends BaseAdapter {

    private List<StatiiAbonamentePentruStudenti> statii;
    Context context;
    private LayoutInflater inflater;
    public AbonamenteAdapter(Context context, List<StatiiAbonamentePentruStudenti> statii)
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
    public StatiiAbonamentePentruStudenti getItem(int i) {
        return statii.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View item=inflater.inflate(R.layout.item_abonament,viewGroup,false);
        if(i%2==1)
            item.setBackgroundColor(Color.parseColor("#343F49"));
        TextView nume=item.findViewById(R.id.tv_statie_abonament);
        TextView ore=item.findViewById(R.id.tv_ore);

        StatiiAbonamentePentruStudenti statie= statii.get(i);

        nume.setText(statie.nume_statie);
        ore.setText(statie.ore);
        return item;
    }


}