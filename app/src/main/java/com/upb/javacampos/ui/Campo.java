package com.upb.javacampos.ui;

import android.widget.Toast;

import com.upb.javacampos.MapsActivity;

import java.util.Date;
import com.upb.javacampos.*;
public class Campo {
    Date fecha_medicion;
    MapsActivity mapa;
    double intensidad_campo;
    double maximo_permitido;
    double porcentaje_intensidad_campo;
    Registro persona;
    public Campo(Date fecha_medicion,
            MapsActivity mapa,
            double intensidad_campo,
            double maximo_permitido,
            double porcentaje_intensidad_campo,
                 Registro persona){
        this.fecha_medicion = fecha_medicion;
        this.mapa = mapa;
        this.intensidad_campo = intensidad_campo;
        this.maximo_permitido = maximo_permitido;
        this.porcentaje_intensidad_campo = porcentaje_intensidad_campo;
        this.persona = persona;
    }
}
