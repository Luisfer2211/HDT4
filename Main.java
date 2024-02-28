import java.io.File;
import java.util.Scanner;

public class Main {
    static StackFactory steam = new StackFactory();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(".::BIENVENIDO::..\n 1. Usar Vector\n 2. Usar Arreglo\n 3. Usar Lista");
        int opc = sc.nextInt();
        steam.opc(opc);
    }
}