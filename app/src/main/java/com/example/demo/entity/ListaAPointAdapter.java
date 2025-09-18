package com.example.demo.entity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.demo.DetallesApointActivity;
import com.example.demo.databinding.ApointRvBinding;

import java.util.List;
import java.util.zip.Inflater;

public class ListaAPointAdapter
        extends RecyclerView.Adapter<ListaAPointAdapter.APointViewHolder> {

    private List<APoint> lAPoints;
    private Context context;

    @NonNull
    @Override
    public APointViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ApointRvBinding binding= ApointRvBinding.inflate(inflater, parent, false);
        return new APointViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull APointViewHolder holder, int position) {
        APoint aPoint = lAPoints.get(position);
        holder.aPoint = aPoint;

        TextView tvMarca = holder.binding.textView5;
        TextView tvFrecuencia = holder.binding.textView6;
        TextView tvAlcance = holder.binding.textView7;
        TextView tvEstado = holder.binding.textView8;
        tvMarca.setText(aPoint.getMarca());
        tvFrecuencia.setText(aPoint.getFrecuencia());
        tvAlcance.setText(aPoint.getAlcance());
        tvEstado.setText(aPoint.getEstado());

        holder.binding.getRoot().setOnClickListener(view -> {
            Intent intent = new Intent(context, DetallesApointActivity.class);
            intent.putExtra("aPoint", aPoint);
            intent.putExtra("posicion", position);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lAPoints.size();
    }

    public void setListaApoints(List<APoint> lista) {
        this.lAPoints = lista;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public static class APointViewHolder extends RecyclerView.ViewHolder {
        ApointRvBinding binding;
        APoint aPoint;

        public APointViewHolder(ApointRvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
