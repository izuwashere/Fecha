
package com.mycompany.fecha;

import Servicios.ServicioFecha;


public class Fecha {

    public static void main(String[] args) {
        ServicioFecha fechaServicio = new ServicioFecha();
        
        fechaServicio.crearFecha();
        Entidad.Fecha fecha = null;
        fechaServicio.mostrarDiaAnterior(fecha);
        fechaServicio.mostrarDiaPosterior(fecha);
        fechaServicio.mostrarDiasMes(fecha);
    }
}
