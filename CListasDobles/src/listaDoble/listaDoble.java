package listaDoble;

import java.util.Random;

public class listaDoble {

    private nodo first, last;
    private int size;
    final Random random = new Random();

    public listaDoble() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int randomNumber() {
        int number = (int) random.nextInt(91) + 10;
        return number;
    }

    public void addxFirst() {
        nodo newElement = new nodo();
        newElement.setNumber(randomNumber());
        if (isEmpty()) {
            first = newElement;
            last = newElement;

        } else {
            first.setPrev(newElement);
            newElement.setNext(first);
            first = newElement;

        }
        System.out.println("Numero insertado al inicio");
        size++;
    }

    public void addxLast() {
        nodo newElement = new nodo();
        newElement.setNumber(randomNumber());
        if (isEmpty()) {
            first = newElement;
            last = newElement;

        } else {
            newElement.setPrev(last);
            last.setNext(newElement);
            last = newElement;
        }
        System.out.println("Numero insertado al final");
        size++;
    }

    public void addxPosition(int pos) {
        nodo newElement = new nodo();
        nodo aux = first;
        nodo temp = aux;
        newElement.setNumber(randomNumber());
        if (pos > 0 && pos <= size) {
            if (pos == 1) {
                addxFirst();
                return;
            }
            if (pos == size) {
                temp = last.getPrev();
                newElement.setNext(last);
                temp.setNext(newElement);
                newElement.setPrev(temp);
                last.setPrev(newElement);
            } else {
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getNext();
                }

                temp = aux.getPrev();
                newElement.setNext(aux);
                temp.setNext(newElement);
                newElement.setPrev(temp);
                aux.setPrev(newElement);
            }

            System.out.println("Numero insertado en posicion " + pos);
            size++;
        } else {
            System.out.println("La posicion no existe");
        }
    }

    public void addxElement(int e) {
        nodo newElement = new nodo();
        newElement.setNumber(randomNumber());
        nodo aux = first;
        nodo temp = aux;
        if (isEmpty()) {
            first = newElement;
            last = newElement;
        } else {
            if (e == last.getNumber()) {
                addxLast();
                return;
            }
            do {
                if (aux.getNumber() == e) {
                    System.out.println("Numero insertado despues de: " + aux.getNumber());
                    temp = aux.getNext();
                    aux.setNext(newElement);
                    newElement.setPrev(aux);
                    newElement.setNext(temp);
                    temp.setPrev(newElement);
                    return;
                }
                aux = aux.getNext();
            } while (aux != null);
            if (aux == null) {
                System.out.println("No existe numero");
                return;
            }
        }
        size++;
    }

    public void showList() {
        if (!isEmpty()) {
            int i = 1;
            nodo aux = first;
            System.out.println("\nDe izquierda a derecha");
            do {
                System.out.print("[" + aux.getNumber() + "]__");
                aux = aux.getNext();
            } while (aux != null);
            aux = first;
            System.out.println("");
            while (aux != null) {
                if (i < 10) {
                    System.out.print(" (" + i + ")  ");
                }
                if (i > 9) {
                    System.out.print("(" + i + ")  ");
                }
                i++;
                aux = aux.getNext();
            }
            System.out.println("\n\nDe derecha a izquierda");
            aux = last;
            i--;
            do {
                System.out.print("__[" + aux.getNumber() + "]");
                aux = aux.getPrev();
            } while (aux != null);
            aux = last;
            System.out.println("");
            while (aux != null) {
                if (i < 10) {
                    System.out.print("   (" + i + ")");
                }
                if (i > 9) {
                    System.out.print("  (" + i + ")");
                }
                i--;
                aux = aux.getPrev();
            }
            System.out.println("");
        } else {
            emptyLine();

        }
    }

    public void removexFirst() {
        if (!isEmpty()) {
            int number = first.getNumber();
            if (first == last) {
                first = null;
            } else {
                nodo aux = first;
                first = aux.getNext();
                first.setPrev(null);
            }
            size--;
            System.out.println("Eliminado: " + number);
            showList();
        } else {
            emptyLine();

        }
    }

    public void removexLast() {
        if (!isEmpty()) {
            int number = last.getNumber();
            if (first == last) {
                first = null;
            } else {
                nodo temp = last.getPrev();
                temp.setNext(null);
                last = temp;
            }
            size--;
            System.out.println("Eliminado: " + number);
            showList();
        } else {
            emptyLine();

        }
    }

    public void removexPosition(int pose) {
        if (!isEmpty()) {
            nodo aux = first;
            if (pose == 1) {
                removexFirst();
                return;
            }
            if (pose == size) {
                removexLast();
                return;
            } else {
                if (pose > 0 && pose < size) {
                    for (int i = 0; i < size && i < pose - 1; i++) {
                        aux = aux.getNext();
                    }
                    aux.getPrev().setNext(aux.getNext());
                    aux.getNext().setPrev(aux.getPrev());
                } else {
                    System.out.println("La posicion no existe");
                    return;
                }
            }
            size--;
            System.out.println("Eliminado: " + aux.getNumber());
            showList();
        } else {
            emptyLine();

        }
    }

    public void removexElement(int e) {
        if (!isEmpty()) {
            nodo aux = first;
            while (aux != null) {
                if (first.getNumber() == e) {
                    removexFirst();
                    return;
                }
                if (last.getNumber() == e) {
                    removexLast();
                    return;
                }
                if (aux.getNumber() == e) {
                    aux.getPrev().setNext(aux.getNext());
                    aux.getNext().setPrev(aux.getPrev());
                    System.out.println("Eliminado: " + aux.getNumber());
                    return;
                }
                aux = aux.getNext();
            }
            if (aux == null) {
                System.out.println("El numero no existe");
            }

        } else {
            emptyLine();

        }
    }

    public void searchxPosition(int p) {
        if (!isEmpty()) {
            nodo aux = first;
            if (p > 0 && p < (size + 1)) {
                for (int i = 0; i < p - 1 && i < size; i++) {
                    aux = aux.getNext();
                }
                System.out.println("Numero encontrado: " + aux.getNumber());
            } else {
                System.out.println("No existe la posicion");
            }
        } else {
            emptyLine();
        }
    }

    public void searchxElement(int e) {
        if (!isEmpty()) {
            nodo aux = first;
            while (aux != null) {
                if (aux.getNumber() == e) {
                    System.out.println("Numero encontrado: " + aux.getNumber());
                    return;
                }
                aux = aux.getNext();
            }
            if (aux == null) {
                System.out.println("El numero no existe en la lista");
            }
        } else {
            emptyLine();
        }

    }

    public void sortList(boolean as) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                nodo aux = first, aux2 = aux.getNext();
                int auxNumber;

                while (aux2 != null) {
                    if (aux.getNumber() > aux2.getNumber() && as == true) {
                        auxNumber = aux.getNumber();
                        aux.setNumber(aux2.getNumber());
                        aux2.setNumber(auxNumber);
                    }
                    if (aux.getNumber() < aux2.getNumber() && as == false) {
                        auxNumber = aux.getNumber();
                        aux.setNumber(aux2.getNumber());
                        aux2.setNumber(auxNumber);
                    }
                    aux = aux2;
                    aux2 = aux2.getNext();
                }
            }
            showList();

        } else {
            emptyLine();
        }

    }

    public void majorxLast() {
        if (!isEmpty()) {
            nodo aux = first, temp = aux;
            int major = 0;
            while (aux != null) {
                if (aux.getNumber() > major) {
                    temp = aux;
                    major = aux.getNumber();
                }
                aux = aux.getNext();
            }
            System.out.println("Numero mayor: " + major);
            System.out.println("Ultimo numero: " + last.getNumber());
            int tempNumber = temp.getNumber();
            temp.setNumber(last.getNumber());
            last.setNumber(tempNumber);
            showList();

        } else {
            emptyLine();
        }

    }

    public void minorxFirst() {
        if (!isEmpty()) {
            nodo aux = last, temp = aux;
            int minor = aux.getNumber();
            while (aux != null) {
                if (aux.getNumber() < minor) {
                    temp = aux;
                    minor = aux.getNumber();
                }
                aux = aux.getPrev();
            }
            System.out.println("Numero menor: " + minor);
            System.out.println("Primer numero: " + first.getNumber());
            int temp2 = temp.getNumber();
            first.setNumber(minor);
            temp.setNumber(temp2);
            showList();
        } else {
            emptyLine();
        }
    }

    public void evenxOdd() {
        if (!isEmpty()) {
            nodo aux = first, evenNode = aux, oddNode = aux;
            int even = 0, odd = 0;
            boolean evenFound = false, oddFound = false;
            while (aux != null) {
                if (aux.getNumber() % 2 == 0 && evenFound == false) {
                    evenNode = aux;
                    even = aux.getNumber();
                    evenFound = true;
                }
                if (aux.getNumber() % 2 != 0 && oddFound == false) {
                    oddNode = aux;
                    odd = aux.getNumber();
                    oddFound = true;
                }
                aux = aux.getNext();
            }
            if(even==0){
                System.out.println("Cambio fallido, no se encontro par");
                return;
            }
            if(odd==0){
                System.out.println("Cambio fallido, no se encontro impar");
                return;
            }
            System.out.println("Primer par: " + even + "\nPrimer impar: " + odd);
            evenNode.setNumber(odd);
            oddNode.setNumber(even);
            showList();
        } else {
            emptyLine();
        }

    }

    public void editNumber(int e, int ne) {
        if (!isEmpty()) {
            nodo aux = last;
            while (aux != null) {
                if (aux.getNumber() == e) {
                    aux.setNumber(ne);
                    showList();
                    break;
                }
                aux = aux.getPrev();
            }
            if (aux == null) {
                System.out.println("El numero no existe");
            }
        } else {
            emptyLine();
        }

    }

    public void emptyLine() {
        System.out.println("La lista esta vacia");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
