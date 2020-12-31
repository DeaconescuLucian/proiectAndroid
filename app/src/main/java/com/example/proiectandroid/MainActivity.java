package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.ListIterator;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,RuteFragment.onFragmentButtonSelected, HomeFragment.onRegisterLayoutPressed, HomeFragment.onLoginLayoutPressed, HomeFragment.onMagistraleLayoutPressed, HomeFragment.onRuteLayoutPressed,RegisterFragment.Registration, LoginFragment.Login, HomeFragment.onProfilLayoutPressed, HomeFragment.onDeconectareLayoutPressed {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    List<Statie> lista;
    ArrayList<NodGraf> graf;
    List<Legaturi> lista1;
    ListView listview;
    TimpAsteptare ANGHELSALIGNY_PRECIZIEI,DRISTOR1_EROILOR,EROILOR2_ROMANCIERILOR,
            GARADENORD_STRAULESTI,PIPERA_BERCENI,RAULDOAMNEI_EROILOR2,REPUBLICA_DRISTOR2,REPUBLICA_PANTELIMON,VALEAIALOMITEI_EROILOR2;
    ArrayList<Ruta> rute;
    MagistralaAdapter magistralaAdapter;
    private ArrayList<User> users;
    private User user;
    private TextInputEditText tiet_nume;
    private TextInputEditText tiet_username;
    private TextInputEditText tiet_email;
    private TextInputEditText tiet_parola;
    private Button btn_register;
    private String nume;
    private String username;
    private String email;
    private String parola;
    private TextInputEditText tiet_username_login;
    private TextInputEditText tiet_parola_login;
    private String username_login;
    private String parola_login;
    private User userFromDatabase;
    private AppDb database;
    private List<Statie1> statie1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String tabele[]={"ANGHELSALIGNY_PRECIZIEI","DRISTOR1_EROILOR","EROILOR2_ROMANCIERILOR",
                "GARADENORD_STRAULESTI","PIPERA_BERCENI","RAULDOAMNEI_EROILOR2","REPUBLICA_DRISTOR2","REPUBLICA_PANTELIMON","VALEAIALOMITEI_EROILOR2","STATII","STATII_CU_BAI","STATII_ABONAMENTE_PENTRU_STUDENTI"};
        for(String tabela : tabele)
        {
            create_database(tabela);
        }
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        statie1=new ArrayList<>();
        userFromDatabase=null;

        if(userFromDatabase==null)
        {
            NavigationView navigationView=findViewById(R.id.navigationView);
            Menu menu=navigationView.getMenu();
            menu.findItem(R.id.deconectare).setVisible(false);
        }

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, new HomeFragment());
        fragmentTransaction.commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId()==R.id.m1)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,FragmentMagistrala.newInstance(4,"DRISTOR2-PANTELIMON"));
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.m2)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,FragmentMagistrala.newInstance(5,"BERCENI-PIPERA"));
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.m3)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,FragmentMagistrala.newInstance(7,"PRECIZIEI-ANGHEL SALIGNY"));
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.m4)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,FragmentMagistrala.newInstance(10,"GARA DE NORD-STRAULESTI"));
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.m5)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,FragmentMagistrala.newInstance(16,"RAUL DOAMNEI-EROILOR"));
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.rute)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new RuteFragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.home)
        {
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new HomeFragment(userFromDatabase));
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.deconectare)
        {
            NavigationView navigationView=findViewById(R.id.navigationView);
            Menu menu=navigationView.getMenu();
            menu.findItem(R.id.deconectare).setVisible(false);
            userFromDatabase=null;
            fragmentManager=getSupportFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment,new HomeFragment(userFromDatabase));
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.profile)
        {
            if(userFromDatabase==null)
            {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, new LoginFragment());
                fragmentTransaction.commit();
            }
            else
            {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, new ProfileFragment(userFromDatabase));
                fragmentTransaction.commit();
            }
        }
        return true;
    }

    @Override
    public void onButtonSelected(String start,String end, long position1, long position2)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 10);
        String ora_curenta=formatter.format(cal.getTime());
        Log.v("mora",ora_curenta);
//        DataBaseHelper dataBaseHelper=new DataBaseHelper(this);
        database= Room.databaseBuilder(getApplicationContext(), AppDb.class, "STATII").allowMainThreadQueries().build();
        lista=database.statieDAO().getStatii();
        for(Statie statie : lista)
        {
            Statie1 s=new Statie1(statie.id_statie, statie.id_linie, statie.nume_statie, statie.vecini);
            statie1.add(s);
        }
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "LEGATURI") .allowMainThreadQueries().build();
        lista1=database.legaturiDAO().getLegaturi();
