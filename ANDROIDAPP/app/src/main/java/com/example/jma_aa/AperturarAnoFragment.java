package com.example.jma_aa;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.jma_aa.modelos.AnioAcademico;
import com.example.jma_aa.controladores.AnioAcademicoController;
import java.util.UUID;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AperturarAnoFragment extends Fragment {

    private EditText etAnio;
    private Button btnAperturarAno;
    private AnioAcademicoController anioAcademicoController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aperturar_ano, container, false):

        etAnio = view.findViewById(R.id.etAnio);
        btnAperturarAno = view.findViewById(R.id.btnAperturarAno);
        anioAcademicoController = new AnioAcademicoController();

        btnAperturarAno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anio = etAnio.getText().toString().trim();

                if (anio.isEmpty()) {
                    Toast.makeText(getActivity(), "Por favor, ingrese el nombre del año académico", Toast.LENGTH_SHORT).show();
                } else {

                    String codigoAno = UUID.randomUUID().toString();
                    AnioAcademico anioAcademico = new AnioAcademico(codigoAnio, anio);
                    anioAcademicoController.addAnioAcademico(anioAcademico);
                    Toast.makeText(getContext(), "Años académico aperturado con éxito", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;

    }
}
