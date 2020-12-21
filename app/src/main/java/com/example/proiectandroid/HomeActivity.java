package com.example.proiectandroid;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    public int codHomeActivity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        configNavigation();

//        final ImageView imageView=findViewById(R.id.imagine_harta);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                setContentView(R.layout.activity_home);
////                CoordinatorLayout coordinatorLayout=findViewById(R.id.coordinator_layout);
////                AppBarLayout appBarLayout=findViewById(R.id.app_bar_layout);
////                CoordinatorLayout.LayoutParams params =(CoordinatorLayout)coordinatorLayout.getLayoutParams();
////                params.setBehavior(null);
////                coordinatorLayout.requestLayout();
//                AppBarLayout appBarLayout=findViewById(R.id.app_bar_layout);
//                appBarLayout.setVisibility(View.INVISIBLE);
//                Toolbar toolbar=findViewById(R.id.toolbar);
//                toolbar.setVisibility(View.INVISIBLE);
//                DisplayMetrics displayMetrics = new DisplayMetrics();
//                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//                int height = displayMetrics.heightPixels;
//                int width = displayMetrics.widthPixels;
//                ConstraintLayout.LayoutParams lp=new ConstraintLayout.LayoutParams(width, height);
//                imageView.setLayoutParams(lp);
//            }
//        });
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    private void configNavigation()
    {
        //initializare toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer_layout);
        //legare meniu cu toolbar
        ActionBarDrawerToggle actionBar=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close) ;

        drawerLayout.addDrawerListener(actionBar);

        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //sincronizeaza drawer
        actionBar.syncState();

    }
    private void changeFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_container,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home: {
                //changeFragment((new HomeFragment()));
                //Toast.makeText(this, "home pressed", Toast.LENGTH_LONG).show();
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                break;
            }
            case R.id.nav_gallery: {
                Toast.makeText(this, "gallery pressed", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.nav_slideshow: {
                Toast.makeText(this, "slideshow pressed", Toast.LENGTH_LONG).show();
                break;
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}