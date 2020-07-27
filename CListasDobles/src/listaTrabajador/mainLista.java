
package listaTrabajador;

import java.util.Scanner;


public class mainLista {
    static Scanner sc = new Scanner(System.in);
    static listaDobleT list =new listaDobleT();
    static boolean strongLine;

    public static void main(String[] args) {
        onDisplay();
    }

    static void onDisplay() {

        int option = -1;
        while (option != 0) {

            strongLine = true;
            System.out.print("\n" +line() + "\n\t    Pago de trabajadores         |\n"
                    + line() + "\n"
                    + "1)> Insertar dato                        |\n"
                    + "2)> Eliminar dato inicial                |\n"
                    + "3)> Buscar nombre                        |\n"
                    + "4)> Modificar nombre                     |\n"
                    + "5)> Mostrar datos                        |\n"
                    + "6)> Obtener tamaño de la lista           |\n"
                    + "0)> Salir                                |\n" + line());

            System.out.print("\nIngrese una opcion: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    addWorker();
                    break;
                case 2:
                    list.removexFirst();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String n=sc.nextLine();
                    list.search(n);
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String n1=sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nn=sc.nextLine();
                    list.editWorker(n1,nn);
                    break;
                case 5:
                    list.showList();
                    break;
                case 6:
                    System.out.println("Tamaño de la lista: " + list.getSize() + " Trabajadores");
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
    
    public static void addWorker(){
        sc.nextLine();
        System.out.print("Nombre: ");
        String n=sc.nextLine(); 
        System.out.print("Horas de trabajo: ");
        int h=sc.nextInt();
        System.out.print("Tarifa por hora: ");
        double t=sc.nextDouble();
        list.addxFirst(n,h,t);
        
    }
    
    public static String line() {
        String l1 = "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀";
        String l2 = "---------------------------";
        if (strongLine) {
            return l1;
        } else {
            return l2;
        }

    }
    
    
}
