package com.example.jma_aa;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.jma_aa.controladores.GradoController;
import com.example.jma_aa.controladores.SeccionController;
import com.example.jma_aa.modelos.Grado;
import com.example.jma_aa.modelos.Seccion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android.content.Context;
import android.content.SharedPreferences;


public class CrearSeccionFragment extends Fragment {
    private Spinner spinnerGrado;
    private EditText etNombreSeccion;
    private Button btnCrearSeccion;
    private GradoController gradoController;
    private SeccionController seccionController;
    private String selectedAnioAcademico;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crear_seccion, container, false);

        spinnerGrado = view.findViewById(R.id.spinnerGrado);
        etNombreSeccion = view.findViewById(R.id.etNombreSeccion);
        btnCrearSeccion = view.findViewById(R.id.btnCrearSeccion);
        gradoController = new GradoController();
        seccionController = new SeccionController();

        // Obtener el año académico seleccionado desde SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE);
        selectedAnioAcademico = sharedPreferences.getString("selectedAnioAcademico", "");

        // Verificar si el año académico está seleccionado
        if (selectedAnioAcademico.isEmpty()) {
            Toast.makeText(getActivity(), "Por favor, seleccione un año académico primero", Toast.LENGTH_SHORT).show();
            return view;
        }

        // Establecer el prompt del Spinner en el código Java
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, new ArrayList<>());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGrado.setAdapter(adapter);
        spinnerGrado.setPrompt("Seleccione el grado");

        // Obtener todos los grados y poblar el spinner
        gradoController.getGrados(selectedAnioAcademico, new GradoController.GradoCallback() {
            @Override
            public void onCallback(List<Grado> gradoList) {
                List<String> grados = new ArrayList<>();
                for (Grado grado : gradoList) {
                    grados.add(grado.getNombre());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, grados);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerGrado.setAdapter(adapter);
            }
        });

        btnCrearSeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreSeccion = etNombreSeccion.getText().toString().trim();
                String nombreGrado = spinnerGrado.getSelectedItem().toString();

                if (nombreSeccion.isEmpty() || nombreGrado.isEmpty()) {
                    Toast.makeText(getActivity(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Obtener el código del grado seleccionado
                    gradoController.getGrados(selectedAnioAcademico, new GradoController.GradoCallback() {
                        @Override
                        public void onCallback(List<Grado> gradoList) {
                            for (Grado grado : gradoList) {
                                if (grado.getNombre().equals(nombreGrado)) {
                                    String codigoGrado = grado.getCodigoGrado();
                                    Seccion seccion = new Seccion(UUID.randomUUID().toString(), nombreSeccion);
                                    seccionController.addSeccion(selectedAnioAcademico, codigoGrado, seccion);
                                    Toast.makeText(getContext(), "Sección creada con éxito", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                        }
                    });
                }
            }
        });


            return view;
    }
}
