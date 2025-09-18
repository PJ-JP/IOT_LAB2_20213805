package com.example.demo;

import static com.example.demo.base.Global.listaAPoints;
import static com.example.demo.base.Global.listaRouters;
import static com.example.demo.base.Global.listaSwitches;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demo.databinding.ActivityDetallesApointBinding;
import com.example.demo.databinding.ActivityDetallesRouterBinding;
import com.example.demo.entity.APoint;
import com.example.demo.entity.Router;
import com.example.demo.entity.SwitchActivity;

public class DetallesApointActivity extends AppCompatActivity {

    ActivityDetallesApointBinding binding;
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetallesApointBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();

        posicion = intent.getIntExtra("posicion", -1);

        APoint aPoint = (APoint) intent.getSerializableExtra("apoint");
        binding.textView5.setText(aPoint.getMarca());
        String f = aPoint.getFrecuencia();
        ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>) binding.spinner.getAdapter(); //desde el xml
        if (adapter != null) {
            for (int i = 0; i < adapter.getCount(); i++) {
                if (adapter.getItem(i) != null && adapter.getItem(i).toString().equals(f)) {
                    binding.spinner.setSelection(i);
                    break;
                }
            }
        }
        binding.textView7.setText(aPoint.getAlcance());
        String estado = aPoint.getEstado();
        ArrayAdapter<CharSequence> adapter1 = (ArrayAdapter<CharSequence>) binding.spinner2.getAdapter(); //desde el xml
        if (adapter1 != null) {
            for (int i = 0; i < adapter1.getCount(); i++) {
                if (adapter1.getItem(i) != null && adapter1.getItem(i).toString().equals(estado)) {
                    binding.spinner.setSelection(i);
                    break;
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save) {
            String marca=binding.textView5.getText().toString();
            String frecuencia=binding.spinner.getSelectedItem().toString();
            String alcance=binding.textView7.getText().toString();
            String estado=binding.spinner2.getSelectedItem().toString();

            if(marca.equals("")||frecuencia.equals("")||alcance.equals("")||estado.equals("")){
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                APoint aPoint = new APoint(marca, frecuencia, alcance, estado);
                listaAPoints.set(posicion, aPoint);
                Intent intent = new Intent(this, RouterActivity.class);
                startActivity(intent);
                return true;
            }
        }
        if (item.getItemId() == R.id.delete) {
            mostrarDialogo();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void mostrarDialogo() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("¿Está seguro que desea borrar?");
        //alertDialog.setMessage("C!!");

        alertDialog.setPositiveButton("Aceptar", (dialogInterface, i) -> {
            //Otra vista... alguna posición
            listaAPoints.remove(posicion);
            Intent intent = new Intent(this, ApointActivity.class);
            startActivity(intent);
        });

        alertDialog.setNegativeButton("Cancelar", ((dialogInterface, i) -> {
        }));

        alertDialog.show();
    }
}