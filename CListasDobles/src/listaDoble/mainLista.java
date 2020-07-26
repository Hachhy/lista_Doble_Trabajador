package listaDoble;

import java.util.Scanner;

public class mainLista {

    static Scanner sc = new Scanner(System.in);
    static subMenu sMenu = new subMenu();

    public static void main(String[] args) {
        onDisplay();
    }

    static void onDisplay() {

        int option = -1;
        while (option != 0) {

            sMenu.strongLine = true;
            System.out.print("\n" + sMenu.line() + "\n\tLista Doble de Elementos         |\n"
                    + sMenu.line() + "\n"
                    + "1)> Insertar elemento                    |\n"
                    + "2)> Eliminar elemento                    |\n"
                    + "3)> Mostrar elementos                    |\n"
                    + "4)> Buscar elemento                      |\n"
                    + "5)> Ordenar elementos                    |\n"
                    + "6)> Intercambiar elementos               |\n"
                    + "7)> Modificar elemento                   |\n"
                    + "8)> Obtener tamaño de la lista           |\n"
                    + "0)> Salir                                |\n" + sMenu.line());

            System.out.print("\nIngrese una opcion: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    sMenu.addNumber();
                    break;
                case 2:
                    sMenu.removeNumber();
                    break;
                case 3:
                    sMenu.list.showList();
                    break;
                case 4:
                    sMenu.search();
                    break;
                case 5:
                    sMenu.sort();
                    break;
                case 6:
                    sMenu.exchange();
                    break;
                case 7:
                    System.out.print("Elemento a modificar: ");
                    int e = sc.nextInt();
                    System.out.print("Nuevo elemento:");
                    int ne = sc.nextInt();
                    sMenu.list.editNumber(e, ne);
                    break;
                case 8:
                    System.out.println("Tamaño de la lista: " + sMenu.list.getSize() + " elementos");
                    break;
                case 0:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("No es una opcion");
                    break;
            }
        }
    }
}