//        lista=dataBaseHelper.selecteazaStatii();
//        lista1=dataBaseHelper.selecteazaLegaturi();
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "ANGHELSALIGNY_PRECIZIEI") .allowMainThreadQueries().build();
        List<AnghelSaligny_Preciziei> l1=database.anghelSaligny_precizieiDAO().getAnghelSaligny_Preciziei();
        for (AnghelSaligny_Preciziei anghelSaligny_preciziei:l1)
        {
            if(anghelSaligny_preciziei.selecteazaTimpiAsteptare(ora_curenta))
                ANGHELSALIGNY_PRECIZIEI=new TimpAsteptare(anghelSaligny_preciziei.interval_orar, anghelSaligny_preciziei.timp);
        }
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "DRISTOR1_EROILOR") .allowMainThreadQueries().build();
        List<Dristor1_Eroilor> l2=database.dristor1_eroilorDAO().getDristor1_Eroilor();
        for (Dristor1_Eroilor dristor1_eroilor : l2)
        {
            if(dristor1_eroilor.selecteazaTimpiAsteptare(ora_curenta))
                DRISTOR1_EROILOR=new TimpAsteptare(dristor1_eroilor.interval_orar, dristor1_eroilor.timp);
        }
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "EROILOR2_ROMANCIERILOR") .allowMainThreadQueries().build();
        List<Eroilor2_Romancierilor> l3=database.eroilor2_romancierilorDAO().getEroilor2_Romancierilor();
        for (Eroilor2_Romancierilor eroilor2_romancierilor : l3)
        {
            if(eroilor2_romancierilor.selecteazaTimpiAsteptare(ora_curenta))
                EROILOR2_ROMANCIERILOR=new TimpAsteptare(eroilor2_romancierilor.interval_orar, eroilor2_romancierilor.timp);
        }
//        DRISTOR1_EROILOR=dataBaseHelper.selecteazaTimpDeAsteptare("DRISTOR1_EROILOR",ora_curenta);
//        EROILOR2_ROMANCIERILOR=dataBaseHelper.selecteazaTimpDeAsteptare("EROILOR2_ROMANCIERILOR",ora_curenta);
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "GARADENORD_STRAULESTI") .allowMainThreadQueries().build();
        List<GaraDeNord_Straulesti> l4=database.garaDeNord_straulestiDAO().getGaraDeNord_Straulesti();
        for (GaraDeNord_Straulesti garaDeNord_straulesti : l4)
        {
            if(garaDeNord_straulesti.selecteazaTimpiAsteptare(ora_curenta))
                GARADENORD_STRAULESTI=new TimpAsteptare(garaDeNord_straulesti.interval_orar, garaDeNord_straulesti.timp);
        }
//        GARADENORD_STRAULESTI=dataBaseHelper.selecteazaTimpDeAsteptare("GARADENORD_STRAULESTI",ora_curenta);
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "PIPERA_BERCENI") .allowMainThreadQueries().build();
        List<Pipera_Berceni> l5=database.pipera_berceniDAO().getPipera_Berceni();
        for (Pipera_Berceni pipera_berceni : l5)
        {
            if(pipera_berceni.selecteazaTimpiAsteptare(ora_curenta))
                PIPERA_BERCENI=new TimpAsteptare(pipera_berceni.interval_orar, pipera_berceni.timp);
        }
//        PIPERA_BERCENI=dataBaseHelper.selecteazaTimpDeAsteptare("PIPERA_BERCENI",ora_curenta);
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "RAULDOAMNEI_EROILOR2") .allowMainThreadQueries().build();
        List<RaulDoamnei_Eroilor2> l6=database.raulDoamnei_eroilor2DAO().getRaulDoamnei_Eroilor2();
        for (RaulDoamnei_Eroilor2 raulDoamnei_eroilor2 : l6)
        {
            if(raulDoamnei_eroilor2.selecteazaTimpiAsteptare(ora_curenta))
                RAULDOAMNEI_EROILOR2=new TimpAsteptare(raulDoamnei_eroilor2.interval_orar, raulDoamnei_eroilor2.timp);
        }
//        RAULDOAMNEI_EROILOR2=dataBaseHelper.selecteazaTimpDeAsteptare("RAULDOAMNEI_EROILOR2",ora_curenta);
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "REPUBLICA_DRISTOR2") .allowMainThreadQueries().build();
        List<Republica_Dristor2> l7=database.republica_dristor2DAO().getRepublica_Dristor2();
        for (Republica_Dristor2 republica_dristor2 : l7)
        {
            if(republica_dristor2.selecteazaTimpiAsteptare(ora_curenta))
                REPUBLICA_DRISTOR2=new TimpAsteptare(republica_dristor2.interval_orar, republica_dristor2.timp);
        }
