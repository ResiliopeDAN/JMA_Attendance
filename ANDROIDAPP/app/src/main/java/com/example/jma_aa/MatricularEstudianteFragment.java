package com.example.jma_aa;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jma_aa.modelos.Estudiante;
import com.example.jma_aa.controladores.EstudianteController;
import com.example.jma_aa.modelos.Usuario;
import com.example.jma_aa.controladores.UsuarioController;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.UUID;
import java.util.Calendar;

public class MatricularEstudianteFragment extends Fragment {

    private EditText etNombre, etApellido, etDNI, etCorreoElectronico, etTelefono, etDireccion;
    private Button btnGuardarMatricula;
    private EstudianteController estudianteController;
    private UsuarioController usuarioController;
    private FirebaseFirestore db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matricular_estudiante, container, false);

        etNombre = view.findViewById(R.id.etNombre);
        etApellido = view.findViewById(R.id.etApellido);
        etDNI = view.findViewById(R.id.etDNI);
        etCorreoElectronico = view.findViewById(R.id.etCorreoElectronico);
        etTelefono = view.findViewById(R.id.etTelefono);
        etDireccion = view.findViewById(R.id.etDireccion);
        btnGuardarMatricula = view.findViewById(R.id.btnGuardarMatricula);
        estudianteController = new EstudianteController();
        usuarioController = new UsuarioController();

        db = FirebaseFirestore.getInstance();

        btnGuardarMatricula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                String dni = etDNI.getText().toString();
                String correoElectronico = etCorreoElectronico.getText().toString();
                String telefono = etTelefono.getText().toString();
                String direccion = etDireccion.getText().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || correoElectronico.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
                    Toast.makeText(getActivity(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    String codigoEstudiante = UUID.randomUUID().toString();
                    String codigoUsuario = UUID.randomUUID().toString();
                    //String anioActual = String.ValueOf(new Date().getYear() + 1900); //IMPLEMENTAR EL CONTROLOADOR DE ANIO ACADEMICO
                    String nombreUsuario = dni; // Establezo el DNI como usuario del Estudiante
                    String contrasenia = anioActual + "JMA";

                    Estudiante estudiante = new Estudiante(codigoEstudiante, nombre, apellido, dni, correoElectronico, telefono, direccion, codigoUsuario);
                    Usuario usuario = new Usuario(codigoUsuario, nombreUsuario, contrasenia, "estudiante");

                    db.collection("estudiantes").add(estudiante)
                            .addOnSuccessListener(documentReference -> {
                                        db.collection("usuarios").add(usuario)
                                                .addOnSuccessListener(docRef -> Toast.makeText(getActivity(), "Estudiante matriculado con éxito", Toast.LENGTH_SHORT).show())
                                                .addOnFailureListener(e -> Toast.makeText(getActivity(), "Error al crear usuario", Toast.LENGTH_SHORT).show());
                            })
                            .addOnFailureListener(e -> Toast.makeText(getActivity(), "Error al matricular estudiante", Toast.LENGTH_SHORT).show());
                }
            }
        });

        return view;
    }

}