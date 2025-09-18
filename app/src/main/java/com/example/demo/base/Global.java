package com.example.demo.base;

import com.example.demo.entity.APoint;
import com.example.demo.entity.Router;
import com.example.demo.entity.Switch;

import java.util.ArrayList;
import java.util.List;

public class Global {
    public static List<Router> listaRouters = new ArrayList<>();
    public static List<Switch> listaSwitches = new ArrayList<>();

    public static List<APoint> listaAPoints = new ArrayList<>();
    public static String sc="Init";
}
