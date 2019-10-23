import java.util.Scanner;

public class Task_4 {

    //Программа для нахождения НОД и НОК двух чисел.
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int num1 = number.nextInt();
        System.out.println("Введите второе число:");
        int num2 = number.nextInt();
        //Нахождение НОД
        int maxNum = Math.max(num1,num2);
        int[] f = new int[maxNum];

        for (int i = 1; i < f.length; i++) {
            if ((num1 % i == 0) & (num2 % i == 0)) {
                f[i] = i;
            }
        }
        int max = f[0];
        for (int i = 0; i < f.length; i++) {
            if (max < f[i]) {
                max = f[i];
            }
         }
        System.out.println("НОД = " + max);

        //Нахождение НОК
        int nok =0;
        for (int i = 1; i < maxNum; i++) {
            int temp = maxNum*i;
            if (temp%num2==0) {
                 nok = temp;
                break;
            }
        }
        System.out.println("НОК = "+nok);

    }
}
