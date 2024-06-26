package com.example.jma_aa.controladores;

import com.example.jma_aa.modelos.Seccion;
import com.google.firebase.firestore.FirebaseFirestore;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SeccionController {
    private FirebaseFirestore db;

    public SeccionController() {
        db = FirebaseFirestore.getInstance();
    }

    public void addSeccion(String anioAcademicoId, String gradoId, Seccion seccion) {
        String key = db.collection("AniosAcademicos").document(anioAcademicoId)
                .collection("Grados").document(gradoId)
                .collection("Secciones").document().getId();
        seccion.setCodigoSeccion(key);
        db.collection("AniosAcademicos").document(anioAcademicoId)
                .collection("Grados").document(gradoId)
                .collection("Secciones").document(key).set(seccion)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando el grado se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void updateSeccion(String anioAcademicoId, String gradoId, String key, Seccion seccion) {
        db.collection("AniosAcademicos").document(anioAcademicoId)
                .collection("Grados").document(gradoId)
                .collection("Secciones").document(key).set(seccion)
                .addOnSuccessListener(aVoid -> {
                    // Acción cuando la sección se agrega correctamente
                })
                .addOnFailureListener(e -> {
                    // Acción cuando ocurre un error
                });
    }

    public void getSecciones(String anioAcademicoId, String gradoId, final SeccionCallback callback) {
        db.collection("AniosAcademicos").document(anioAcademicoId)
                .collection("Grados").document(gradoId)
                .collection("Secciones").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<Seccion> seccionList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Seccion seccion = document.toObject(Seccion.class);
                                seccionList.add(seccion);
                            }
                            callback.onCallback(seccionList);
                        } else {
                            // Manejo del error
                        }
                    }
                });
    }

    public interface SeccionCallback {
        void onCallback(List<Seccion> seccionList);
    }
}
