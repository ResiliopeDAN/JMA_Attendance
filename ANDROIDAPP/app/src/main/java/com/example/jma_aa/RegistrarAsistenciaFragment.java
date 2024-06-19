package com.example.jma_aa;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.jma_aa.modelos.Asistencia;
import com.example.jma_aa.controladores.AsistenciaController;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jma_aa.modelos.Estudiante;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;

public class RegistrarAsistenciaFragment extends Fragment {

    private RecyclerView recyclerViewAsistencias;
    private Button btnGuardarAsistencias;
    private AsistenciaController asistenciaController;
    private FirebaseFirestore db;
    private List<Estudiante> estudiantes;
    private AsistenciaAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrar_asistencia, container, false);

        recyclerViewAsistencias = view.findViewById(R.id.recyclerViewAsistencias);
        btnGuardarAsistencias = view.findViewById(R.id.btnGuardarAsistencias);
        asistenciaController = new AsistenciaController();
        db = FirebaseFirestore.getInstance();
        estudiantes = new ArrayList<>();

        recyclerViewAsistencias.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AsistenciaAdapter(getContext(), estudiantes);
        recyclerViewAsistencias.setAdapter(adapter);

        cargarEstudiantes();

        btnGuardarAsistencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarAsistencias();
            }
        });

        return view;
    }

    private void cargarEstudiantes() {
        db.collection("estudiantes").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Estudiante estudiante = document.toObject(Estudiante.class);
                    estudiantes.add(estudiante);
                }
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(getContext(), "Error al cargar los estudiantes", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void guardarAsistencias() {
        for (int i = 0; i < recyclerViewAsistencias.getChildCount(); i++) {
            View itemView = recyclerViewAsistencias.getChildAt(i);
            Spinner spinnerEstado = itemView.findViewById(R.id.spinnerEstado);

            Estudiante estudiante = estudiantes.get(i);
            String estado = spinnerEstado.getSelectedItem().toString();

            String codigoAsistencia = UUID.randomUUID().toString();
            Date fecha = new Date();

            Asistencia asistencia = new Asistencia(codigoAsistencia, estudiante.getCodigoEstudiante(), fecha, estado);
            asistenciaController.addAsistencia(asistencia);
        }

        Toast.makeText(getContext(), "Asistencias guardadas con éxito", Toast.LENGTH_SHORT).show();
    }
}
