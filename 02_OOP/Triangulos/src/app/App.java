package app;

import java.util.Scanner;

public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        /** Reemplazo todo este codigo con una funcion generica
        double lado1;
        lado1 = Teclado.nextDouble();
        Teclado.nextLine();
        
        System.out.println("Ingrese Lado 2)");
        double lado2;
        lado2 = Teclado.nextDouble();
        Teclado.nextLine();
        
        System.out.println("Ingrese Lado 3)");
        double lado3;
        lado3 = Teclado.nextDouble();
        Teclado.nextLine();*/

        double lado1 = ingresarLado(1);
        double lado2 = ingresarLado(2);
        double lado3 = ingresarLado(3);

        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);

        System.out.println("El Triangulo es:" + triangulo.resolverTipo());

    }

    public static double ingresarLado(int numero) {
        System.out.println("Ingrese Lado " + numero + ")");
        double lado;
        lado = Teclado.nextDouble();
        Teclado.nextLine();
        return lado;
    }
}
