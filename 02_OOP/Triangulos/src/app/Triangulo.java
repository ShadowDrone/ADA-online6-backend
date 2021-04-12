package app;

public class Triangulo {

    public Triangulo (double lado1,double lado2,double lado3){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    private double lado1;
    private double lado2;
    private double lado3;

    public double getLado1(){
        return this.lado1;
    }

    public void setLado1(double lado1){
        this.lado1 = lado1;
    }

    public double getLado2(){
        return this.lado2;
    }

    public void setLado2(double lado2){
        this.lado2 = lado2;
    }

    public double getLado3(){
        return this.lado3;
    }

    public void setLado3(double lado3){
        this.lado3 = lado3;
    }

    public String resolverTipo() {
        if (lado1 == lado2 && lado1 == lado3) {
            return "equilatero";
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return "isosceles";
        } else {
            return "escaleno";
        }

    }

    

}