//        REPUBLICA_DRISTOR2=dataBaseHelper.selecteazaTimpDeAsteptare("REPUBLICA_DRISTOR2",ora_curenta);
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "REPUBLICA_PANTELIMON") .allowMainThreadQueries().build();
        List<Republica_Pantelimon> l8=database.republica_pantelimonDAO().getRepublicaPantelimon();
        for (Republica_Pantelimon republica_pantelimon : l8)
        {
            if(republica_pantelimon.selecteazaTimpiAsteptare(ora_curenta))
                REPUBLICA_PANTELIMON=new TimpAsteptare(republica_pantelimon.interval_orar, republica_pantelimon.timp);
        }
//        REPUBLICA_PANTELIMON=dataBaseHelper.selecteazaTimpDeAsteptare("REPUBLICA_PANTELIMON",ora_curenta);
        database=Room.databaseBuilder(getApplicationContext(), AppDb.class, "VALEAIALOMITEI_EROILOR2") .allowMainThreadQueries().build();
        List<ValeaIalomitei_Eroilor2> l9=database.valeaIalomitei_eroilor2DAO().getValeaIalomitei_Eroilor2();
        for (ValeaIalomitei_Eroilor2 valeaIalomitei_eroilor2 : l9)
        {
            if(valeaIalomitei_eroilor2.selecteazaTimpiAsteptare(ora_curenta))
                VALEAIALOMITEI_EROILOR2=new TimpAsteptare(valeaIalomitei_eroilor2.interval_orar, valeaIalomitei_eroilor2.timp);
        }
