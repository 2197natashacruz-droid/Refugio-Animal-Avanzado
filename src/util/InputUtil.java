package util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero desde consola. Si el input no es válido, retorna -1.
     */
    public static int leerInt() {
        try {
            String linea = sc.nextLine().trim();
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            System.out.println("⚠ Entrada inválida. Se esperaba un número.");
            return -1;
        }
    }

    /**
     * Lee un entero con un mensaje personalizado.
     */
    public static int leerInt(String mensaje) {
        System.out.print(mensaje);
        return leerInt();
    }

    /**
     * Lee un entero positivo (mayor a 0). Repite hasta obtener uno válido.
     */
    public static int leerIntPositivo(String mensaje) {
        int valor = -1;
        while (valor <= 0) {
            System.out.print(mensaje);
            valor = leerInt();
            if (valor <= 0) {
                System.out.println("⚠ El valor debe ser mayor a 0.");
            }
        }
        return valor;
    }

    /**
     * Lee una línea de texto no vacía. Repite hasta obtener input válido.
     */
    public static String leerTexto(String mensaje) {
        String texto = "";
        while (texto.isBlank()) {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isBlank()) {
                System.out.println("⚠ El campo no puede estar vacío.");
            }
        }
        return texto;
    }

    /**
     * Lee una línea de texto sin validación (puede ser vacía).
     */
    public static String leerLinea() {
        return sc.nextLine().trim();
    }
}