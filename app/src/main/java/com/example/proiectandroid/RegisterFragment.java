package com.example.proiectandroid;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private  User user;
    private ArrayList<User> users;

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
        initializeComponents();


        return view;
    }

    private void initializeComponents()
    {
        tiet_nume=view.findViewById(R.id.tiet_nume);
        tiet_prenume=view.findViewById(R.id.tiet_prenume);
        tiet_email=view.findViewById(R.id.tiet_email);
        tiet_parola=view.findViewById(R.id.tiet_parola);
    }

    private void getUser()
    {
        String nume=tiet_nume.getText().toString();
        String prenume=tiet_prenume.getText().toString();
        String email=tiet_email.getText().toString();
        String parola=tiet_parola.getText().toString();
        user=new User(nume, prenume, email, parola);
    }

    private void readUsersFromDatabase()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //String value = dataSnapshot.child("newNode").getValue().toString();
                //String value = dataSnapshot.getValue().toString();
                users = (ArrayList<User>)(dataSnapshot.getValue());
                //Log.d("firebase_read", "Value is: " + users);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firebase_read", "Failed to read value.", error.toException());
            }
        });
    }
}