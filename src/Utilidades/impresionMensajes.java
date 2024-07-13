// impresionMensajes.java
package Utilidades;

public class impresionMensajes {

    public void bienvenida(){
        String bienvenida = """
                 Sistema de conversión de divisas
                 Información obtenida por ExchangeRate-Api
                 Disfruta la herramienta :)
                 ____________________________________________
                 """;
        System.out.println(bienvenida);
    }

    public void ingresaLaCantidad(){
        System.out.print("Ingresa la cantidad a convertir: ");
    }

    public void divisaAConvertir(){
        System.out.print("Selecciona la divisa a convertir: ");
    }

    public void divisaObjetivo(){
        System.out.print("Selecciona la divisa objetivo: ");
    }

    public void opcionInvalida(){
        System.out.println("Opción inválida. Seleccione otra opción.");
    }

    public String resultadoMensaje(String divisaOrigen, String divisaDestino, double tasaDeConversion, double monto ){
        String resultadoDeLaConversion = String.format("%." + 2 + "f", (tasaDeConversion*monto));
        String resultadoFinal=monto + " "+ divisaOrigen + " es igual a " + resultadoDeLaConversion + " " + divisaDestino;
        return resultadoFinal;
    }

    public void salir(){
        System.out.println("Gracias por utilizar el sistema, hasta luego.");
        System.exit(0);
    }
}
