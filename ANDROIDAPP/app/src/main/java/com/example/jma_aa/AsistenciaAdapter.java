package com.example.jma_aa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jma_aa.modelos.Estudiante;
import java.util.List;

public class AsistenciaAdapter extends RecyclerView.Adapter<AsistenciaAdapter.AsistenciaViewHolder> {

    private Context context;
    private List<Estudiante> estudiantes;
    private String[] estados = {"Presente", "Ausente", "Tardanza"};

    public AsistenciaAdapter(Context context, List<Estudiante> estudiantes) {
        this.context = context;
        this.estudiantes = estudiantes;
    }

    @NonNull
    @Override
    public AsistenciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_asistencia, parent, false);
        return new AsistenciaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsistenciaViewHolder holder, int position) {
        Estudiante estudiante = estudiantes.get(position);
        holder.tvNombre.setText(estudiante.getNombre() + " " + estudiante.getApellido());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, estados);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinnerEstado.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return estudiantes.size();
    }

    public static class AsistenciaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;
        Spinner spinnerEstado;

        public AsistenciaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            spinnerEstado = itemView.findViewById(R.id.spinnerEstado);
        }
    }
}
