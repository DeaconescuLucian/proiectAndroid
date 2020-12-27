package com.example.proiectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,RuteFragment.onFragmentButtonSelected{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    List<Statie> lista;
    ArrayList<NodGraf> graf;
    ArrayList<Legaturi> lista1;
    ListView listview;
    TimpAsteptare ANGHELSALIGNY_PRECIZIEI,DRISTOR1_EROILOR,EROILOR2_ROMANCIERILOR,
            GARADENORD_STRAULESTI,PIPERA_BERCENI,RAULDOAMNEI_EROILOR2,REPUBLICA_DRISTOR2,REPUBLICA_PANTELIMON,VALEAIALOMITEI_EROILOR2;
    ArrayList<Ruta> rute;
    MagistralaAdapter magistralaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            fragmentTransaction.replace(R.id.container_fragment,new HomeFragment());
            fragmentTransaction.commit();
        }
        return true;
    }

    @Override
    public void onButtonSelected(String start,String end, long position1, long position2) {
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, 10);
        String ora_curenta=formatter.format(cal.getTime());
        Log.v("mora",ora_curenta);
        DataBaseHelper dataBaseHelper=new DataBaseHelper(this);
        lista=dataBaseHelper.selecteazaStatii();
        lista1=dataBaseHelper.selecteazaLegaturi();
        ANGHELSALIGNY_PRECIZIEI=dataBaseHelper.selecteazaTimpDeAsteptare("ANGHELSALIGNY_PRECIZIEI",ora_curenta);
        DRISTOR1_EROILOR=dataBaseHelper.selecteazaTimpDeAsteptare("DRISTOR1_EROILOR",ora_curenta);
        EROILOR2_ROMANCIERILOR=dataBaseHelper.selecteazaTimpDeAsteptare("EROILOR2_ROMANCIERILOR",ora_curenta);
        GARADENORD_STRAULESTI=dataBaseHelper.selecteazaTimpDeAsteptare("GARADENORD_STRAULESTI",ora_curenta);
        PIPERA_BERCENI=dataBaseHelper.selecteazaTimpDeAsteptare("PIPERA_BERCENI",ora_curenta);
        RAULDOAMNEI_EROILOR2=dataBaseHelper.selecteazaTimpDeAsteptare("RAULDOAMNEI_EROILOR2",ora_curenta);
        REPUBLICA_DRISTOR2=dataBaseHelper.selecteazaTimpDeAsteptare("REPUBLICA_DRISTOR2",ora_curenta);
        REPUBLICA_PANTELIMON=dataBaseHelper.selecteazaTimpDeAsteptare("REPUBLICA_PANTELIMON",ora_curenta);
        VALEAIALOMITEI_EROILOR2=dataBaseHelper.selecteazaTimpDeAsteptare("VALEAIALOMITEI_EROILOR2",ora_curenta);
        graf =new ArrayList<>();
        for(Statie statie : lista)
        {
            NodGraf nod=new NodGraf(statie.getId_statie(),statie.getId_linie(),statie.getNume(),statie.getVecini());
            graf.add(nod);
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
        for (Statie statie: rute.get(0).getStatii()) {
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
                                    if (leg.getId_vecin1() == extras.getId_statie() && leg.getId_vecin2() == i) {

                                        if(nod.getDistance()>extras.getDistance()+leg.getTimp())
                                        {
                                            if(!nod.getNume().equals(start.getNume()))
                                            {
                                                nod.setDistance(extras.getDistance()+leg.getTimp());
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
            ArrayList<Statie> result=new ArrayList<>();
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
}