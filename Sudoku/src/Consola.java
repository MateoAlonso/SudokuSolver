import java.util.Scanner;

public class Consola {
    private static Scanner entrada = new Scanner(System.in);
    
    // Constructor privado para que no puedan instanciarse objetos de tipo Consola
    private Consola() {}
    
    /**
     * Devuelve un entero obtenido vía consola.
     * @param mensaje El mensaje a mostrarle al usuario
     * @return el entero obtenido vía consola
     */
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje + ": ");
        int x = Integer.parseInt( entrada.nextLine() );
        return x;
    }
    
    public static double leerReal(String mensaje) {
        System.out.print(mensaje + ": ");
        double x = Double.parseDouble(entrada.nextLine());
        return x;
    }
    
    public static int leerEnteroEntre(String mensaje, int min, int max) {
        int x = leerEntero(mensaje);
        while (x < min || x > max) {
            String msjError = "ERROR. Valor esperado entre " + min + " y " + max + "\n";
            x = leerEntero(msjError + mensaje);
        }
        return x;
    }
    
    public static double leerRealEntre(String mensaje, double min, double max) {
        double x = leerReal(mensaje);
        while (x < min || x > max) {
            String msjError = "ERROR. Valor esperado entre " + min + " y " + max + "\n";
            x = leerEntero(msjError + mensaje);
        }
        return x;
    }
    
    public static char leerCaracter(String mensaje){
        System.out.print(mensaje+ ": ");
        char x =  entrada.nextLine().charAt(0);
        return x;
    }
    
    public static String leerCadena(String mensaje){
        System.out.print(mensaje+": ");
        String x = entrada.nextLine();
        return x;
    }
}
