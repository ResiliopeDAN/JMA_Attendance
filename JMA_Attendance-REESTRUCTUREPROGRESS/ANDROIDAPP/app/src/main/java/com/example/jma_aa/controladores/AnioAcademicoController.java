package com.example.jma_aa.controladores;

import androidx.annotation.NonNull;

import com.example.jma_aa.modelos.AnioAcademico;
import com.example.jma_aa.modelos.Grado;
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
import java.util.UUID;



public class AnioAcademicoController {
    private FirebaseFirestore db;

    public AnioAcademicoController() {

        db = FirebaseFirestore.getInstance();
    }

    public void addAnioAcademico(final AnioAcademico anioAcademico, final AnioAcademicoCallback callback) {
        db.collection("AniosAcademicos")
                .whereEqualTo("nombreAnioAcademico", anioAcademico.getNombreAnioAcademico())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful() && task.getResult() != null && task.getResult().isEmpty()) {
                            //No se encontraron duplicados, procede a añadir
                            String key = db.collection("AniosAcademicos").document().getId();
                            anioAcademico.setCodigoAnioAcademico(key);
                            db.collection("AniosAcademicos").document(key).set(anioAcademico)
                                    .addOnSuccessListener(aVoid -> callback.onSuccess())
                                    .addOnFailureListener(e -> callback.onFailure(e));
                        } else {
                            // Duplicado encontrado o error ocurrido
                            if (task.isSuccessful()) {
                                callback.onFailure(new Exception("El año académico ya existe"));
                            } else {
                                callback.onFailure(task.getException());
                            }
                        }

                    }
                });

    }

    private void createGradosForAnioAcademico(AnioAcademico anioAcademico) {
        GradoController gradoController = new GradoController();
        List<Grado> grados = new ArrayList<>();
        grados.add(new Grado(UUID.randomUUID().toString(), "Primer Grado", "Descripción del Primer Grado"));
        grados.add(new Grado(UUID.randomUUID().toString(), "Segundo Grado", "Descripción del Segundo Grado"));
        grados.add(new Grado(UUID.randomUUID().toString(), "Tercer Grado", "Descripción del Tercer Grado"));
        grados.add(new Grado(UUID.randomUUID().toString(), "Cuarto Grado", "Descripción del Cuarto Grado"));
        grados.add(new Grado(UUID.randomUUID().toString(), "Quinto Grado", "Descripción del Quinto Grado"));

        for (Grado grado : grados) {
            gradoController.addGrado(anioAcademico.getCodigoAnioAcademico(), grado);
        }
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
        void onSuccess();
        void onFailure(Exception e);
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
