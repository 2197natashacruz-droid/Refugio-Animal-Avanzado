# 🐾 Refugio Animal — Sistema de Gestión

Sistema de gestión de un refugio de animales desarrollado en **Java**, orientado a consolidar los fundamentos de la **Programación Orientada a Objetos** (POO): herencia, polimorfismo, abstracción e interfaces, junto con colecciones, validaciones y manejo de errores.

---

## 📋 Descripción

El sistema permite, desde consola:

- Registrar clientes del refugio
- Asociar mascotas (perros y gatos) a cada cliente
- Visualizar datos de clientes y sus mascotas
- Aplicar sonidos según el tipo de animal (polimorfismo dinámico)
- Consultar mascotas disponibles para adopción
- Entrenar mascotas que implementen la interfaz `Entrenable`

---

## 🗂️ Estructura del Proyecto

```
RefugioAnimal/
└── src/
    ├── app/
    │   └── Main.java               # Punto de entrada
    ├── model/
    │   ├── Persona.java            # Clase abstracta base
    │   ├── Cliente.java            # Hereda de Persona
    │   ├── Mascota.java            # Clase abstracta base
    │   ├── Perro.java              # Hereda de Mascota, implementa Adoptable y Entrenable
    │   └── Gato.java               # Hereda de Mascota, implementa Adoptable
    ├── interfaces/
    │   ├── Adoptable.java          # Contrato: datosAdopcion()
    │   └── Entrenable.java         # Contrato: entrenar()
    ├── service/
    │   └── RefugioService.java     # Lógica principal y menús
    └── util/
        └── InputUtil.java          # Utilidades para lectura y validación de entrada
```

---

## 🧠 Conceptos de POO Aplicados

| Concepto | Dónde se aplica |
|---|---|
| Abstracción | `Persona` y `Mascota` son clases abstractas |
| Herencia | `Cliente → Persona`, `Perro/Gato → Mascota` |
| Polimorfismo dinámico | `m.hacerSonido()` sobre una lista de `Mascota` |
| Interfaces | `Adoptable`, `Entrenable` como contratos |
| Encapsulación | Atributos `private/protected` con getters |
| Colecciones | `List<Cliente>`, `List<Mascota>` |
| Manejo de errores | `try/catch` en `InputUtil` y `RefugioService` |

---

## ▶️ Cómo Ejecutar

### Requisitos

- Java 16 o superior (se utiliza *pattern matching* con `instanceof`)
- IDE recomendado: IntelliJ IDEA o Eclipse (o compilación manual con `javac`)

### Compilación manual

```bash
# Desde la raíz del proyecto
find src -name "*.java" | xargs javac -d out

# Ejecutar
java -cp out app.Main
```

### Desde un IDE

1. Importar el proyecto
2. Marcar `src/` como directorio de fuentes
3. Ejecutar `app/Main.java`

---

## 🖥️ Ejemplo de Uso

```
╔══════════════════════════════╗
║   🐾 REFUGIO ANIMAL 🐾       ║
╚══════════════════════════════╝

=== MENÚ PRINCIPAL ===
1) Crear cliente
2) Registrar mascota a un cliente
3) Ver clientes y sus mascotas
4) Hacer sonar a las mascotas de un cliente
5) Ver mascotas adoptables
6) Entrenar mascotas de un cliente
0) Salir
Opción: 1

--- Crear Cliente ---
Nombre del cliente: Ana
✔ Cliente 'Ana' creado con ID 1.
```

---

## 🔌 Interfaces Disponibles

```java
public interface Adoptable {
    String datosAdopcion();
}

public interface Entrenable {
    void entrenar();
}
```

`Perro` implementa ambas. `Gato` solo implementa `Adoptable`.

---

## 🚀 Posibles Extensiones

- [ ] Agregar nuevos tipos de mascota (`Conejo`, `Ave`)
- [ ] Usar `Map<Cliente, List<Mascota>>` para búsqueda más eficiente
- [ ] Persistencia de datos en archivos `.txt` o `.json`
- [ ] Contador y reporte de adopciones
- [ ] Interfaz gráfica con Java Swing o JavaFX
- [ ] Migración a Spring Boot con API REST

---

## 📚 Tecnologías

- **Java 16+**
- **Programación Orientada a Objetos**
- **Consola / Scanner** para entrada de datos

---

## 👤 Autor

Desarrollado como proyecto educativo para consolidar los fundamentos de POO en Java.

---

## 📄 Licencia

Este proyecto es de uso educativo y libre distribución.
