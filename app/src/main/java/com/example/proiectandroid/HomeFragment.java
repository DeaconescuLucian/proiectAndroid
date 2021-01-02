package com.example.proiectandroid;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private onRuteLayoutPressed listener4;
    private onProfilLayoutPressed listener5;
    private onDeconectareLayoutPressed listener6;
    private onAbonamenteLayoutPressed listener7;
    private onBaiLayoutPressed listener8;
    private onMagistralaLayoutPressed listener9;
    private ConstraintLayout l1;
    private ConstraintLayout l2;
    private ConstraintLayout l3;
    private ConstraintLayout l4;
    private ConstraintLayout l5;
    private ConstraintLayout l6,l7,l8,l9,l10,l11,l12;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private User userFromDatabase;
    public HomeFragment() {
        // Required empty public constructor
    }

    public HomeFragment(User user)
    {
        userFromDatabase=user;
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
        l1 = view.findViewById(R.id.l1);
        l2 = view.findViewById(R.id.l2);
        l4 = view.findViewById(R.id.l4);
        l5 = view.findViewById(R.id.l5);
        l6 = view.findViewById(R.id.l6);
        l7 = view.findViewById(R.id.l7);
        l8 = view.findViewById(R.id.l8);
        l9 = view.findViewById(R.id.l9);
        l10 = view.findViewById(R.id.l10);
        l11 = view.findViewById(R.id.l11);
        l12 = view.findViewById(R.id.l12);

        if(userFromDatabase==null)
        {
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
            l4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener4.onRutePressed();
                }
            });
            l5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener7.onAbonamentePressed();
                }
            });
            l6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener8.onBaiPressed();
                }
            });
            l7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(4,"DRISTOR2-PANTELIMON");
                }
            });
            l8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(5,"BERCENI-PIPERA");
                }
            });
            l9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(7,"PRECIZIEI-ANGHEL SALIGNY");
                }
            });
            l10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(10,"GARA DE NORD-STRAULESTI");
                }
            });
            l11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(16,"RAUL DOAMNEI-EROILOR");
                }
            });
            l12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(14,"VALEA IALOMITEI-EROILOR");
                }
            });
        }
        else
        {
            TextView tvl11=view.findViewById(R.id.register_home);
            tvl11.setText("Profil");
            TextView tvl12=view.findViewById(R.id.register_text);
            tvl12.setText("Vizualizeaza profilul");
            TextView tvl21=view.findViewById(R.id.login_home);
            tvl21.setText("Deconectare");
            TextView tvl22=view.findViewById(R.id.login_text);
            tvl22.setText("Paraseste aplicatia");
            ImageView img=view.findViewById(R.id.home_icon);
            img.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.logout, null));
            l1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener5.onProfilPressed();
                }
            });
            l2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener6.onDeconectarePressed();
                }
            });
            l4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener4.onRutePressed();
                }
            });
            l5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener7.onAbonamentePressed();
                }
            });
            l6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener8.onBaiPressed();
                }
            });
            l7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(4,"DRISTOR2-PANTELIMON");
                }
            });
            l8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(5,"BERCENI-PIPERA");
                }
            });
            l9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(7,"PRECIZIEI-ANGHEL SALIGNY");
                }
            });
            l10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(10,"GARA DE NORD-STRAULESTI");
                }
            });
            l11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(16,"RAUL DOAMNEI-EROILOR");
                }
            });
            l12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener9.onMagistralaPressed(14,"VALEA IALOMITEI-EROILOR");
                }
            });
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
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
        if(context instanceof onRuteLayoutPressed)
            listener4=(onRuteLayoutPressed) context;
        else
        {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
        if(context instanceof onProfilLayoutPressed)
            listener5=(onProfilLayoutPressed) context;
        else
        {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
        if(context instanceof onDeconectareLayoutPressed)
            listener6=(onDeconectareLayoutPressed) context;
        else
        {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
        if(context instanceof onAbonamenteLayoutPressed)
            listener7=(onAbonamenteLayoutPressed) context;
        else
        {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
        if(context instanceof onBaiLayoutPressed)
            listener8=(onBaiLayoutPressed) context;
        else
        {
            throw new ClassCastException(context.toString() + "must implement listener");
        }
        if(context instanceof onBaiLayoutPressed)
            listener9=(onMagistralaLayoutPressed) context;
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

    public interface onRuteLayoutPressed
    {
        public void onRutePressed();
    }

    public interface onProfilLayoutPressed
    {
        public void onProfilPressed();
    }

    public interface onDeconectareLayoutPressed
    {
        public void onDeconectarePressed();
    }

    public interface onAbonamenteLayoutPressed
    {
        public void onAbonamentePressed();
    }

    public interface onBaiLayoutPressed
    {
        public void onBaiPressed();
    }

    public interface onMagistralaLayoutPressed
    {
        public void onMagistralaPressed(int id,String nume);
    }

}