package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Grado;
import com.google.firebase.firestore.FirebaseFirestore;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

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


    public void getGrados(String anioAcademicoId, final GradoCallback callback) {
        db.collection("AniosAcademicos").document(anioAcademicoId).collection("Grados").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<Grado> gradoList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Grado grado = document.toObject(Grado.class);
                                gradoList.add(grado);
                            }
                            callback.onCallback(gradoList);
                        } else {
                            // Manejo del error
                        }
                    }
                });
    }

    public interface GradoCallback {
        void onCallback(List<Grado> gradoList);
    }
    // Métodos para leer datos se pueden agregar aquí
}
