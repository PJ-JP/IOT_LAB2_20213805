package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.demo.base.Global;
import com.example.demo.databinding.ActivityApointBinding;
import com.example.demo.databinding.ActivityRouterBinding;
import com.example.demo.entity.APoint;
import com.example.demo.entity.ListaAPointAdapter;
import com.example.demo.entity.ListaRoutersAdapter;

import java.util.List;

public class ApointActivity extends AppCompatActivity {

    ActivityApointBinding binding;
    private List<APoint> apointList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApointBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cargarLista() {
        //List<Router> routerList = lista;
        apointList = Global.listaAPoints;
        ListaAPointAdapter listaAPointAdapter = new ListaAPointAdapter();
        listaAPointAdapter.setListaApoints(apointList);
        listaAPointAdapter.setContext(ApointActivity.this);
        binding.recyclerView.setAdapter(listaAPointAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(ApointActivity.this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        cargarLista();
    }

    public void crearAPoint(View view){
        Intent intent = new Intent(this, CrearApointActivity.class);
        startActivity(intent);
    }

}