package service;

import interfaces.Adoptable;
import interfaces.Entrenable;
import model.Cliente;
import model.Gato;
import model.Mascota;
import model.Perro;
import util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class RefugioService {

    private List<Cliente> clientes = new ArrayList<>();

    // ─────────────────────────────────────────────
    //  MENÚ PRINCIPAL
    // ─────────────────────────────────────────────
    public void iniciar() {
        boolean salir = false;

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   🐾 REFUGIO ANIMAL 🐾       ║");
        System.out.println("╚══════════════════════════════╝");

        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1) Crear cliente");
            System.out.println("2) Registrar mascota a un cliente");
            System.out.println("3) Ver clientes y sus mascotas");
            System.out.println("4) Hacer sonar a las mascotas de un cliente");
            System.out.println("5) Ver mascotas adoptables");
            System.out.println("6) Entrenar mascotas de un cliente");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            int op = InputUtil.leerInt();

            switch (op) {
                case 1 -> crearCliente();
                case 2 -> registrarMascota();
                case 3 -> mostrarDatos();
                case 4 -> hacerSonidos();
                case 5 -> mostrarAdoptables();
                case 6 -> entrenarMascotas();
                case 0 -> salir = true;
                default -> System.out.println("⚠ Opción inválida. Intente de nuevo.");
            }
        }

        System.out.println("\n👋 ¡Hasta pronto! Gracias por usar el Refugio Animal.");
    }

    // ─────────────────────────────────────────────
    //  1) CREAR CLIENTE
    // ─────────────────────────────────────────────
    private void crearCliente() {
        System.out.println("\n--- Crear Cliente ---");
        String nombre = InputUtil.leerTexto("Nombre del cliente: ");

        // Verificar que no exista un cliente con el mismo nombre
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("⚠ Ya existe un cliente con ese nombre.");
                return;
            }
        }

        Cliente nuevo = new Cliente(nombre);
        clientes.add(nuevo);
        System.out.println("✔ Cliente '" + nombre + "' creado con ID " + nuevo.getId() + ".");
    }

    // ─────────────────────────────────────────────
    //  2) REGISTRAR MASCOTA
    // ─────────────────────────────────────────────
    private void registrarMascota() {
        System.out.println("\n--- Registrar Mascota ---");

        if (clientes.isEmpty()) {
            System.out.println("⚠ No hay clientes registrados. Cree uno primero.");
            return;
        }

        Cliente cliente = seleccionarCliente();
        if (cliente == null) return;

        String nombreMascota = InputUtil.leerTexto("Nombre de la mascota: ");
        int edad = InputUtil.leerIntPositivo("Edad de la mascota (años): ");

        System.out.println("Tipo de mascota:");
        System.out.println("  1) Perro 🐶");
        System.out.println("  2) Gato 🐱");
        System.out.print("Opción: ");
        int tipo = InputUtil.leerInt();

        Mascota mascota;

        try {
            switch (tipo) {
                case 1 -> mascota = new Perro(nombreMascota, edad);
                case 2 -> mascota = new Gato(nombreMascota, edad);
                default -> {
                    System.out.println("⚠ Tipo inválido. Solo se aceptan Perro (1) o Gato (2).");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("⚠ Error al crear la mascota: " + e.getMessage());
            return;
        }

        cliente.agregarMascota(mascota);
    }

    // ─────────────────────────────────────────────
    //  3) MOSTRAR CLIENTES Y MASCOTAS
    // ─────────────────────────────────────────────
    private void mostrarDatos() {
        System.out.println("\n--- Clientes Registrados ---");

        if (clientes.isEmpty()) {
            System.out.println("  (No hay clientes registrados)");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println("\n👤 " + c);
            if (c.tieneMascotas()) {
                for (Mascota m : c.getMascotas()) {
                    m.mostrarInfo();
                }
            } else {
                System.out.println("  (Sin mascotas registradas)");
            }
        }
    }

    // ─────────────────────────────────────────────
    //  4) HACER SONAR MASCOTAS
    // ─────────────────────────────────────────────
    private void hacerSonidos() {
        System.out.println("\n--- Sonidos de Mascotas ---");

        Cliente cliente = seleccionarCliente();
        if (cliente == null) return;

        if (!cliente.tieneMascotas()) {
            System.out.println("⚠ Este cliente no tiene mascotas.");
            return;
        }

        // Polimorfismo dinámico: Java decide qué hacerSonido() ejecutar
        for (Mascota m : cliente.getMascotas()) {
            m.hacerSonido();
        }
    }

    // ─────────────────────────────────────────────
    //  5) MOSTRAR ADOPTABLES
    // ─────────────────────────────────────────────
    private void mostrarAdoptables() {
        System.out.println("\n--- Mascotas Disponibles para Adopción ---");

        boolean hayAdoptables = false;

        for (Cliente c : clientes) {
            for (Mascota m : c.getMascotas()) {
                // Polimorfismo + instanceof para verificar la interfaz
                if (m instanceof Adoptable adoptable) {
                    System.out.println("  ✅ " + adoptable.datosAdopcion());
                    hayAdoptables = true;
                }
            }
        }

        if (!hayAdoptables) {
            System.out.println("  (No hay mascotas adoptables registradas)");
        }
    }

    // ─────────────────────────────────────────────
    //  6) ENTRENAR MASCOTAS
    // ─────────────────────────────────────────────
    private void entrenarMascotas() {
        System.out.println("\n--- Entrenar Mascotas ---");

        Cliente cliente = seleccionarCliente();
        if (cliente == null) return;

        if (!cliente.tieneMascotas()) {
            System.out.println("⚠ Este cliente no tiene mascotas.");
            return;
        }

        boolean hayEntrenables = false;

        for (Mascota m : cliente.getMascotas()) {
            if (m instanceof Entrenable entrenable) {
                entrenable.entrenar();
                hayEntrenables = true;
            }
        }

        if (!hayEntrenables) {
            System.out.println("  (Ninguna mascota de este cliente es entrenable)");
        }
    }

    // ─────────────────────────────────────────────
    //  HELPER: SELECCIONAR CLIENTE POR ID
    // ─────────────────────────────────────────────
    private Cliente seleccionarCliente() {
        if (clientes.isEmpty()) {
            System.out.println("⚠ No hay clientes registrados.");
            return null;
        }

        System.out.println("Clientes disponibles:");
        for (Cliente c : clientes) {
            System.out.println("  " + c);
        }

        int id = InputUtil.leerInt("Ingrese el ID del cliente: ");

        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }

        System.out.println("⚠ No se encontró un cliente con ID " + id + ".");
        return null;
    }
}