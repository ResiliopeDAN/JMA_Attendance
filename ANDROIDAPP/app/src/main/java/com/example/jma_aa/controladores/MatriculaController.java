package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Matricula;
import com.google.firebase.firestore.FirebaseFirestore;

public class MatriculaController {
    private FirebaseFirestore db;

    public MatriculaController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addMatricula(Matricula matricula) {
        String key = db.collection("Matriculas").document().getId();
        matricula.setCodigoMatricula(key);
        db.collection("Matriculas").document(key).set(matricula)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void updateMatricula(String key, Matricula matricula) {
        db.collection("Matriculas").document(key).set(matricula)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void deleteMatricula(String key) {
        db.collection("Matriculas").document(key).delete()
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    // Métodos para leer datos se pueden agregar aquí
}
