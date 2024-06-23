package com.example.jma_aa;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jma_aa.controladores.GradoController;
import com.example.jma_aa.modelos.AnioAcademico;
import com.example.jma_aa.controladores.AnioAcademicoController;
import com.example.jma_aa.modelos.Grado;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AperturarAnoFragment extends Fragment {

    private EditText etAnio;
    private Button btnAperturarAno;
    private AnioAcademicoController anioAcademicoController;
    private GradoController gradoController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aperturar_ano, container, false);

        etAnio = view.findViewById(R.id.etAnio);
        btnAperturarAno = view.findViewById(R.id.btnAperturarAno);
        anioAcademicoController = new AnioAcademicoController();
        gradoController = new GradoController();

        btnAperturarAno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anio = etAnio.getText().toString().trim();

                if (anio.isEmpty()) {
                    Toast.makeText(getActivity(), "Por favor, ingrese el nombre del año académico", Toast.LENGTH_SHORT).show();
                } else {

                    String codigoAnio = UUID.randomUUID().toString();
                    AnioAcademico anioAcademico = new AnioAcademico(codigoAnio, anio);
                    anioAcademicoController.addAnioAcademico(anioAcademico, new AnioAcademicoController.AnioAcademicoCallback() {
                        @Override
                        public void onCallback(List<AnioAcademico> anioAcademicoList) {

                        }

                        @Override
                        public void onSuccess() {
                            // Crear grados predeterminados al aperturar año académico
                            List<Grado> gradosPredeterminados = Arrays.asList(
                                    new Grado("", "1er Grado", "1er Grado del " + anio),
                                    new Grado("", "2do Grado", "2do Grado del " + anio),
                                    new Grado("", "3er Grado", "3er Grado del " + anio),
                                    new Grado("", "4to Grado", "4to Grado del " + anio),
                                    new Grado("", "5to Grado", "5to Grado del " + anio)
                            );

                            for (Grado grado : gradosPredeterminados) {
                                gradoController.addGrado(codigoAnio, grado);
                            }

                            Toast.makeText(getContext(), "Año académico aperturado con éxito", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Exception e) {
                            Toast.makeText(getContext(), "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    Toast.makeText(getContext(), "Años académico aperturado con éxito", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;

    }
}
