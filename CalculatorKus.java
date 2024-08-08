import java.util.Scanner;
public class CalculatorKus {
    public static void main(String[] args) throws Exception {

        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (a + b, a - b, a * b, a / b): ");
        String exp = scanner.nextLine();
        exp = exp.trim().replaceAll("\\s+", "");
        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if (actionIndex==-1) {
            throw new Exception ("т.к. строка не является математической операцией");

        }
        String[] data = exp.split(regexActions[actionIndex]);
        if (data.length != 2) {
            throw new Exception ("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор");

        }
        int a,b;
        a = Integer.parseInt(data[0]);
        b = Integer.parseInt(data[1]);
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception ("Числа дожны быть в диапазоне от 1 до 10 включительно");
        }
        int result;
        switch (actions[actionIndex]){
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            default:
                result = a/b;
                break;
        }
        System.out.println(result);

    }
}
