package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Administrador;
import com.google.firebase.firestore.FirebaseFirestore;

public class AdministradorController {
    private FirebaseFirestore db;

    public AdministradorController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addAdministrador(Administrador administrador) {
        String key = db.collection("Administradores").document().getId();
        administrador.setCodigoAdministrador(key);
        db.collection("Administradores").document(key).set(administrador)
                .addOnSuccessListener(aVoid -> {
                    //A implementar
                })
                .addOnFailureListener(e -> {
                    //A implementar falta la vista y el crud del admin
                });

    }

    public void updateAdministrador(String key, Administrador administrador) {
        db.collection("Administradores").document(key).set(administrador)
                .addOnSuccessListener(aVoid -> {
                    //A implementar
                })
                .addOnFailureListener(e -> {
                    //A implementar falta la vista y el crud del admin
                });
    }

    public void deleteAdministrador(String key) {
        db.collection("Administradores").document(key).delete()
                .addOnSuccessListener(aVoid -> {
                    //A implementar
                })
                .addOnFailureListener(e -> {
                    //A implementar falta la vista y el crud del admin
                });
    }

    // Métodos para leer datos se pueden agregar aquí
}
