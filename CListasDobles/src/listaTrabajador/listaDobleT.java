package listaTrabajador;

public class listaDobleT {

    private nodoT first, last;
    private int size;

    public listaDobleT() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void addxFirst(String n, int h, double t) {
        nodoT newWorker = new nodoT();
        newWorker.setNombre(n);
        newWorker.setHoras(h);
        newWorker.setTarifa(t);

        if (isEmpty()) {
            System.out.println("new");
            first = newWorker;
            last = newWorker;
        } else {
            first.setPrev(newWorker);
            newWorker.setNext(first);
            first = newWorker;
        }
        System.out.println("Trabajador insertado al inicio");
        size++;
    }

    public void removexFirst() {
        if (!isEmpty()) {
            String name = first.getNombre();
            if (first == last) {
                first = null;
            } else {
                nodoT aux = first;
                first = aux.getNext();
                first.setPrev(null);
            }
            size--;
            System.out.println("Eliminado: " + name);
            showList();
        } else {
            emptyLine();

        }
    }

    public void search(String n) {
        if (!isEmpty()) {
            nodoT aux = first;
            while (aux != null) {
                if (aux.getNombre().equalsIgnoreCase(n)) {

                    System.out.println("Trabajador encontrado: " + aux.getNombre());
                    System.out.println("\n____________________________________\n"
                            + "Trabajador: " + aux.getNombre());
                    System.out.println("Horas trabajadas: " + aux.getHoras());
                    System.out.println("Tarifa por hora: " + aux.getTarifa());

                    int h = aux.getHoras(), ext = 0, exc = 0;
                    double t = aux.getTarifa(), m = 0;

                    if (h <= 40) {
                        m = h * t;
                    }
                    if (h > 40 && h <= 48) {
                        ext = h - 40;
                        m = (40 * t) + (ext * t * 2);
                    }
                    if (h > 48) {
                        ext = 8;
                        exc = h - 48;
                        m = (40 * t) + (ext * t * 2) + (exc * 3 * t);
                    }
                    System.out.println("Horas extras: " + ext);
                    System.out.println("Horas extras en exceso: " + exc);
                    System.out.println("Monto a recibir: S/." + m);
                    return;
                }
                aux = aux.getNext();
            }
            if (aux == null) {
                System.out.println("El nombre no existe en la lista");
            }
        } else {
            emptyLine();
        }
    }

    public void editWorker(String n, String nn) {
        if (!isEmpty()) {
            nodoT aux = last;
            while (aux != null) {
                if (aux.getNombre().equalsIgnoreCase(n)) {
                    aux.setNombre(nn);
                    showList();
                    break;
                }
                aux = aux.getPrev();
            }
            if (aux == null) {
                System.out.println("El nombre no existe");
            }
        } else {
            emptyLine();
        }
    }

    public void showList() {
        if (!isEmpty()) {
            nodoT aux = first;
            System.out.println("\nLista de Trabajadores");
            do {
                System.out.println("\n____________________________________\n"
                        + "Trabajador: " + aux.getNombre());
                System.out.println("Horas trabajadas: " + aux.getHoras());
                System.out.println("Tarifa por hora: " + aux.getTarifa());

                int h = aux.getHoras(), ext = 0, exc = 0;
                double t = aux.getTarifa(), m = 0;

                if (h <= 40) {
                    m = h * t;
                }
                if (h > 40 && h <= 48) {
                    ext = h - 40;
                    m = (40 * t) + (ext * t * 2);
                }
                if (h > 48) {
                    ext = 8;
                    exc = h - 48;
                    m = (40 * t) + (ext * t * 2) + (exc * 3 * t);
                }

                System.out.println("Horas extras: " + ext);
                System.out.println("Horas extras en exceso: " + exc);
                System.out.println("Monto a recibir: S/." + m);

                aux = aux.getNext();
            } while (aux != null);
            System.out.println("");
        } else {
            emptyLine();

        }
    }

    public int getSize() {
        return size;
    }

    public void emptyLine() {
        System.out.println("La lista esta vacia");
    }

    public boolean isEmpty() {
        return first == null;
    }
}
