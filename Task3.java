import java.util.Scanner;

public class Task3 {
    static int apply(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: return 0;
        }
    }

    static int precedence(char op) {
        return (op == '+' || op == '-') ? 1 : (op == '*' || op == '/') ? 2 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Выражение: ");
        String expr = sc.nextLine();

        Stack values = new Stack();
        Stack operators = new Stack();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                i--;
                values.push(num);
            }
            else if (c == '(') operators.push(c);
            else if (c == ')') {
                while (operators.peek() != '(') {
                    int b = values.pop();
                    int a = values.pop();
                    values.push(apply(a, b, (char)operators.pop()));
                }
                operators.pop();
            }
            else {
                while (!operators.isEmpty() && precedence((char)operators.peek()) >= precedence(c)) {
                    int b = values.pop();
                    int a = values.pop();
                    values.push(apply(a, b, (char)operators.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            int b = values.pop();
            int a = values.pop();
            values.push(apply(a, b, (char)operators.pop()));
        }

        System.out.println("Результат: " + values.pop());
        sc.close();
    }
}
