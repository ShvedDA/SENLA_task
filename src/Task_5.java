import java.sql.SQLOutput;
import java.util.Scanner;

public class Task_5 {

   // Программа проверяет слово на "палиндромность".
    public static void main(String[] args) {
        System.out.println("Введите слово на проверку:");
        Scanner scaner = new Scanner(System.in);
        String word = scaner.nextLine();
        char[] A = word.toCharArray();
        char[] B = new char[A.length];
        for (int i = 0; i < A.length; i++) {
            B[(A.length - 1) - i] = A[i];
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            //  int j=0; j++;
            if (A[i] == B[i]) {}
            else  sum++ ;
        }
            if (sum>0 ){
            System.out.println("Слово не палиндром!");
        }
            else System.out.println("Слово палиндром!");
    }
}