package ej1;

public class Calculadora {
    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplicacion(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("No se puede realizar la división por cero");
            return 0;
        }
    }
}
