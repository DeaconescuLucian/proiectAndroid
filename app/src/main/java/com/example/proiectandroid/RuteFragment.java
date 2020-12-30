package com.example.proiectandroid;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RuteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RuteFragment extends Fragment {

    private onFragmentButtonSelected listener;
    private MagistralaAdapter magistralaAdapter;
    Button btn;
    List<Statie> lista;
    ListView listview;
    Spinner spinner_start;
    Spinner spinner_destinatie;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "statii";


    // TODO: Rename and change types of parameters
    private ArrayList<Integer> mParam1=null;
    private long pos1;
    private long pos2;
    private AppDb database;


    public RuteFragment() {
        // Required empty public constructor

    }

    public RuteFragment(ArrayList<Integer> arr, long position1, long position2) {
        // Required empty public constructor
        mParam1=arr;
        pos1=position1;
        pos2=position2;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment RuteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RuteFragment newInstance(ArrayList<Integer> param1) {
        RuteFragment fragment = new RuteFragment();
        Bundle args = new Bundle();
        args.putIntegerArrayList(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (this.getArguments() != null) {
//            mParam1 = getArguments().getIntegerArrayList(ARG_PARAM1);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_rute, container, false);
//        if (this.getArguments() != null) {
//            mParam1 = getArguments().getIntegerArrayList(ARG_PARAM1);
//        }
        btn=view.findViewById(R.id.buton);
        listview=view.findViewById(R.id.listview);
        spinner_start=view.findViewById(R.id.spinner_statie_start);
        spinner_destinatie=view.findViewById(R.id.spinner_statie_end);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(),R.array.statii,R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner_start.setAdapter(adapter);
        spinner_destinatie.setAdapter(adapter);
        lista=new ArrayList<>();
//        DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
        database= Room.databaseBuilder(getContext(), AppDb.class, "STATII").allowMainThreadQueries().build();
        if(mParam1!=null)
        {
            for (Integer id: mParam1) {

                lista.add(database.statieDAO().getStatieById(id));
            }
            magistralaAdapter=new MagistralaAdapter(getActivity(),lista);
            listview.setAdapter(magistralaAdapter);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onButtonSelected(spinner_start.getSelectedItem().toString(),spinner_destinatie.getSelectedItem().toString(), spinner_start.getSelectedItemId(), spinner_destinatie.getSelectedItemId());
            }
        });
        spinner_start.setSelection((int)pos1);
        spinner_destinatie.setSelection((int)pos2);
        return view;
    }


    public interface onFragmentButtonSelected
    {
        public void onButtonSelected(String start,String end, long position1, long position2);
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        if(context instanceof onFragmentButtonSelected)
            listener=(onFragmentButtonSelected) context;
        else {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }
}