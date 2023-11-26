
package Entidad;


public class Fecha {
    private int dia;
    private int mes;
    private int year;
    
    public Fecha(){
        dia = 1;
        mes = 1;
        year = 1900;
    }
    
    public void setdia(int nextInt){
        this.dia = nextInt;
    }
    
    public void setmes(int nextInt){
        this.mes = nextInt;
    }
    
    public void setyear(int nextInt){
        this.year = nextInt;
    }
    
    public int getdia(){
        return dia;
    }
    
    public int getmes(){
        return mes;
    }
    
    public int getyear(){
        return year;
    }
}
