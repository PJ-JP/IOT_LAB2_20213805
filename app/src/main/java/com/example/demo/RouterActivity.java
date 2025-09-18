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
import com.example.demo.databinding.ActivityRouterBinding;
import com.example.demo.entity.ListaRoutersAdapter;
import com.example.demo.entity.Router;

import java.util.ArrayList;
import java.util.List;

public class RouterActivity extends AppCompatActivity {
    ActivityRouterBinding binding;
    private List<Router> routerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRouterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //De alguna base... routerList = (List<Router>) intent.getSerializableExtra("lista");
    public void cargarLista() {
        //List<Router> routerList = lista;
        routerList = Global.listaRouters;
        ListaRoutersAdapter listaRoutersAdapter = new ListaRoutersAdapter();
        listaRoutersAdapter.setListaRouters(routerList);
        listaRoutersAdapter.setContext(RouterActivity.this);
        binding.recyclerView.setAdapter(listaRoutersAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(RouterActivity.this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        cargarLista();
    }

    public void crearRouter(View view){
        Intent intent = new Intent(this, CrearRouterActivity.class);
        startActivity(intent);
    }

}