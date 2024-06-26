package com.example.jma_aa;

import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;

import com.example.jma_aa.AperturarAnoFragment;
import com.example.jma_aa.CrearSeccionFragment;
import com.example.jma_aa.MatricularEstudianteFragment;
import com.example.jma_aa.DarBajaEstudianteFragment;
import com.example.jma_aa.GenerarReportesFragment;
import com.example.jma_aa.SeleccionarAnioFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                    new DefaultFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_aperturar_ano);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        switch (item.getItemId()) {
            case R.id.nav_aperturar_ano:
                selectedFragment = new AperturarAnoFragment();
                break;
            case R.id.nav_crear_seccion:
                selectedFragment = new CrearSeccionFragment();
                break;
            case R.id.nav_matricular_estudiante:
                selectedFragment = new MatricularEstudianteFragment();
                break;
            case R.id.nav_dar_baja_estudiante:
                selectedFragment = new DarBajaEstudianteFragment();
                break;
            case R.id.nav_generar_reportes:
                selectedFragment = new GenerarReportesFragment();
                break;
            case R.id.nav_registrar_asistencia:
                selectedFragment = new RegistrarAsistenciaFragment();
                break;
            case R.id.nav_seleccionar_anio:
                selectedFragment = new SeleccionarAnioFragment();
                break;
        }

        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,
                    selectedFragment).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}