import java.util.Scanner;

public class Task_2 {

    //Программа находит числа Фибоначчи в пределах от 1 до N.
    public static void main(String[] args) {
        System.out.println("Enter N:");
        Scanner number = new Scanner(System.in);
        int n = number.nextInt();
        int [] a = new int[n];
        a[0]=0;
        a[1]=1;
        for (int i=2;i<n; i++){
           a[i] = a[i-2]+a[i-1];
        }
        for (int i = 0; i < n; ++i) {
            System.out.print(a[i]+" ");
        }
    }
}
