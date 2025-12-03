import java.util.Stack;

public class Main {
    static double result;
    static Stack<String> stack = new Stack<>();
    static StringBuilder postFix = new StringBuilder();
    static boolean flag = true;

    public static void main(String[] args) {
        performOperation(10.5);
        performOperation("+");
        performOperation(5.2);
        performOperation("*");
        performOperation(10);
        performOperation("=");
        getResult();
    }

    public static void performOperation(double operand) {
        postFix.append(operand).append(" ");
    }


    private static double evaluate(double op1, double op2, String opp) {
        return switch (opp) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "^" -> Math.pow(op1, op2);
            case "/" -> op1 / op2;
            default -> 0;
        };
    }

    public static int Operator(String x) {
        return switch (x) {
            case "^" -> 2;
            case "*", "/" -> 1;
            case "+", "-" -> 0;
            default -> -1;
        };
    }

    public static void performOperation(String operation) {
        if (operation.equals("^")) {
            stack.push(operation);
        } else if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
            while (!(stack.isEmpty()) && Operator(operation) <= Operator(stack.peek())) {

                postFix.append(stack.peek()).append(" ");
                stack.pop();
            }
            stack.push(operation);

        }

        if (operation.equals("=")) {
            evaluatePost();
        }
    }

    public static void evaluatePost() {
        while (!stack.isEmpty()) {
            postFix.append(stack.pop()).append(" ");
        }
        double op1, op2 = 0;
        Stack<Double> opStack = new Stack<>();
        String[] next = postFix.toString().trim().split(" ");
        for (String s : next) {
            if (s.matches("\\d+(\\.\\d+)?")) {
                opStack.push(Double.parseDouble(s));
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (!opStack.isEmpty()) {
                    op2 = opStack.pop();
                    if (!opStack.isEmpty()) {
                        op1 = opStack.pop();
                        result = evaluate(op1, op2, s);
                        opStack.push(result);
                    } else {
                        System.out.println("Invalid operation");
                        flag = false;
                        break;
                    }
                } else {
                    System.out.println("Invalid operation");
                    flag = false;
                    break;
                }
            }
        }
        opStack.pop();
        if (!opStack.isEmpty()) {
            System.out.println("Invalid operation");
            flag = false;
        }
    }

    public static void getResult() {
        if (flag)
            System.out.println(result);
    }
}
