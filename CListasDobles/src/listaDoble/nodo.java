package listaDoble;

public class nodo {

    private int number;
    private nodo next, prev;

    public nodo() {
        this.number = 0;
        this.next = null;
        this.prev = null;
    }

    public nodo(int n, nodo next, nodo prev) {
        this.number = n;
        this.next = next;
        this.prev = prev;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int n) {
        this.number = n;
    }

    public nodo getNext() {
        return next;
    }

    public void setNext(nodo next) {
        this.next = next;
    }

    public nodo getPrev() {
        return prev;
    }

    public void setPrev(nodo prev) {
        this.prev = prev;
    }
}
