
package Servicios;

import Entidad.Fecha;
import java.util.Scanner;


public class ServicioFecha {
    
    Scanner leer = new Scanner(System.in);
    
    Fecha fecha1 = new Fecha();
    
    int dia = fecha1.getdia();
    int mes = fecha1.getmes();
    int year = fecha1.getyear();
    
    // Método para crear una nueva fecha ingresando el año, el mes y el día   
    public Fecha crearFecha() {
        
        System.out.println("Ingrese el año (1900-2021): ");
        fecha1.setyear(leer.nextInt());

        System.out.println("Ingrese el mes (1-12): ");
        fecha1.setmes(leer.nextInt());

        System.out.println("Ingrese el día: ");
        fecha1.setdia(leer.nextInt());
        
        

        return null;
    }
    
    public void mostrarDiaAnterior(Fecha fecha) {

        if (dia > 1) {
            fecha.setdia(dia - 1);
        } else {
            if (mes > 1) {
                // Si el día es 1 y el mes es mayor que 1, retroceder al mes anterior
                mes--;
                int diasMesAnterior = obtenerDiasMes(mes);
                fecha.setmes(mes);
                fecha.setdia(diasMesAnterior);
            } else {
                // Si el día es 1 y el mes es enero, retroceder al 31 de diciembre del año anterior
                mes = 12;
                fecha.setmes(mes);
                fecha.setdia(31);
                fecha.setyear(year - 1);
            }
        }

        System.out.println("Día anterior: " + dia + "/" + mes + "/" + year);
    }

    // Método para mostrar el día posterior a la fecha proporcionada
    public void mostrarDiaPosterior(Fecha fecha) {
    
        int diasMes = obtenerDiasMes(mes);

        if (dia < diasMes) {
            fecha.setdia(dia + 1); // Si el día actual es menor que la cantidad de días en el mes, sumar 1 al día
        } else {
            if (mes < 12) {
                // Si el día es igual a la cantidad de días en el mes y el mes es menor que 12, avanzar al mes siguiente
                mes++;
                fecha.setmes(mes);
                fecha.setdia(1);
            } else {
                // Si el día es igual a la cantidad de días en el mes y el mes es diciembre, avanzar al 1 de enero del año siguiente
                mes = 1;
                fecha.setmes(mes);
                fecha.setdia(1);
                fecha.setyear(year + 1);
            }
        }

        System.out.println("Día posterior: " + fecha.getdia() + "/" + fecha.getmes() + "/" + fecha.getyear());
       }   

    // Método para mostrar la cantidad de días en el mes actual
    public void mostrarDiasMes(Fecha fecha) {
        int diasMes = obtenerDiasMes(mes);
        System.out.println("El mes " + mes + " tiene " + diasMes + " días");
    }

    // Método para verificar si el año actual es bisiesto
    public boolean esBisiesto(Fecha fecha) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Método para obtener la cantidad de días en un mes dado
    private int obtenerDiasMes(int mes) {
        //Switch para obtener la cantidad de días en el mes
        return switch (mes) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> fecha.esBisiesto() ? 29 : 28;
            default -> 31;
        };
    }
}
