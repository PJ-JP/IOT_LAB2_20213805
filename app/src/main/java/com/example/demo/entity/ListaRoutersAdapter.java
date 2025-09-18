package com.example.demo.entity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.DetallesRouterActivity;
import com.example.demo.databinding.RouterRvBinding;
import com.example.demo.entity.Router;
public class ListaRoutersAdapter
       extends RecyclerView.Adapter<ListaRoutersAdapter.RouterViewHolder>{
    private List<Router> lRouters;
    private Context context;

    @NonNull
    @Override
    public RouterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        RouterRvBinding binding = RouterRvBinding.inflate(inflater, parent, false);
        return new RouterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RouterViewHolder holder, int position) {
        Router router = lRouters.get(position);
        holder.router = router;
        TextView tvMarca = holder.binding.textView5;
        TextView tvModelo = holder.binding.textView6;
        TextView tvVelocidad = holder.binding.textView7;
        TextView tvEstado = holder.binding.textView8;
        //TextView oculto = holder.binding.oculto;
        tvMarca.setText(router.getMarca());
        tvModelo.setText(router.getModelo());
        tvVelocidad.setText(router.getVelocidad());
        tvEstado.setText(router.getEstado());

        holder.binding.getRoot().setOnClickListener(view -> {
            Intent intent = new Intent(context, DetallesRouterActivity.class);
            intent.putExtra("router", router);
            intent.putExtra("posicion", position);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lRouters.size();
    }

    public void setListaRouters(List<Router> listaRouters) {
        this.lRouters = listaRouters;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public static class RouterViewHolder extends RecyclerView.ViewHolder {
        RouterRvBinding binding;
        Router router;

        public RouterViewHolder(RouterRvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
