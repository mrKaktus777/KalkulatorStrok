public class Calculate {
    public static String evaluateExpression(String input) {

        String[] elements = input.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        String operand1 = elements[0];
        String operator = elements[1];
        String operand2 = elements[2];

        if (!isValidOperand(operand1) || !isValidOperand(operand2)) {
            throw new IllegalArgumentException("Недопустимые переменные");
        }

        if (!isValidOperator(operator)) {
            throw new IllegalArgumentException("Недопустимая операция");
        }

        if (operator.equals("+")) {
            return "\"" + operand1.substring(1, operand1.length() - 1) + operand2.substring(1, operand2.length() - 1) + "\"";
        } else if (operator.equals("-")) {
            return "\"" + operand1.substring(1, operand1.length() - 1).replace(operand2.substring(1, operand2.length() - 1), "") + "\"";
        } else if (operator.equals("*")) {
            int multiplier = Integer.parseInt(operand2);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < multiplier; i++) {
                result.append(operand1.substring(1, operand1.length() - 1));
            }
            return "\"" + result.toString() + "\"";
        } else if (operator.equals("/")) {
            int divisor = Integer.parseInt(operand2);
            int newLength = operand1.substring(1, operand1.length() - 1).length() / divisor;
            return "\"" + operand1.substring(1, operand1.length() - 1).substring(0, newLength) + "\"";
        } else {
            throw new IllegalArgumentException("Недопустимая операция");
        }
    }

    public static boolean isValidOperand(String operand) {
        return (operand.matches("\"[^\"]{1,10}\"") || operand.matches("[1-9]|10"));
    }

    public static boolean isValidOperator(String operator) {
        return (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"));
    }
}