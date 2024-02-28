public class StackFactory {
    static convertidor a2 = new convertidor();
    Calculadora postifx = new Calculadora();
    public void opc(int opc1){
        String ruta = "C:\\Users\\luisy\\OneDrive\\Escritorio\\a.txt";
        switch (opc1){
            case 1:
                InfixToPostfixConverter inf = new InfixToPostfixConverter("vector");
                ruta = a2.readAndRemoveSpaces(ruta);
                ruta = inf.convertToPostfix(ruta);
                System.out.println("La expresion Infix a postFix es: " + ruta);
                int a = postifx.calcularExpresionPostfix(ruta);
                System.out.println("Y la respuesta es: " + a);
                break;
            case 2:
                InfixToPostfixConverter inf2 = new InfixToPostfixConverter("arraylist");
                ruta = a2.readAndRemoveSpaces(ruta);
                ruta = inf2.convertToPostfix(ruta);
                System.out.println("La expresion Infix a postFix es: " + ruta);
                int a21 = postifx.calcularExpresionPostfix(ruta);
                System.out.println("Y la respuesta es: " + a21);
                break;
            case 3:
                InfixToPostfixConverter inf3 = new InfixToPostfixConverter("Linkedlist");
                ruta = a2.readAndRemoveSpaces(ruta);
                ruta = inf3.convertToPostfix(ruta);
                System.out.println("La expresion Infix a postFix es: " + ruta);
                int a3 = postifx.calcularExpresionPostfix(ruta);
                System.out.println("Y la respuesta es: " + a3);
                break;
        }
    }
}
