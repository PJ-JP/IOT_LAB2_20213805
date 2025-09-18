package com.example.demo.entity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.demo.CrearRouterActivity;
import com.example.demo.CrearSwitchActivity;
import com.example.demo.R;
import com.example.demo.RouterActivity;
import com.example.demo.base.Global;
import com.example.demo.databinding.ActivityRouterBinding;
import com.example.demo.databinding.ActivitySwitchBinding;

import java.util.List;

public class SwitchActivity extends AppCompatActivity {
    ActivitySwitchBinding binding;
    private List<Switch> switchList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySwitchBinding.inflate(getLayoutInflater());
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
        switchList = Global.listaSwitches;
        ListaSwitchesAdapter listaSwitchesAdapter = new ListaSwitchesAdapter();
        listaSwitchesAdapter.setListaSwitches(switchList);
        listaSwitchesAdapter.setContext(SwitchActivity.this);
        binding.recyclerView.setAdapter(listaSwitchesAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(SwitchActivity.this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        cargarLista();
    }

    public void crearSwitch(View view){
        Intent intent = new Intent(this, CrearSwitchActivity.class);
        startActivity(intent);
    }
}