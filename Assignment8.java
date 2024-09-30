import java.util.Scanner;
import java.util.Stack;

public class Assignment8 {

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    static String infixToPrefix(String exp) {
        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(exp);
        input.reverse();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                c = ')';
            } else if (c == ')') {
                c = '(';
            }
            input.setCharAt(i, c);
        }

        String postfix = infixToPostfix(input.toString());
        result.append(new StringBuilder(postfix).reverse());

        return result.toString();
    }

    static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    static int evaluatePrefix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Convert Infix to Postfix");
            System.out.println("2. Convert Infix to Prefix");
            System.out.println("3. Evaluate Postfix Expression");
            System.out.println("4. Evaluate Prefix Expression");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter infix expression: ");
                    String infixToPost = sc.nextLine();
                    System.out.println("Postfix: " + infixToPostfix(infixToPost));
                    break;
                case 2:
                    System.out.print("Enter infix expression: ");
                    String infixToPre = sc.nextLine();
                    System.out.println("Prefix: " + infixToPrefix(infixToPre));
                    break;
                case 3:
                    System.out.print("Enter postfix expression: ");
                    String postfixExp = sc.nextLine();
                    System.out.println("Postfix Evaluation: " + evaluatePostfix(postfixExp));
                    break;
                case 4:
                    System.out.print("Enter prefix expression: ");
                    String prefixExp = sc.nextLine();
                    System.out.println("Prefix Evaluation: " + evaluatePrefix(prefixExp));
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
