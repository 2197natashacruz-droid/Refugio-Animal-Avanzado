package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private static int contadorId = 1;

    private int id;
    private List<Mascota> mascotas;

    public Cliente(String nombre) {
        super(nombre);
        this.id = contadorId++;
        this.mascotas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void agregarMascota(Mascota m) {
        // Validar que no exista una mascota con el mismo nombre
        for (Mascota existente : mascotas) {
            if (existente.getNombre().equalsIgnoreCase(m.getNombre())) {
                System.out.println("⚠ Ya existe una mascota con ese nombre para este cliente.");
                return;
            }
        }
        mascotas.add(m);
        System.out.println("✔ Mascota '" + m.getNombre() + "' registrada para " + nombre + ".");
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public boolean tieneMascotas() {
        return !mascotas.isEmpty();
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " (" + mascotas.size() + " mascota/s)";
    }
}