package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Turno;
import com.google.firebase.firestore.FirebaseFirestore;

public class TurnoController {
    private FirebaseFirestore db;

    public TurnoController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addTurno(Turno turno) {
        String key = db.collection("Turnos").document().getId();
        turno.setCodigoTurno(key);
        db.collection("Turnos").document(key).set(turno);
    }

    public void updateTurno(String key, Turno turno) {
        db.collection("Turnos").document(key).set(turno);
    }

    public void deleteTurno(String key) {
        db.collection("Turnos").document(key).delete();
    }

    // Métodos para leer datos se pueden agregar aquí
}
