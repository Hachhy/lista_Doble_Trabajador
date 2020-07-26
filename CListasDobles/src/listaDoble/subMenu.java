package listaDoble;

import java.util.Scanner;

public class subMenu {

    Scanner sc = new Scanner(System.in);
    listaDoble list = new listaDoble();
    boolean strongLine = true;

    public void addNumber() {
        strongLine = false;
        System.out.print("\n" + line()
                + "\n\t Insertar         |\n" + line()
                + "\n1)> Al inicio             |"
                + "\n2)> Al final              |"
                + "\n3)> Por posición          |"
                + "\n4)> Por elemento          |"
                + "\n0)> Menu                  |\n" + line() + "\n");
        int option = option();
        if (option == 1) {
            list.addxFirst();
        }
        if (option == 2) {
            list.addxLast();
        }
        if (option == 3) {
            list.addxPosition(option2("p"));
        }
        if (option == 4) {
            list.addxElement(option2("e"));
        }
    }

    public void removeNumber() {
        strongLine = false;
        System.out.print("\n" + line()
                + "\n\t Eliminar         |\n" + line()
                + "\n1)> Al inicio             |"
                + "\n2)> Al final              |"
                + "\n3)> Por posición          |"
                + "\n4)> Por elemento          |"
                + "\n0)> Menu                  |\n" + line() + "\n");
        int option = option();
        if (option == 1) {
            list.removexFirst();
        }
        if (option == 2) {
            list.removexLast();
        }
        if (option == 3) {
            list.removexPosition(option2("p"));
        }
        if (option == 4) {
            list.removexElement(option2("e"));
        }
    }

    public void search() {
        strongLine = false;
        System.out.print("\n" + line()
                + "\n\t Buscar           |\n" + line()
                + "\n1)> Por posicion          |"
                + "\n2)> Por elemento          |"
                + "\n0)> Menu                  |\n" + line() + "\n");
        int option = option();
        if (option == 1) {
            list.searchxPosition(option2("p"));
        }
        if (option == 2) {
            list.searchxElement(option2("e"));
        }
    }

    public void sort() {
        strongLine = false;
        System.out.print("\n" + line()
                + "\n\t Ordenar          |\n" + line()
                + "\n1)> Ascendente            |"
                + "\n2)> Descendente           |"
                + "\n0)> Menu                  |\n" + line() + "\n");
        int option = option();
        if (option == 1) {
            list.sortList(true);
        }
        if (option == 2) {
            list.sortList(false);
        }
    }

    public void exchange() {
        strongLine = false;
        System.out.print("\n" + line() + "---------------"
                + "\n\t\tIntercambio              |\n" + line() + "---------------"
                + "\n 1)> Elemento mayor con ultimo elemento  |"
                + "\n 2)> Elemento menor con primer elemento  |"
                + "\n 3)> Primer par con el primer impar      |"
                + "\n 0)> menu                                |\n" + line()
                + "---------------\n");
        int option = option();
        if (option == 1) {
            list.majorxLast();
        }
        if (option == 2) {
            list.minorxFirst();
        }
        if (option == 3) {
            list.evenxOdd();
        }

    }

    public int option2(String option) {
        int data = 0;
        if (option.equals("p")) {
            System.out.print("Ingrese posicion: ");
            data = sc.nextInt();
        }
        if (option.equals("e")) {
            System.out.print("Ingrese elemento: ");
            data = sc.nextInt();
        }
        return data;
    }

    public int option() {
        System.out.print("Opcion: ");
        int option = sc.nextInt();
        return option;
    }

    public String line() {
        String l1 = "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";
        String l2 = "---------------------------";
        if (strongLine) {
            return l1;
        } else {
            return l2;
        }

    }
}
