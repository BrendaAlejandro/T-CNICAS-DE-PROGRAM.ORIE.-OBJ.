package app;

import java.util.ArrayList;

public class Matricula {

    Estudiante estudiante;
    ArrayList<Curso> cursos;

    public Matricula(Estudiante estudiante) {

        this.estudiante = estudiante;
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {

        for (Curso c : cursos) {

            if (c.codigo.equals(curso.codigo)) {

                System.out.println("Curso ya matriculado.");
                return;
            }
        }

        int totalCreditos = 0;

        for (Curso c : cursos) {
            totalCreditos += c.creditos;
        }

        if (totalCreditos + curso.creditos > 22) {

            System.out.println("No puede superar los 22 créditos.");
            return;
        }

        cursos.add(curso);

        System.out.println("Curso agregado correctamente.");
    }

    public void eliminarCurso(String codigo) {

        for (Curso c : cursos) {

            if (c.codigo.equalsIgnoreCase(codigo)) {

                cursos.remove(c);

                System.out.println("Curso eliminado.");
                return;
            }
        }

        System.out.println("Curso no encontrado.");
    }

    public void buscarCurso(String codigo) {

        for (Curso c : cursos) {

            if (c.codigo.equalsIgnoreCase(codigo)) {

                System.out.println("Curso encontrado:");
                c.mostrarCurso();

                return;
            }
        }

        System.out.println("Curso no matriculado.");
    }

    public void mostrarMatricula() {

        estudiante.mostrarDatos();

        // Validar matrícula vacía
        if (cursos.isEmpty()) {

            System.out.println("No existen cursos matriculados.");
            return;
        }

        System.out.println("\n******** CURSOS MATRICULADOS ********");

        int totalCreditos = 0;

        for (int i = 0; i < cursos.size(); i++) {

            Curso curso = cursos.get(i);

            curso.mostrarCurso();

            totalCreditos = totalCreditos + curso.creditos;
        }

        System.out.println("Cantidad total de cursos: "
                + cursos.size());

        System.out.println("Total de créditos matriculados: "
                + totalCreditos);
    }
}