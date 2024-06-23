package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Grado;
import com.google.firebase.firestore.FirebaseFirestore;

public class GradoController {
    private FirebaseFirestore db;

    public GradoController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addGrado(String anioAcademicoId, Grado grado) {
        String key = db.collection("AniosAcademicos").document(anioAcademicoId).collection("Grados").document().getId();
        grado.setCodigoGrado(key);
        db.collection("AniosAcademicos").document(anioAcademicoId).collection("Grados").document(key).set(grado)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void updateGrado(String codigoAnioAcademico, String key, Grado grado) {
        db.collection("AniosAcademicos").document(codigoAnioAcademico).collection("Grados").document(key).set(grado)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void deleteGrado(String codigoAnioAcademico, String key) {
        db.collection("AniosAcademicos").document(codigoAnioAcademico).collection("Grados").document(key).delete()
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se elimina correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    // Métodos para leer datos se pueden agregar aquí
}
