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
import com.example.demo.databinding.ActivityCrearRouterBinding;
import com.example.demo.databinding.ActivityRouterBinding;
import com.example.demo.entity.Router;

public class CrearRouterActivity extends AppCompatActivity {

    ActivityCrearRouterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearRouterBinding.inflate(getLayoutInflater());
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
            String modelo=binding.textView6.getText().toString();
            String velocidad=binding.textView7.getText().toString();
            String estado=binding.spinner.getSelectedItem().toString();
            if(marca.equals("")||modelo.equals("")||velocidad.equals("")||estado.equals("")){
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                return false;
            }else{
                Router router= new Router(marca,modelo,velocidad,estado);
                Global.listaRouters.add(router);
                Intent intent = new Intent(this, RouterActivity.class);
                startActivity(intent);
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

}