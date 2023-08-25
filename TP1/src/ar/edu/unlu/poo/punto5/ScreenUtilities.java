package ar.edu.unlu.poo.punto5;

public class ScreenUtilities {
    public static void LimpiarPantalla() {

        try {

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception ignored) {


        }


    }
}


