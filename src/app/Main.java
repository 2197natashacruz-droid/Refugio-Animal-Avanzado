package app;

import service.RefugioService;

public class Main {

    public static void main(String[] args) {
        RefugioService refugio = new RefugioService();
        refugio.iniciar();
    }
}
