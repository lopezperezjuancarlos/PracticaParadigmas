// Repositorio: https://github.com/lopezperezjuancarlos/PracticaParadigmas

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Estructura simple para guardar los datos de un alumno
    record Alumno(String nombre, int edad, String grupo, double promedio) {}

    // Lista de números dada en la práctica
    static List<Integer> numeros = List.of(10, 5, 8, 3, 15, 20, 7, 12, 4, 9);

    public static void main(String[] args) {
        System.out.println("===== PROGRAMACIÓN ESTRUCTURADA =====");
        ej1();
        ej2();
        ej3();
        ej4();
        ej5();

        System.out.println("\n===== LAMBDAS Y STREAMS =====");
        ej6();
        ej7();
        ej8();
        ej9();
        ej10();
        ej11();
        ej12();
        ej13();
        ej14();
        ej15();

        System.out.println("\n===== ACTIVIDAD DE INTEGRACIÓN =====");
        integracion();
    }

    // ---------- PROGRAMACIÓN ESTRUCTURADA (ciclos paso a paso) ----------

    // Ejercicio 1: mostrar todos los números
    static void ej1() {
        System.out.println("\nEjercicio 1: todos los números");
        for (int n : numeros) {
            System.out.println(n);
        }
    }

    // Ejercicio 2: mostrar los mayores que 10
    static void ej2() {
        System.out.println("\nEjercicio 2: mayores que 10");
        for (int n : numeros) {
            if (n > 10) {
                System.out.println(n);
            }
        }
    }

    // Ejercicio 3: mostrar los pares (el residuo entre 2 es 0)
    static void ej3() {
        System.out.println("\nEjercicio 3: pares");
        for (int n : numeros) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }
    }

    // Ejercicio 4: mostrar los impares
    static void ej4() {
        System.out.println("\nEjercicio 4: impares");
        for (int n : numeros) {
            if (n % 2 != 0) {
                System.out.println(n);
            }
        }
    }

    // Ejercicio 5: multiplicar cada número por 2 y mostrarlo
    static void ej5() {
        System.out.println("\nEjercicio 5: cada número por 2");
        for (int n : numeros) {
            System.out.println(n * 2);
        }
    }

    // ---------- LAMBDAS Y STREAMS (declarativo) ----------

    // Ejercicio 6: nueva colección con números >= 8
    static void ej6() {
        List<Integer> resultado = numeros.stream()
                .filter(n -> n >= 8)
                .collect(Collectors.toList());
        System.out.println("\nEjercicio 6: mayores o iguales a 8 -> " + resultado);
    }

    // Ejercicio 7: nueva colección con los pares
    static void ej7() {
        List<Integer> resultado = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Ejercicio 7: pares -> " + resultado);
    }

    // Ejercicio 8: ordenar de menor a mayor
    static void ej8() {
        List<Integer> resultado = numeros.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ejercicio 8: menor a mayor -> " + resultado);
    }

    // Ejercicio 9: ordenar de mayor a menor
    static void ej9() {
        List<Integer> resultado = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Ejercicio 9: mayor a menor -> " + resultado);
    }

    // Ejercicio 10: valor máximo
    static void ej10() {
        int maximo = numeros.stream()
                .max(Integer::compare)
                .get();
        System.out.println("Ejercicio 10: máximo -> " + maximo);
    }

    // Ejercicio 11: valor mínimo
    static void ej11() {
        int minimo = numeros.stream()
                .min(Integer::compare)
                .get();
        System.out.println("Ejercicio 11: mínimo -> " + minimo);
    }

    // Ejercicio 12: suma de todos los números
    static void ej12() {
        int suma = numeros.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println("Ejercicio 12: suma -> " + suma);
    }

    // Ejercicio 13: promedio de los números
    static void ej13() {
        double promedio = numeros.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(0);
        System.out.println("Ejercicio 13: promedio -> " + promedio);
    }

    // Ejercicio 14: contar cuántos son mayores que 10
    static void ej14() {
        long cantidad = numeros.stream()
                .filter(n -> n > 10)
                .count();
        System.out.println("Ejercicio 14: cantidad mayores que 10 -> " + cantidad);
    }

    // Ejercicio 15: impares ordenados de menor a mayor
    static void ej15() {
        List<Integer> resultado = numeros.stream()
                .filter(n -> n % 2 != 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ejercicio 15: impares ordenados -> " + resultado);
    }

    // ---------- ACTIVIDAD DE INTEGRACIÓN ----------

    // Alumnos con promedio >= 8 usando Stream
    static void integracion() {
        List<Alumno> alumnos = List.of(
                new Alumno("Ana", 15, "1A", 8.5),
                new Alumno("Luis", 16, "1A", 7.8),
                new Alumno("Marta", 15, "1B", 9.2),
                new Alumno("Pedro", 17, "2A", 8.9),
                new Alumno("Sofía", 16, "2A", 9.5),
                new Alumno("Juan", 17, "2B", 7.5));

        System.out.println("Alumnos con promedio >= 8:");
        alumnos.stream()
                .filter(a -> a.promedio() >= 8)
                .forEach(a -> System.out.println(a.nombre() + " - " + a.promedio()));
    }
}