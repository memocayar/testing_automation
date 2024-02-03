package ej2;

import ej2.src.Espadachin;
import ej2.src.Mago;
import ej2.src.Personaje;
import ej2.src.Torre;

public class Main {
    public static void main(String[] args) {
        Espadachin espadachin = new Espadachin(100, 20);
        Torre torre = new Torre(150, 3);
        Mago mago = new Mago(80, "Hechizo de fuego");

        // Imprimir información antes de entrenar
        imprimirInfo("Espadachín", espadachin);
        imprimirInfo("Torre", torre);
        imprimirInfo("Mago", mago);

        // Entrenar a los personajes
        espadachin.entrenar();
        torre.entrenar();
        mago.entrenar();

        // Imprimir información después de entrenar
        imprimirInfo("Espadachín", espadachin);
        imprimirInfo("Torre", torre);
        imprimirInfo("Mago", mago);
    }

    // Método para imprimir información de un personaje
    private static void imprimirInfo(String tipo, Personaje personaje) {
        System.out.println("--- Información de " + tipo + " ---");
        System.out.println("Salud: " + personaje.getSalud());

        if (personaje instanceof Espadachin) {
            Espadachin espadachin = (Espadachin) personaje;
            System.out.println("Ataque: " + espadachin.getAtaque());
        } else if (personaje instanceof Torre) {
            Torre torre = (Torre) personaje;
            System.out.println("Nivel: " + torre.getNivel());
        } else if (personaje instanceof Mago) {
            Mago mago = (Mago) personaje;
            System.out.println("Magia: " + mago.getMagia());
        }

        System.out.println("-----------------------------");
    }
}