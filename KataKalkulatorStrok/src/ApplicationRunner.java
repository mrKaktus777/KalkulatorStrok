import java.util.Scanner;

class ApplicationRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        scanner.close();

        try {
            String result = Calculate.evaluateExpression(input);
            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}