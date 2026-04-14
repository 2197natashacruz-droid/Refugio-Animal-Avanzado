package model;

public abstract class Mascota {

    protected String nombre;
    protected int edad;

    public Mascota(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método abstracto: cada subclase define su sonido
    public abstract void hacerSonido();

    public void mostrarInfo() {
        System.out.println("  🐾 " + nombre + " | Edad: " + edad + " año/s | Tipo: " + getTipo());
    }

    // Método que cada subclase puede sobreescribir para indicar su tipo
    public abstract String getTipo();

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return getTipo() + " - " + nombre + " (" + edad + " años)";
    }
}