package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.AnioAcademico;
import com.google.firebase.firestore.FirebaseFirestore;

public class AnioAcademicoController {
    private FirebaseFirestore db;

    public AnioAcademicoController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addAnioAcademico(AnioAcademico anioAcademico) {
        String key = db.collection("AniosAcademicos").document().getId();
        anioAcademico.setCodigoAnioAcademico(key);
        db.collection("AniosAcademicos").document(key).set(anioAcademico)
                .addOnSuccessListener(aVoid -> {
                    //A implementar
                })
                .addOnFailureListener(e -> {
                    //A implementar falta la vista y el crud del admin
                });
    }

    public void updateAnioAcademico(String key, AnioAcademico anioAcademico) {
        db.collection("AniosAcademicos").document(key).set(anioAcademico)
                .addOnSuccessListener(aVoid -> {
                    //A implementar
                })
                .addOnFailureListener(e -> {
                    //A implementar falta la vista y el crud del admin
                });
    }

    public void deleteAnioAcademico(String key) {
        db.collection("AniosAcademicos").document(key).delete()
                .addOnSuccessListener(aVoid -> {
                    //A implementar
                })
                .addOnFailureListener(e -> {
                    //A implementar falta la vista y el crud del admin
                });
    }

    // Métodos para leer datos se pueden agregar aquí
}
