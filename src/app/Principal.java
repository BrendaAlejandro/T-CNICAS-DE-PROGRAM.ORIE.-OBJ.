package app;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Estudiante estudiante =
                new Estudiante(
                        "U001",
                        "Ana García",
                        "Ingeniería de Sistemas");

        Matricula matricula = new Matricula(estudiante);

        ArrayList<Curso> catalogo = new ArrayList<>();

        // Cursos originales
        catalogo.add(new Curso("BD01", "Base de Datos I", 4));
        catalogo.add(new Curso("POO01", "Programación Orientada a Objetos", 4));
        catalogo.add(new Curso("MAT01", "Matemática Discreta", 3));
        catalogo.add(new Curso("SO01", "Sistemas Operativos", 3));

        // Reto 1: cinco cursos adicionales
        catalogo.add(new Curso("ING01", "Inglés Técnico", 2));
        catalogo.add(new Curso("WEB01", "Desarrollo Web", 4));
        catalogo.add(new Curso("RED01", "Redes de Computadoras", 3));
        catalogo.add(new Curso("BD02", "Base de Datos II", 4));
        catalogo.add(new Curso("MOV01", "Programación Móvil", 3));

        int opcion = 0;

        do {

            System.out.println("\n===== SISTEMA DE MATRÍCULA =====");
            System.out.println("1. Ver cursos disponibles");
            System.out.println("2. Agregar curso");
            System.out.println("3. Eliminar curso");
            System.out.println("4. Ver matrícula");
            System.out.println("5. Buscar curso matriculado");
            System.out.println("6. Cantidad de cursos matriculados");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");

            try {

                opcion = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Ingrese una opción numérica.");
                continue;
            }

            switch (opcion) {

                case 1:

                    System.out.println("\nCURSOS DISPONIBLES");

                    for (Curso c : catalogo) {
                        c.mostrarCurso();
                    }

                    break;

                case 2:

                    System.out.print("Código del curso: ");
                    String codigoAgregar = sc.nextLine();

                    boolean encontrado = false;

                    for (Curso c : catalogo) {

                        if (c.codigo.equalsIgnoreCase(codigoAgregar)) {

                            matricula.agregarCurso(c);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Curso no existe.");
                    }

                    break;

                case 3:

                    System.out.print("Código del curso a eliminar: ");
                    matricula.eliminarCurso(sc.nextLine());

                    break;

                case 4:

                    matricula.mostrarMatricula();

                    break;

                case 5:

                    System.out.print("Ingrese código a buscar: ");
                    String codigoBuscar = sc.nextLine();

                    matricula.buscarCurso(codigoBuscar);

                    break;

                case 6:

                    System.out.println("Cantidad de cursos matriculados: "
                            + matricula.cursos.size());

                    break;

                case 7:

                    System.out.println("Finalizando sistema...");

                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}