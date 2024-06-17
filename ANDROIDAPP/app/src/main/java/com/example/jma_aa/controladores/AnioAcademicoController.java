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
        db.collection("AniosAcademicos").document(key).set(anioAcademico);
    }

    public void updateAnioAcademico(String key, AnioAcademico anioAcademico) {
        db.collection("AniosAcademicos").document(key).set(anioAcademico);
    }

    public void deleteAnioAcademico(String key) {
        db.collection("AniosAcademicos").document(key).delete();
    }

    // Métodos para leer datos se pueden agregar aquí
}