//        VALEAIALOMITEI_EROILOR2=dataBaseHelper.selecteazaTimpDeAsteptare("VALEAIALOMITEI_EROILOR2",ora_curenta);
        graf =new ArrayList<>();
        for(Statie1 statie : statie1)
        {
            String vecini1="";
            if(statie.getVecini()!=null)
            {
                for (int i = 0; i < statie.getVecini().length; i++) {
                    if (i < statie.getVecini().length - 1) {
                        vecini1 += statie.getVecini()[i] + ",";
                    }
                    if (i == statie.getVecini().length - 1) {
                        vecini1 += statie.getVecini()[i];
                    }
                }
                NodGraf nod=new NodGraf(statie.getId_statie(),statie.getId_linie(),statie.getNume(),vecini1);
                graf.add(nod);
            }
            else
            {
                NodGraf nod = new NodGraf(statie.getId_statie(), statie.getId_linie(), statie.getNume(), null);
                graf.add(nod);
            }
        }
        rute=new ArrayList<>();
        for(NodGraf nod : graf)
        {
            if(nod.getNume().equals(start))
            {
                Ruta ruta=Djikstra(graf,nod,end);
                if(ruta!=null)
                {
                    rute.add(ruta);
                }
            }

        }

        Collections.sort(rute);
        //Log.v("msg",rute.get(0).toString());
        ArrayList<Integer> arr=new ArrayList<>();
        for (Statie1 statie: rute.get(0).getStatii()) {
            arr.add(statie.getId_statie());
        }

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new RuteFragment(arr, position1, position2));
        fragmentTransaction.commit();
    }

    private Ruta Djikstra(ArrayList<NodGraf> graf,NodGraf start,String nume_nod_end)
    {
        ArrayList<NodGraf> noduri_nevizitate = new ArrayList<>();
        ArrayList<NodGraf> noduri_vizitate = new ArrayList<>();
        NodGraf lastNode=null;
        start.setDistance(0);
        noduri_nevizitate.add(start);
        while(noduri_nevizitate.size()>0) {
            Collections.sort(noduri_nevizitate);
            NodGraf extras = noduri_nevizitate.get(0);
            noduri_vizitate.add(extras);
            noduri_nevizitate.remove(0);
            extras.setVizitat(true);
            String[] vector_vecini;
            if(extras.getVecini()!=null)
            {
                vector_vecini = extras.getVecini();

                ArrayList<Integer> vecini = new ArrayList<>();
                for (int i = 0; i < vector_vecini.length; i++) {
                    vecini.add(Integer.parseInt(vector_vecini[i]));
                }
                for (Integer i : vecini) {
                    for (NodGraf nod : graf) {
                        if(nod.getId_statie()==i)
                        {
                            if(extras.getId_linie()==nod.getId_linie())
                            {
                                if(extras.getId_statie()==161 && nod.getId_statie()==162)
                                    Log.v("extras","161-162");
                                for (Legaturi leg : lista1)
                                {
                                    if (leg.id_vecin1 == extras.getId_statie() && leg.id_vecin2 == i) {

                                        if(nod.getDistance()>extras.getDistance()+leg.timp)
                                        {
                                            if(!nod.getNume().equals(start.getNume()))
                                            {
                                                nod.setDistance(extras.getDistance()+leg.timp);
                                                nod.setId_previous(extras.getId_statie());
                                            }
                                            if(!nod.getNume().equals(nume_nod_end) && nod.isVizitat()==false)
                                            {
                                                noduri_nevizitate.add(nod);
                                            }
                                            else {
                                                if (lastNode != null && nod.getNume().equals(nume_nod_end)) {
                                                    if (nod.getDistance() < lastNode.getDistance()) {
                                                        lastNode = nod;
                                                    }
                                                } else {
                                                    if(nod.getNume().equals(nume_nod_end) && lastNode==null)
                                                        lastNode = nod;
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                            if(extras.getId_linie()!=nod.getId_linie())
                            {
                                int timp=0;
                                if(nod.getId_linie()==1 || nod.getId_linie()==2)
                                {
                                    timp=REPUBLICA_DRISTOR2.getTimp();
                                }
                                if(nod.getId_linie()==3 || nod.getId_linie()==4)
                                {
                                    timp=REPUBLICA_PANTELIMON.getTimp();
                                }
                                if(nod.getId_linie()==5 || nod.getId_linie()==6)
                                {
                                    timp=PIPERA_BERCENI.getTimp();
                                }
                                if(nod.getId_linie()==7 || nod.getId_linie()==8)
                                {
                                    timp=ANGHELSALIGNY_PRECIZIEI.getTimp();
                                }
                                if(nod.getId_linie()==9 || nod.getId_linie()==10)
                                {
                                    timp=GARADENORD_STRAULESTI.getTimp();
                                }
                                if(nod.getId_linie()==11 || nod.getId_linie()==12)
                                {
                                    timp=EROILOR2_ROMANCIERILOR.getTimp();
                                }
                                if(nod.getId_linie()==13 || nod.getId_linie()==14)
                                {
                                    timp=VALEAIALOMITEI_EROILOR2.getTimp();
                                }
                                if(nod.getId_linie()==15 || nod.getId_linie()==16)
                                {
                                    timp=RAULDOAMNEI_EROILOR2.getTimp();
                                }
                                if (nod.getId_linie()==17 || nod.getId_linie()==18)
                                {
                                    timp=DRISTOR1_EROILOR.getTimp();
                                }
                                if(nod.getDistance()>extras.getDistance()+timp)
                                {
                                    nod.setDistance(extras.getDistance()+timp);
                                    nod.setId_previous(extras.getId_statie());
                                }
                                if(nod.isVizitat()==false)
                                {
                                    noduri_nevizitate.add(nod);
                                }

                            }
                        }

                    }
                }
            }

        }

        if(lastNode!=null)
        {
            ArrayList<Statie1> result=new ArrayList<>();
            result.add(lastNode);
            int timp=lastNode.getDistance();
            while(!lastNode.getNume().equals(start.getNume()))
            {
                for(NodGraf nod : noduri_vizitate)
                {
                    if(nod.getId_statie()==lastNode.getId_previous())
                    {
                        result.add(nod);
                        lastNode=nod;
                    }
                }
            }
            Collections.reverse(result);
            Ruta ruta=new Ruta(result,timp);
            for (NodGraf nod: graf) {
                nod.setDistance(100000);
                nod.setId_previous(-1);
                nod.setVizitat(false);
            }
            return ruta;
        }
        else
        {
            for (NodGraf nod: graf) {
                nod.setDistance(100000);
                nod.setId_previous(-1);
                nod.setVizitat(false);
            }
            return null;}
    }

    @Override
    public void onRegisterPressed()
    {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, new RegisterFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onLoginPressed()
    {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, new LoginFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onMagistralePressed()
    {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, new LoginFragment());//?????????????????????
        fragmentTransaction.commit();
    }

    @Override
    public void onRutePressed()
    {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, new RuteFragment());
        fragmentTransaction.commit();
    }

    private void getUserFromRegistration()
    {
        tiet_nume=findViewById(R.id.tiet_nume);
        tiet_username=findViewById(R.id.tiet_prenume);
        tiet_email=findViewById(R.id.tiet_email);
        tiet_parola=findViewById(R.id.tiet_parola);
        btn_register=findViewById(R.id.btn_register);

        if(tiet_nume.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(), getString(R.string.introducetiNume),Toast.LENGTH_SHORT).show();
        if(tiet_username.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(), getString(R.string.introducetiUsername),Toast.LENGTH_SHORT).show();
        if(tiet_email.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), getString(R.string.introducetiEmail), Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (!Patterns.EMAIL_ADDRESS.matcher(tiet_email.getText().toString()).matches())
                Toast.makeText(getApplicationContext(), getString(R.string.introducetiEmailCorect), Toast.LENGTH_SHORT).show();
        }
        if(tiet_parola.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(), getString(R.string.introducetiParola),Toast.LENGTH_SHORT).show();


        nume=tiet_nume.getText().toString();
        username=tiet_username.getText().toString();
        email=tiet_email.getText().toString();
        parola=tiet_parola.getText().toString();
    }

    private void writeToDataBase()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("myUsers");

        myRef.child(user.getUsername()).setValue(user);
    }

    @Override
    public void clickRegisterButton()
    {
        getUserFromRegistration();
        user=new User(nume, username, email, parola);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference reference=database.getReference("myUsers");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                if(snapshot.hasChild(username))
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.existaUser), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    HashMap<String,User> useri=new HashMap<>();
                    for(DataSnapshot s : snapshot.getChildren())
                    {
                        User user=s.getValue(User.class);
                        useri.put(s.getKey(),user);
                    }
                    int ok=0;
                    for(User usr : useri.values())
                    {
                        if(usr.getEmail().equals(email))
                        {
                            ok=1;
                        }
                    }
                    if(ok==1)
                        Toast.makeText(getApplicationContext(), getString(R.string.existaEmailul), Toast.LENGTH_SHORT).show();
                    if(ok==0)
                    {
                        writeToDataBase();
                        fragmentManager=getSupportFragmentManager();
                        fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_fragment, new LoginFragment());
                        fragmentTransaction.commit();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getCredentialsFromLogin()
    {
        tiet_username_login=findViewById(R.id.tiet_username_login);
        tiet_parola_login=findViewById(R.id.tiet_parola_login);


        if(tiet_username_login.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(),getString(R.string.introducetiUsername),Toast.LENGTH_SHORT).show();
        if(tiet_parola_login.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(), getString(R.string.introducetiParola),Toast.LENGTH_SHORT).show();


        username_login=tiet_username_login.getText().toString();
        parola_login=tiet_parola_login.getText().toString();
    }

    private void readUserFromDataBase()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("myUsers/"+username_login);

        // Read from the database
        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userFromDatabase=snapshot.getValue(User.class);
                if(userFromDatabase!=null)
                    if(parola_login.equals(userFromDatabase.getParola()))
                    {
                        NavigationView navigationView=findViewById(R.id.navigationView);
                        Menu menu=navigationView.getMenu();
                        menu.findItem(R.id.deconectare).setVisible(true);
                        fragmentManager=getSupportFragmentManager();
                        fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_fragment,new ProfileFragment(userFromDatabase));
                        fragmentTransaction.commit();
                    }
                    else
                        Toast.makeText(getApplicationContext(), getString(R.string.parolaGresita),Toast.LENGTH_SHORT).show();
                else
                    {
                        Toast.makeText(getApplicationContext(), getString(R.string.utilizatorInexistent),Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
            }
        });
    }

    @Override
    public void clickLoginButton()
    {
        getCredentialsFromLogin();
        readUserFromDataBase();
    }

    @Override
    public void onProfilPressed()
    {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new ProfileFragment(userFromDatabase));
        fragmentTransaction.commit();
    }

    @Override
    public void onDeconectarePressed()
    {
        NavigationView navigationView=findViewById(R.id.navigationView);
        Menu menu=navigationView.getMenu();
        menu.findItem(R.id.deconectare).setVisible(false);
        userFromDatabase=null;
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new HomeFragment(null));
        fragmentTransaction.commit();
    }

    public void create_database(String db)
    {
        AssetManager assets;
        String databaseDir;
        Context context=this;
        assets = context.getAssets();
        databaseDir = context.getApplicationInfo().dataDir + "/databases/";

        File file = new File(databaseDir);
        if(!file.exists()) file.mkdir();


        try {
            InputStream inputStream = assets.open("databases/" + db);

            FileOutputStream outputStream = new FileOutputStream(databaseDir + db);

            byte[] buffer = new byte[8 * 1024];

            int readed;
            while ((readed = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readed);
            }

            outputStream.flush();

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}