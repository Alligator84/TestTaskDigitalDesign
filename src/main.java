import java.util.Scanner;
import java.util.Stack;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();
        char[] chars = inputString.toCharArray();
        Stack temp = new Stack();
        String forStack = "";

        for (char element : chars) {
            if (element != '[' && element != ']') {
                if (Character.isDigit(element)) {
                    forStack+=element;
                } else if (!Character.isDigit(element)) {
                    forStack+=element;
                } else {
                    temp.push(forStack);
                    forStack = "";
                }
            } else if (element == ']') {
                try {
                    int number = Integer.parseInt(temp.get(temp.size() - 1).toString());
                    String newStr = "";
                    for (int i = 0; i < number; i++) {
                        newStr+=forStack;
                    }
                    temp.set(temp.size() - 1, newStr);
                    forStack = "";
                } catch (Exception e) {
                    temp.set(temp.size() - 1, temp.get(temp.size() - 1).toString() + forStack);
                    forStack = "";
                }
            } else {
                temp.push(forStack);
                forStack = "";
            }
        }

        //
        for (int i = temp.size() - 1; i > 0; i--) {
            try {
                int number = Integer.parseInt(temp.get(i - 1).toString());
                String newStr = "";
                for (int j = 0; j < number; j++) {
                    newStr+=temp.get(i).toString();
                }
                temp.set(i - 1, newStr);
            } catch (Exception e) {
                temp.set(i - 1, temp.get(i - 1).toString() + temp.get(i).toString());
            }
        }
        System.out.println(temp.get(0).toString());
        temp.clear();
    }
}
