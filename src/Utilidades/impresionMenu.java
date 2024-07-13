// impresionMenu.java
package Utilidades;
import java.util.Scanner;
public class impresionMenu {
    public void menuOpciones(){
        String menuPrincipal = """
               ------------------------------
                     Elige una opción
               ------------------------------
               
               1. Convertir divisas.
               2. Salir.

               Opción elegida:\s""";
        System.out.print(menuPrincipal);
    }

    Scanner inputUsuario = new Scanner(System.in);
    impresionMensajes mensajes = new impresionMensajes();

    record divisaSoportada(int id, String nombreMoneda, String codigoMoneda, String nombrePais) { }
    divisaSoportada[] listaDivisas = {
            new divisaSoportada(1, "Peso mexicano", "MXN", "Mexico"),
            new divisaSoportada(2, "Dolar estadounidense", "USD", "Estados unidos"),
            new divisaSoportada(3, "Euro", "EUR", "Unión Europea"),
            new divisaSoportada(4, "Libra Esterlina", "GBP", "Gran Bretaña"),
            new divisaSoportada(5, "Renminbi Chino", "CNY", "China"),
            new divisaSoportada(6, "Yen Japonés", "JPY", "Japón"),
    };

    public void menuDivisas(){
        String cabeceraDivisas = """
               ------------------------------
                     Divisas disponibles
               ------------------------------
                """;
        System.out.println(cabeceraDivisas);
        System.out.printf("%-4s%-25s%-10s%-22s%n", "", "Moneda", "Código","País");
        for (divisaSoportada opcion : listaDivisas) {
            System.out.printf("%-4d%-25s%-10s%-22s%n",
                    opcion.id(),
                    opcion.nombreMoneda(),
                    opcion.codigoMoneda(),
                    opcion.nombrePais()
            );
        }
    }

    public String obtenerCodigoMoneda(){
        int opcionSeleccionada;
        String nombreDivisa = "";
        boolean opcionValida;
        do {
            opcionValida = false;
            opcionSeleccionada = inputUsuario.nextInt();
            for (divisaSoportada opcion : listaDivisas) {
                if (opcion.id() == opcionSeleccionada){
                    nombreDivisa = opcion.codigoMoneda();
                    opcionValida = true;
                    break;
                }
            }
            if (!opcionValida) {
                mensajes.opcionInvalida();
            }
        } while (!opcionValida);
        return nombreDivisa;
    }

    public double cantidadConvertir(){
        mensajes.ingresaLaCantidad();
        return inputUsuario.nextDouble();
    }

    public int opcionUsuario(){
        return inputUsuario.nextInt();
    }

    public void limpiaLectura(){
        inputUsuario.next();
    }

    public void cierraLectura(){
        inputUsuario.close();
    }


}
