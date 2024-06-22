package com.example.jma_aa.controladores;

import androidx.annotation.NonNull;

import com.example.jma_aa.modelos.AnioAcademico;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;

import java.util.ArrayList;
import java.util.List;

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

    public void getAllAnioAcademicos(final AnioAcademicoCallback callback) {
        db.collection("AniosAcademicos").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<AnioAcademico> anioAcademicoList = new ArrayList<>();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                AnioAcademico anioAcademico = document.toObject(AnioAcademico.class);
                                anioAcademicoList.add(anioAcademico);
                            }
                            callback.onCallback(anioAcademicoList);
                        } else {
                            // Manejo del error
                        }
                    }
                });
    }

    public interface AnioAcademicoCallback {
        void onCallback(List<AnioAcademico> anioAcademicoList);
    }


    public void getAnioAcademicoActual(final OnAnioAcademicoLoadedListener listener) {
        db.collection("AniosAcademicos")
                .orderBy("anio", Query.Direction.DESCENDING)
                .limit(1)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                        if (e != null) {
                            listener.onFailure(e);
                            return;
                        }

                        if (documentSnapshots != null && !documentSnapshots.isEmpty()) {
                            DocumentSnapshot document = documentSnapshots.getDocuments().get(0);
                            AnioAcademico anioAcademico = document.toObject(AnioAcademico.class);
                            listener.onSuccess(anioAcademico);
                        } else {
                            listener.onFailure(new Exception("No se encontró ningún documento"));
                        }
                    }
                });
    }

    public interface OnAnioAcademicoLoadedListener {
        void onSuccess(AnioAcademico anioAcademico);
        void onFailure(Exception e);
    }
}
