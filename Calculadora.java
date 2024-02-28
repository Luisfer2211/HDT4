public class Calculadora {
    public static int calcularExpresionPostfix(String expresion) {
        Controlador controlador = new Controlador();
        StackWithVector vectores = new StackWithVector();

        try {
            for (int i = 0; i < expresion.length(); i++) {
                char c = expresion.charAt(i);
                if (Character.isDigit(c)) {
                    // Si es un dígito, convertirlo a un string y ponerlo en la pila
                    vectores.push(String.valueOf(c - '0'));
                } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    // Si es un operador, extraer los dos operandos superiores de la pila y aplicar el operador
                    if (vectores.count() >= 2) {
                        int n1 = Integer.parseInt(vectores.pop());
                        int n2 = Integer.parseInt(vectores.pop());

                        switch (c) {
                            case '+':
                                vectores.push(String.valueOf(controlador.add(n2, n1)));
                                break;
                            case '-':
                                vectores.push(String.valueOf(controlador.substraction(n2, n1)));
                                break;
                            case '*':
                                vectores.push(String.valueOf(controlador.multiplication(n2, n1)));
                                break;
                            case '/':
                                if (n1 != 0) {
                                    vectores.push(String.valueOf(controlador.division(n2, n1)));
                                } else {
                                    throw new ArithmeticException("División por cero");
                                }
                                break;
                            default:
                                throw new RuntimeException("Operador no reconocido: " + c);
                        }
                    } else {
                        // Manejar el caso de no tener suficientes operandos en la pila
                        throw new RuntimeException("No hay suficientes operandos para realizar la operación.");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Devuelve el resultado final que queda en la última posición de la pila
        return Integer.parseInt(vectores.peek());
    }
}
