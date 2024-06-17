package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Seccion;
import com.google.firebase.firestore.FirebaseFirestore;

public class SeccionController {
    private FirebaseFirestore db;

    public SeccionController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addSeccion(Seccion seccion) {
        String key = db.collection("Secciones").document().getId();
        seccion.setCodigoSeccion(key);
        db.collection("Secciones").document(key).set(seccion);
    }

    public void updateSeccion(String key, Seccion seccion) {
        db.collection("Secciones").document(key).set(seccion);
    }

    public void deleteSeccion(String key) {
        db.collection("Secciones").document(key).delete();
    }

    // Métodos para leer datos se pueden agregar aquí
}
