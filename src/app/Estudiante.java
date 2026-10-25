package app;


public class Estudiante {
    String codigo;
    String nombre;
    String carrera;

    public Estudiante(String codigo, String nombre, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public void mostrarDatos() {
        System.out.println("Código: " + codigo);
        System.out.println("Estudiante: " + nombre);
        System.out.println("Carrera: " + carrera);
    }
}