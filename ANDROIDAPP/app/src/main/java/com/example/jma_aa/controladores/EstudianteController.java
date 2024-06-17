package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Estudiante;
import com.google.firebase.firestore.FirebaseFirestore;

public class EstudianteController {
    private FirebaseFirestore db;

    public EstudianteController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addEstudiante(Estudiante estudiante) {
        String key = db.collection("Estudiantes").document().getId();
        estudiante.setCodigoEstudiante(key);
        db.collection("Estudiantes").document(key).set(estudiante);
    }

    public void updateEstudiante(String key, Estudiante estudiante) {
        db.collection("Estudiantes").document(key).set(estudiante);
    }

    public void deleteEstudiante(String key) {
        db.collection("Estudiantes").document(key).delete();
    }

    // Métodos para leer datos se pueden agregar aquí
}
