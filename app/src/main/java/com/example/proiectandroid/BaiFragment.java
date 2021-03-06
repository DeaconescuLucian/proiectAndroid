package com.example.proiectandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MagistralaAdapter2 magistralaAdapter2;
    private AppDb database;
    public BaiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BaiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BaiFragment newInstance(String param1, String param2) {
        BaiFragment fragment = new BaiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_abonamente, container, false);
        database= Room.databaseBuilder(getContext(), AppDb.class, "STATII_CU_BAI").allowMainThreadQueries().build();
        List<Statii_cu_bai> lista=database.statii_cu_baiDAO().getStatii_cu_bai();
        magistralaAdapter2=new MagistralaAdapter2(getActivity(),lista);
        ListView lvItem=view.findViewById(R.id.lv_abonamente);
        lvItem.setAdapter(magistralaAdapter2);
        return view;
    }
}