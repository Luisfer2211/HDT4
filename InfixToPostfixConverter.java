import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Scanner;
public class InfixToPostfixConverter {

    private IStack<String> stack;
    private Queue<String> postfixExpression;

    public InfixToPostfixConverter(String stackType) {
        switch (stackType.toLowerCase()) {
            case "vector":
                stack = new StackWithVector<>();
                break;
            case "arraylist":
                stack = new StackWithArrayList<>();
                break;
            case "linkedlist":
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese 1 si desea simplemente encadenada, ingrese 2 si desea doblemente encadenada");
                int opc = sc.nextInt();
                if (opc == 1){
                    stack = new LinkedStack<>();
                } else if (opc == 2) {
                    stack = new DoblementeEncadenado<>();
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo de stack no válido: " + stackType);
        }
        postfixExpression = new LinkedList<>();
    }

    public String convertToPostfix(String infixExpression) {
        stack.push("#");
        for (int i = 0; i < infixExpression.length(); i++) {
            String ch = String.valueOf(infixExpression.charAt(i));
            if (ch.matches("[a-zA-Z0-9]")) {
                postfixExpression.add(ch);
            } else if (ch.equals("(")) {
                stack.push(ch);
            } else if (ch.equals("^")) {
                stack.push(ch);
            } else if (ch.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfixExpression.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfixExpression.add(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty() && !stack.peek().equals("#")) {
            postfixExpression.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        for (String s : postfixExpression) {
            result.append(s);
        }
        return result.toString();
    }

    private int precedence(String operator) {
        switch (operator) {
            case "^":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return -1;
        }
    }
}