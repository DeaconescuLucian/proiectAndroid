package com.example.proiectandroid;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    private TextInputEditText tiet_nume;
    private TextInputEditText tiet_prenume;
    private TextInputEditText tiet_email;
    private TextInputEditText tiet_parola;
    private Button btn_register;
    private  User user;
    private ArrayList<User> users;
    private Registration listener;
    private String nume;
    private String prenume;
    private String email;
    private String parola;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initializeComponents();
//        getUser();
//
//        user=new User(nume, prenume, email, parola);
//        Log.v("user", user.toString());
//
//        btn_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.clickRegisterButton(nume, prenume, email, parola);
//            }
//        });
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_register, container, false);
        ImageView img_nume=(ImageView) view.findViewById(R.id.img_nume);
        img_nume.setColorFilter(Color.parseColor("#FFFFFF"));
        ImageView img_prenume=(ImageView) view.findViewById(R.id.img_prenume);
        img_prenume.setColorFilter(Color.parseColor("#FFFFFF"));
        ImageView img_email=(ImageView) view.findViewById(R.id.img_email);
        img_email.setColorFilter(Color.parseColor("#FFFFFF"));
        ImageView img_pass=(ImageView) view.findViewById(R.id.img_pass);
        img_pass.setColorFilter(Color.parseColor("#FFFFFF"));

        btn_register=view.findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickRegisterButton();
            }
        });

        return view;
    }

    private void initializeComponents()
    {
        tiet_nume=view.findViewById(R.id.tiet_nume);
        tiet_prenume=view.findViewById(R.id.tiet_prenume);
        tiet_email=view.findViewById(R.id.tiet_email);
        tiet_parola=view.findViewById(R.id.tiet_parola);
        btn_register=view.findViewById(R.id.btn_register);
    }

    private void getUser()
    {
        nume=tiet_nume.getText().toString();
        prenume=tiet_prenume.getText().toString();
        email=tiet_email.getText().toString();
        parola=tiet_parola.getText().toString();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof RegisterFragment.Registration)
            listener=(RegisterFragment.Registration) context;
        else {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }

    public interface Registration
    {
//        public abstract void clickRegisterButton(String nume, String prenume, String email, String parola);
        public abstract void clickRegisterButton();
    }
}