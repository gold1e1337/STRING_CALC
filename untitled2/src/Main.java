import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine().replaceAll("\"","");
        char action;
        String[] data;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }

        if (data[0].length() > 10 || data[1].length() > 10) {

            throw new Exception("Длина числа или строки превышает допустимое значение");
        }

        if (action == '*' || action == '/') {
            if (!data[1].matches("\\d+")) {
                throw new Exception("Строку можно делить или умножать только на число");
            }
            int multiplier = Integer.parseInt(data[1]);
            if (multiplier < 1 || multiplier > 10) {
                throw new Exception("Число должно быть от 1 до 10 включительно");
            }
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        String result;
        if (action == '+') {
            result = data[0] + data[1];
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            result = repeatString(data[0], multiplier);
        } else if (action == '-') {
            result = removeSubstring(data[0], data[1]);
        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            result = data[0].substring(0, newLen);
        }

        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }

        printInQuotes(result);
    }
    static void printInQuotes(String text){
        System.out.println("\"" + text + "\"");
    }

    static String repeatString(String text, int multiplier) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
    static String removeSubstring(String text, String substring) {
        int index = text.indexOf(substring);
        if (index == -1) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text, 0, index);
        sb.append(text, index + substring.length(), text.length());
        return sb.toString();
    }
}