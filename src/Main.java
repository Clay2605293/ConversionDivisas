// Main.java

import Utilidades.impresionMensajes;
import Utilidades.impresionMenu;
import Utilidades.conversionDivisa;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        conversionDivisa consultaDivisa = new conversionDivisa();
        impresionMenu Menu = new impresionMenu();
        impresionMensajes mensajesMostrados = new impresionMensajes();
        int opcion = 0;
        mensajesMostrados.bienvenida();
        while (opcion != 2) {
            Menu.menuOpciones();
            try {
                opcion = Menu.opcionUsuario();
                switch (opcion) {
                    case 1:
                        Menu.menuDivisas();
                        mensajesMostrados.divisaAConvertir();

                        String divisaOrigen = Menu.obtenerCodigoMoneda();
                        mensajesMostrados.divisaObjetivo();
                        String divisaDestino = Menu.obtenerCodigoMoneda();
                        double monto = Menu.cantidadConvertir();

                        double tasaDeConversion = consultaDivisa.buscaDivisa(divisaOrigen, divisaDestino);
                        String resultado = mensajesMostrados.resultadoMensaje(divisaOrigen, divisaDestino, tasaDeConversion, monto);
                        System.out.println(resultado);
                        break;
                    case 2:
                        mensajesMostrados.salir();
                        break;
                    default:
                        mensajesMostrados.opcionInvalida();
                        break;
                }
            }catch (InputMismatchException e){
                mensajesMostrados.opcionInvalida();
                Menu.limpiaLectura();
            }
        }
        Menu.cierraLectura();
    }
}