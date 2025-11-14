public class Main {
    static double operandOne ;
    static double operandTwo ;
    static String operator ;
    static double result ;
    public static void main(String[] args) {
        setOperandOne(10.5);
        setOperandTwo(5.2);
        setOperation("+");
        performOperation();
        getResult();
    }

    public static void setOperandOne(double operand) {
        operandOne = operand;
    }

    public static void setOperation(String operation) {
        operator = operation;
    }

    public static void setOperandTwo(double operand) {
        operandTwo = operand;
    }

    public static void performOperation() {
        if(operator.equals("+")) {
            result = operandOne + operandTwo;
        }
        else if(operator.equals("-")) {
            result = operandOne - operandTwo;
        }
    }

    public static void getResult() {
        System.out.println(result);
    }
}
