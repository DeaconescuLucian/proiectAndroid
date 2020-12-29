package com.example.proiectandroid;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment /*implements onRegisterTextPressed*/
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private onRegisterLayoutPressed listener;
    private onLoginLayoutPressed listener2;
    private onMagistraleLayoutPressed listener3;
    private onRuteLayoutPressed listener4;
    private ConstraintLayout l1;
    private ConstraintLayout l2;
    private ConstraintLayout l3;
    private ConstraintLayout l4;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        l1=view.findViewById(R.id.l1);
        l2=view.findViewById(R.id.l2);
        //l3=view.findViewById(R.id.l3);
        l4=view.findViewById(R.id.l4);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRegisterPressed();
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener2.onLoginPressed();
            }
        });
//        l3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener3.onMagistralePressed();
//            }
//        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener4.onRutePressed();
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof onRegisterLayoutPressed)
            listener=(onRegisterLayoutPressed) context;
        else
            {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
        if(context instanceof onLoginLayoutPressed)
            listener2=(onLoginLayoutPressed) context;
        else
        {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
        if(context instanceof onMagistraleLayoutPressed)
            listener3=(onMagistraleLayoutPressed) context;
        else
        {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
        if(context instanceof onRuteLayoutPressed)
            listener4=(onRuteLayoutPressed) context;
        else
        {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
    }

    public interface onRegisterLayoutPressed
    {
        public void onRegisterPressed();
    }

    public interface onLoginLayoutPressed
    {
        public void onLoginPressed();
    }

    public interface onMagistraleLayoutPressed
    {
        public void onMagistralePressed();
    }

    public interface onRuteLayoutPressed
    {
        public void onRutePressed();
    }
}