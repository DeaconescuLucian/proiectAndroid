package com.example.proiectandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMagistrala#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMagistrala extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id";
    private static final String ARG_PARAM2 = "Nume Magistrala";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;

    private MagistralaAdapter1 magistralaAdapter;
    private AppDb database;

    public FragmentMagistrala() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMagistrala.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMagistrala newInstance(int param1, String param2) {
        FragmentMagistrala fragment = new FragmentMagistrala();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_magistrala, container, false);
        ListView lvItem=view.findViewById(R.id.lv_items);
        TextView textView=view.findViewById(R.id.tv);
        textView.setText(mParam2);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
//            DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
            List<Statie> lista;
//            lista = dataBaseHelper.selecteazaStatii(mParam1);
            database= Room.databaseBuilder(getContext(), AppDb.class, "STATII").allowMainThreadQueries().build();
            lista=database.statieDAO().getStatiiByIdLinie(mParam1);
            magistralaAdapter=new MagistralaAdapter1(getActivity(),lista);
            lvItem.setAdapter(magistralaAdapter);
        }
        return view;
    }
}
