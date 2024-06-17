package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Grado;
import com.google.firebase.firestore.FirebaseFirestore;

public class GradoController {
    private FirebaseFirestore db;

    public GradoController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addGrado(Grado grado) {
        String key = db.collection("Grados").document().getId();
        grado.setCodigoGrado(key);
        db.collection("Grados").document(key).set(grado);
    }

    public void updateGrado(String key, Grado grado) {
        db.collection("Grados").document(key).set(grado);
    }

    public void deleteGrado(String key) {
        db.collection("Grados").document(key).delete();
    }

    // Métodos para leer datos se pueden agregar aquí
}
