package com.jaat.coffeesociety;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private InicioFragment fragmento_inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmento_inicio = new InicioFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainFrame,fragmento_inicio)
                .commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame,fragmento_inicio)
                    .commit();

        } else if (id == R.id.nav_informacion) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainFrame,new InformacionFragment()).commit();

        } else if (id == R.id.nav_ordenar) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainFrame,new OrdenarFragment()).commit();

        } else if (id == R.id.nav_ordenes) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainFrame,new OrdenesFragment()).commit();

        } else if (id == R.id.nav_perfil) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainFrame,new PerfilFragment()).commit();

        } else if (id == R.id.nav_contactenos) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainFrame,new ContactenosFragment()).commit();

        } else if (id == R.id.nav_configuracion) {
            getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainFrame,new ConfiguracionFragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
