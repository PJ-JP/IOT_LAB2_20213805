package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demo.base.Global;
import com.example.demo.databinding.ActivityCrearApointBinding;
import com.example.demo.databinding.ActivityCrearRouterBinding;
import com.example.demo.entity.APoint;
import com.example.demo.entity.Router;

public class CrearApointActivity extends AppCompatActivity {

    ActivityCrearApointBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearApointBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.context_back) {

            String marca=binding.textView5.getText().toString();
            String frecuencia=binding.spinner.getSelectedItem().toString();
            String alcance=binding.textView7.getText().toString();
            String estado=binding.spinner2.getSelectedItem().toString();
            if(marca.equals("")||frecuencia.equals("")||alcance.equals("")||estado.equals("")){
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                return false;
            }else{
                APoint apoint= new APoint(marca,frecuencia,alcance,estado);
                Global.listaAPoints.add(apoint);
                Intent intent = new Intent(this, ApointActivity.class);
                startActivity(intent);
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }
}