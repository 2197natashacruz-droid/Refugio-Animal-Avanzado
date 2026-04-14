package model;

import interfaces.Adoptable;
import interfaces.Entrenable;

public class Perro extends Mascota implements Adoptable, Entrenable {

    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("  🐶 " + nombre + " dice: ¡Guau guau!");
    }

    @Override
    public String datosAdopcion() {
        return "Perro '" + nombre + "' de " + edad + " año/s — listo para adopción 🏠";
    }

    @Override
    public void entrenar() {
        System.out.println("  🎾 " + nombre + " ha completado su sesión de entrenamiento.");
    }

    @Override
    public String getTipo() {
        return "Perro";
    }
}