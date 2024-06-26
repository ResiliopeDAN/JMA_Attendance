package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Auxiliar;
import com.google.firebase.firestore.FirebaseFirestore;

public class AuxiliarController {
    private FirebaseFirestore db;

    public AuxiliarController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addAuxiliar(Auxiliar auxiliar) {
        String key = db.collection("Auxiliares").document().getId();
        auxiliar.setCodigoAuxiliar(key);
        db.collection("Auxiliares").document(key).set(auxiliar);
    }

    public void updateAuxiliar(String key, Auxiliar auxiliar) {
        db.collection("Auxiliares").document(key).set(auxiliar);
    }

    public void deleteAuxiliar(String key) {
        db.collection("Auxiliares").document(key).delete();
    }

    // Métodos para leer datos se pueden agregar aquí
}
