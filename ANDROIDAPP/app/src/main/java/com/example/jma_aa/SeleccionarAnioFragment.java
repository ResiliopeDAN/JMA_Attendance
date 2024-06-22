package com.example.jma_aa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.jma_aa.controladores.AnioAcademicoController;
import com.example.jma_aa.modelos.AnioAcademico;

import java.util.ArrayList;
import java.util.List;

public class SeleccionarAnioFragment extends Fragment {

    private Spinner spinnerAnio;
    private Button btnSeleccionarAnio;
    private AnioAcademicoController anioAcademicoController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seleccionar_anio, container, false);

        spinnerAnio = view.findViewById(R.id.spinnerAnio);
        btnSeleccionarAnio = view.findViewById(R.id.btnSeleccionarAnio);
        anioAcademicoController = new AnioAcademicoController();

        // Obtener todos los años académicos y poblar el spinner
        anioAcademicoController.getAllAnioAcademicos(new AnioAcademicoController.AnioAcademicoCallback() {
            @Override
            public void onCallback(List<AnioAcademico> anioAcademicoList) {
                List<String> anios = new ArrayList<>();
                for (AnioAcademico anio : anioAcademicoList) {
                    anios.add(anio.getNombreAnioAcademico());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, anios);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerAnio.setAdapter(adapter);
            }
        });

        btnSeleccionarAnio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anioSeleccionado = spinnerAnio.getSelectedItem().toString();
                Toast.makeText(getActivity(), "Año académico seleccionado: " + anioSeleccionado, Toast.LENGTH_SHORT).show();
                // Guardar la selección del año académico en las preferencias compartidas o continuar con la lógica deseada
            }
        });

        return view;
    }
}
