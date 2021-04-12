package app;
import java.util.*;

public class AppProcedural {
    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int lado1, lado2, lado3;
        System.out.println("Ingresar los lados del triangulo:");
        lado1 = Teclado.nextInt();
        lado2 = Teclado.nextInt();
        lado3 = Teclado.nextInt();
        if (lado1 == lado2 && lado2 == lado3)
            System.out.println("El triangulo es equilatero.");
        else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3)
            System.out.println("El triangulo es isosceles.");
        else
            System.out.println("El triangulo es escaleno.");
    }
}
