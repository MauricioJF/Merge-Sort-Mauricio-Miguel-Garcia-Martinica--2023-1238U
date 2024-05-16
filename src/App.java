import java.util.Scanner;

public class RegistroEstudiantes {
    private String[] nombres;
    private String[][] asignaturas;
    private double[][] notas;
    private double[] promedios;

    public RegistroEstudiantes(int cantidadEstudiantes) {
        this.nombres = new String[cantidadEstudiantes];
        this.asignaturas = new String[cantidadEstudiantes][6];
        this.notas = new double[cantidadEstudiantes][6];
        this.promedios = new double[cantidadEstudiantes];
    }

    public void registrarEstudiantes() {
        try (Scanner leer = new Scanner(System.in)) {
            for (int i = 0; i < nombres.length; i++) {
                System.out.println("Ingrese el nombre del estudiante " + (i + 1) + ":");
                nombres[i] = leer.nextLine();

                for (int j = 0; j < 6; j++) {
                    System.out.println("Ingrese el nombre de la asignatura " + (j + 1) + ":");
                    asignaturas[i][j] = leer.nextLine();

                    try {
                        System.out.println("Ingrese la nota de la asignatura " + (j + 1) + ":");
                        notas[i][j] = leer.nextDouble();
                        leer.nextLine(); 
                    } catch (Exception e) {
                        System.out.println("Error al ingresar la nota. Intente nuevamente.");
                        j--; 
                        leer.nextLine(); 
                    }
                }
            }
        }
    }

    public void calcularPromedios() {
        for (int i = 0; i < promedios.length; i++) {
            double suma = 0;
            for (int j = 0; j < 6; j++) {
                suma += notas[i][j];
            }
            promedios[i] = suma / 6;
        }
    }

    public void mostrarResultados() {
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Estudiante: " + nombres[i]);
            for (int j = 0; j < 6; j++) {
                System.out.println("Asignatura: " + asignaturas[i][j] + ", Nota: " + notas[i][j]);
            }
            System.out.println("Promedio: " + promedios[i]);
            if (promedios[i] >= 3.0) {
                System.out.println("Calificación: Satisfactorio");
            } else {
                System.out.println("Calificación: Insatisfactorio");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner leer1 = new Scanner(System.in)) {
            System.out.println("Ingrese la cantidad de estudiantes:");
            int cantidadEstudiantes = leer1.nextInt();
            leer1.nextLine(); 

            RegistroEstudiantes registro = new RegistroEstudiantes(cantidadEstudiantes);
            registro.registrarEstudiantes();
            registro.calcularPromedios();
            registro.mostrarResultados();
        }
    }
}
