package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Usuario;
import com.google.firebase.firestore.FirebaseFirestore;

public class UsuarioController {
    private FirebaseFirestore db;

    public UsuarioController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addUsuario(Usuario usuario) {
        String key = db.collection("Usuarios").document().getId();
        usuario.setCodigoUsuario(key);
        db.collection("Usuarios").document(key).set(usuario)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void updateUsuario(String key, Usuario usuario) {
        db.collection("Usuarios").document(key).set(usuario)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void deleteUsuario(String key) {
        db.collection("Usuarios").document(key).delete()
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    // Métodos para leer datos se pueden agregar aquí
}
