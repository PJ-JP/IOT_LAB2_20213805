package com.example.demo.entity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.DetallesSwitchActivity;
import com.example.demo.databinding.SwitchRvBinding;

import java.util.List;
public class ListaSwitchesAdapter
        extends RecyclerView.Adapter<ListaSwitchesAdapter.SwitchViewHolder>{
    private List<Switch> lSwitches;
    private Context context;

    @NonNull
    @Override
    public SwitchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        SwitchRvBinding binding = SwitchRvBinding.inflate(inflater, parent, false);
        return new SwitchViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SwitchViewHolder holder, int position) {
        Switch switche = lSwitches.get(position);
        holder.switche = switche;

        TextView tvMarca = holder.binding.textView5;
        TextView tvModelo = holder.binding.textView6;
        TextView tvCantidadPuertos = holder.binding.textView7;
        TextView tvTipo = holder.binding.textView8;
        TextView tvEstado = holder.binding.textView10;


        tvMarca.setText(switche.getMarca());
        tvModelo.setText(switche.getModelo());
        tvCantidadPuertos.setText(switche.getCantidadPuertos());
        tvTipo.setText(switche.getTipo());
        tvEstado.setText(switche.getEstado());

        //oculto.setText(String.valueOf(position));
        holder.binding.getRoot().setOnClickListener(view -> {
            Intent intent = new Intent(context, DetallesSwitchActivity.class);
            intent.putExtra("switch", switche);
            intent.putExtra("posicion", position);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lSwitches.size();
    }

    public void setListaSwitches(List<Switch> listaSwitches) {
        this.lSwitches = listaSwitches;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public static class SwitchViewHolder extends RecyclerView.ViewHolder {
        SwitchRvBinding binding;
        Switch switche;

        public SwitchViewHolder(SwitchRvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
