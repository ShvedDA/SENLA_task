import java.util.Scanner;

public class Task_6 {
    // Программа удаляет из текста числа.
    public static void main(String[] args) {
        System.out.println("Введите строку:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] charText = text.toCharArray();
        char[] result = new char[charText.length];
        for (int i = 0; i < charText.length; i++) {
            char c = charText[i];
            if (!(Character.isDigit(c))) {      // Символ не является цифрой
                result[i] = charText[i];
            }
        }
        System.out.print("Результат: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

        }
    }
}


