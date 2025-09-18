package com.example.demo;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Asumo que tienes una clase Router en este paquete o la importas correctamente
import com.example.demo.entity.APoint;
import com.example.demo.entity.Router;
// Asumo que tienes una clase Global con tu lista de routers
import com.example.demo.base.Global;

import com.example.demo.databinding.ActivityReporteBinding; // Cambiado para el ejemplo, ajusta a tu binding real
import com.example.demo.entity.Switch;

import java.util.ArrayList;
import java.util.List;

public class ReporteActivity extends AppCompatActivity {


    ActivityReporteBinding binding;

    private List<String> equiposOperativos = new ArrayList<>();
    private List<String> equiposEnReparacion = new ArrayList<>();
    private List<String> equiposDadosDeBaja = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReporteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Global.listaRouters != null) { //amarillo
            for (Router router : Global.listaRouters) {
                if (router != null && router.getEstado() != null && router.getMarca() != null && router.getModelo() != null) {
                    String nombreEquipo = "Router " + router.getMarca() + " " + router.getModelo();
                    String estado = router.getEstado();

                    if (estado.equalsIgnoreCase("Operativo")) {
                        equiposOperativos.add(nombreEquipo);
                    } else if (estado.equalsIgnoreCase("En reparación") || estado.equalsIgnoreCase("En reparacion")) { // o sin tilde
                        equiposEnReparacion.add(nombreEquipo);
                    } else if (estado.equalsIgnoreCase("Dado de baja")) {
                        equiposDadosDeBaja.add(nombreEquipo);
                    }
                }
            }
            for (Switch switche : Global.listaSwitches) {
                if (switche != null && switche.getEstado() != null && switche.getMarca() != null && switche.getModelo() != null) {
                    String nombreEquipo = "Switch " + switche.getMarca() + " " + switche.getModelo();
                    String estado = switche.getEstado();
                    if (estado.equalsIgnoreCase("Operativo")) {
                        equiposOperativos.add(nombreEquipo);
                    } else if (estado.equalsIgnoreCase("En reparación") || estado.equalsIgnoreCase("En reparacion")) { // o sin tilde
                        equiposEnReparacion.add(nombreEquipo);
                    } else if (estado.equalsIgnoreCase("Dado de baja")) {
                        equiposDadosDeBaja.add(nombreEquipo);
                    }
                }
            }
            for (APoint aPoint : Global.listaAPoints) {
                if (aPoint != null && aPoint.getEstado() != null && aPoint.getMarca() != null) {
                    String nombreEquipo = "AP " + aPoint.getMarca();
                    String estado = aPoint.getEstado();
                    if (estado.equalsIgnoreCase("Operativo")) {
                        equiposOperativos.add(nombreEquipo);
                    } else if (estado.equalsIgnoreCase("En reparación") || estado.equalsIgnoreCase("En reparacion")) { // o sin tilde
                        equiposEnReparacion.add(nombreEquipo);
                    } else if (estado.equalsIgnoreCase("Dado de baja")) {
                        equiposDadosDeBaja.add(nombreEquipo);
                    }
                }
            }
        }
        LinearLayout parentLayout = findViewById(R.id.main);
        TextView myTextView = new TextView(this);
        myTextView.setText("Operativos ("+equiposOperativos.size()+")");
        myTextView.setTextSize(20); // (en sp)
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        myTextView.setLayoutParams(layoutParams);
        parentLayout.addView(myTextView);
        for (String equipo : equiposOperativos) {
            TextView textView = new TextView(this);
            textView.setText(equipo);
            textView.setTextSize(16); // (en sp)
            textView.setLayoutParams(layoutParams);
            parentLayout.addView(textView);
        }

        TextView myTextView2 = new TextView(this);
        myTextView2.setText("En reparación ("+equiposEnReparacion.size()+")");
        myTextView2.setTextSize(20); // (en sp)
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        myTextView2.setLayoutParams(layoutParams2);
        parentLayout.addView(myTextView2);
        for (String equipo : equiposEnReparacion) {
            TextView textView = new TextView(this);
            textView.setText(equipo);
            textView.setTextSize(16); // (en sp)
            textView.setLayoutParams(layoutParams2);
            parentLayout.addView(textView);
        }

        TextView myTextView3 = new TextView(this);
        myTextView3.setText("Dados de baja ("+equiposDadosDeBaja.size()+")");
        myTextView3.setTextSize(20); // (en sp)
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        myTextView3.setLayoutParams(layoutParams3);
        parentLayout.addView(myTextView3);
        for (String equipo : equiposDadosDeBaja) {
            TextView textView = new TextView(this);
            textView.setText(equipo);
            textView.setTextSize(16); // (en sp)
            textView.setLayoutParams(layoutParams3);
            parentLayout.addView(textView);
        }
    }
}