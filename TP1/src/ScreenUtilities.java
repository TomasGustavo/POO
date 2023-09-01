import java.util.Scanner;

public class ScreenUtilities {
    public static void pausa() {

        Scanner sc = new Scanner(System.in);

        System.out.println("PRESIONE ENTER PARA CONTINUAR");
        //String x = sc.nextLine();
        sc.nextLine();


    }

    public  static void LimpiarPantalla(){
        for(int i=0;i<50;i++){
            System.out.println();
        }
        System.out.flush();
    }
}


