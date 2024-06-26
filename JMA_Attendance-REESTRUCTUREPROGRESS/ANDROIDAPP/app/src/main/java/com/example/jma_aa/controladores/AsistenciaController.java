package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Asistencia;
import com.google.firebase.firestore.FirebaseFirestore;

public class AsistenciaController {
    private FirebaseFirestore db;

    public AsistenciaController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addAsistencia(Asistencia asistencia) {
        String key = db.collection("Asistencias").document().getId();
        asistencia.setCodigoAsistencia(key);
        db.collection("Asistencias").document(key).set(asistencia)
                .addOnSuccessListener(aVoid -> {
                    //
                })
                .addOnFailureListener(e -> {

                });
    }

    public void updateAsistencia(String key, Asistencia asistencia) {
        db.collection("Asistencias").document(key).set(asistencia)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando la asistencia se actualiza correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void deleteAsistencia(String key) {
        db.collection("Asistencias").document(key).delete()
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando la asistencia se elimina correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    // Métodos para leer datos se pueden agregar aquí
}
