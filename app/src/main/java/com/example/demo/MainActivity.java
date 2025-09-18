package com.example.demo;

import static com.example.demo.base.Global.listaRouters;
import static com.example.demo.base.Global.listaSwitches;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demo.base.Global;
import com.example.demo.entity.Router;
import com.example.demo.entity.Switch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        if(Global.sc.equals("Init")){
            Router router= new Router("Cisco","ISR 4451-X","1 Gbps","Operativo");
            Router router2= new Router("Cisco","2960","1000 mbps","En reparación");
            Router router3= new Router("Cisco","2960","1000 mbps","Dado de baja");
            Router router4= new Router("Cisco","2960","1000 mbps","Operativo");
            listaRouters.add(router);
            listaRouters.add(router2);
            listaRouters.add(router3);
            listaRouters.add(router4);
            Switch switche= new Switch("Cisco","2960","1000 mbps","Administrable","Operativo");
            Switch switche2= new Switch("Cisco","2960","1000 mbps","No administrable","En reparación");
            Switch switche3= new Switch("Cisco","2960","1000 mbps","Administrable","Dado de baja");
            Switch switche4= new Switch("Cisco","2960","1000 mbps","No administrable","Operativo");
            listaSwitches.add(switche);
            listaSwitches.add(switche2);
            listaSwitches.add(switche3);
            listaSwitches.add(switche4);
            Global.sc="OK";
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void routerActivity(View view) {
        Intent intent = new Intent(this, RouterActivity.class);
        //intent.putExtra("lista", (java.io.Serializable) listaRouters);
        startActivity(intent);
    }


}