
package listaTrabajador;

public class nodoT {
    
    private String nombre;
    private int horas;
    private double tarifa;
    private nodoT next,prev;
    
    public nodoT(){
        this.nombre="";
        this.horas=0;
        this.tarifa=0;
        this.next=null;
        this.prev=null;
    }
    
    public nodoT(String n,double t,int h, nodoT next, nodoT prev){
        this.nombre=n;
        this.horas=h;
        this.tarifa=t;
        this.next=next;
        this.prev=prev;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public nodoT getNext() {
        return next;
    }

    public void setNext(nodoT next) {
        this.next = next;
    }

    public nodoT getPrev() {
        return prev;
    }

    public void setPrev(nodoT prev) {
        this.prev = prev;
    }
    
    
    
}
