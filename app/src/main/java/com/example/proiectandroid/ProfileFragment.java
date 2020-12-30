package com.example.proiectandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView lv_statii;
    private AppDb database;
    private TextView tv;


    private User userFromDatabase;
    private TextView tv_nume;
    private TextView tv_email;


    public ProfileFragment() {
        // Required empty public constructor
    }

    public ProfileFragment(User user)
    {
        userFromDatabase=user;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        tv_nume=view.findViewById(R.id.tv_nume);
        tv_email=view.findViewById(R.id.tv_email);

        tv_nume.setText(userFromDatabase.getNume()+" "+userFromDatabase.getUsername());
        tv_email.setText(userFromDatabase.getEmail());





        return view;
    }
}






////        database=Room.databaseBuilder(getContext(), AppDb.class, "metrorex.db")
////                .addMigrations(new Migration(1,2) {
////                    @Override
////                    public void migrate(@NonNull SupportSQLiteDatabase database) {
////
////                    }
////                }).build();
////        database=Room.databaseBuilder(getContext(), AppDb.class, "METROREX").
////                 createFromAsset("databases/metrorex.db").build();
//        database= Room.databaseBuilder(getContext(),AppDb.class, "STATII").allowMainThreadQueries().build();
////        lv_statii=view.findViewById(R.id.lv_statii);
//
////        ArrayAdapter<Statie> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,database.statieDAO().getStatii());
//
////        lv_statii.setAdapter(adapter);
//
//        tv=view.findViewById(R.id.tv_statii);
//        tv.setText(database.statieDAO().getStatii().toString());


//        database= Room.databaseBuilder(getContext(),AppDb.class, "LINII").allowMainThreadQueries().build();

//        tv=view.findViewById(R.id.tv_statii);
//        database=Room.databaseBuilder(getContext(), AppDb.class, "STATII")
//               .allowMainThreadQueries().build();
//
//        tv.setText(database.statieDAO().getStatii().toString());

//        database=Room.databaseBuilder(getContext(), AppDb.class, "LINII")
//                .allowMainThreadQueries().build();
//        tv.setText(database.linieDAO().getLinii().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "ANGHELSALIGNY_PRECIZIEI")
//                .allowMainThreadQueries().build();
//        tv.setText(database.anghelSaligny_precizieiDAO().getTimpiAnghelSaligny_Preciziei().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "DRISTOR1_EROILOR")
//                .allowMainThreadQueries().build();
//        tv.setText(database.dristor1_eroilorDAO().getTimpiDristor1_Eroilor().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "EROILOR2_ROMANCIERILOR")
//                .allowMainThreadQueries().build();
//        tv.setText(database.eroilor2_romancierilorDAO().getTimpiEroilor2_Romancierilor().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "GARADENORD_STRAULESTI")
//                .allowMainThreadQueries().build();
//        tv.setText(database.garaDeNord_straulestiDAO().getTimpiGaraDeNord_Straulesti().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "LEGATURI")
//                .allowMainThreadQueries().build();
//        tv.setText(database.legaturiDAO().getLegaturi().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "PIPERA_BERCENI")
//                .allowMainThreadQueries().build();
//        tv.setText(database.pipera_berceniDAO().getTimpiPipera_Berceni().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "RAULDOAMNEI_EROILOR2")
//                .allowMainThreadQueries().build();
//        tv.setText(database.raulDoamnei_eroilor2DAO().getTimpiRaulDoamnei_Eroilor2().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "REPUBLICA_DRISTOR2")
//                .allowMainThreadQueries().build();
//        tv.setText(database.republica_dristor2DAO().getTimpiRepublica_Dristor2().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "REPUBLICA_PANTELIMON")
//                .allowMainThreadQueries().build();
//        tv.setText(database.republica_pantelimonDAO().getTimpiRepublica_Pantelimon().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "STATII_ABONAMENTE_PENTRU_STUDENTI")
//                .allowMainThreadQueries().build();
//        tv.setText(database.statiiAbonamentePentruStudentiDAO().getStatiiAbonamentePentruStudenti().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "STATII_CU_BAI")
//                .allowMainThreadQueries().build();
//        tv.setText(database.statii_cu_baiDAO().getStatii_cu_bai().toString());
//        database=Room.databaseBuilder(getContext(), AppDb.class, "VALEAIALOMITEI_EROILOR2")
//                .allowMainThreadQueries().build();
//        tv.setText(database.valeaIalomitei_eroilor2DAO().getTimpiValeaIalomitei_Eroilor2().toString());
