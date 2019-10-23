import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Task_3 {
        //Программа определяет пересекаются ли два отрезка

    public static void main(String[] args) {
        Scanner ch =new Scanner(System.in);
        System.out.println("Введите координаты первой точки первого отрезка(x,y):");
        int x1 = ch.nextInt();
        int y1 = ch.nextInt();
        System.out.println("Введите координаты второй точки первого отрезка(x,y):");
        int x2 = ch.nextInt();
        int y2 = ch.nextInt();
        System.out.println("Введите координаты первой точки второго отрезка(x,y):");
        int x3 = ch.nextInt();
        int y3 = ch.nextInt();
        System.out.println("Введите координаты второй точки второго отрезка(x,y):");
        int x4 = ch.nextInt();
        int y4 = ch.nextInt();

        Point Tochka1 = new Point(x1,y1);
        Point Tochka2 = new Point(x2,y2);
        Point Tochka3 = new Point(x3,y3);
        Point Tochka4 = new Point(x4,y4);

        if (Point.LinesIntersection(Tochka1,Tochka2,Tochka3,Tochka4)){
        System.out.println("Отрезки пересекаются");}
        else {
            System.out.println("Отрезки не пересекаются");
        }

    }
    public static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
          //Метод который определяет пересечение отрезков.
        public static boolean LinesIntersection(Point p1, Point p2, Point p3, Point p4) {

            if (p2.x < p1.x) {    //выставление заданных координат (слева направо)
                Point tmp = p1;
                p1 = p2;
                p2 = tmp;
            }
            if (p4.x < p3.x) {    //выставление заданных координат слева направо
                Point tmp = p3;
                p3 = p4;
                p4 = tmp;
            }
               if (p2.x < p3.x) {
                return false;
            }
            //проверка если оба отрезка вертикальные (координаты х совпадают)
            if((p1.x - p2.x == 0) && (p3.x - p4.x == 0)) {
                // проверка если оба отрезка лежат на одном X
                if(p1.x == p3.x) {
                    //проверим имеют ли отрезки общий Y
                    // Если отрезки имеют общий Y,(взято отрицание от "не имеют общего Y") они  пересекаются
                    if (!((Math.max(p1.y, p2.y) < Math.min(p3.y, p4.y)) ||
                            (Math.min(p1.y, p2.y) > Math.max(p3.y, p4.y)))) {
                        return true;
                    }
                }

                return false;
            }
            //если первый отрезок вертикальный
            if (p1.x - p2.x == 0) {
                //  Уравнение прямой в общем случае A * x + b = y.
                //  найдём Xa, Ya - координаты точки пересечения двух прямых
                double Xa = p1.x;
                double A2 = (p3.y - p4.y) / (p3.x - p4.x);
                double b2 = p3.y - A2 * p3.x;
                double Ya = A2 * Xa + b2;

                if (p3.x <= Xa && p4.x >= Xa && Math.min(p1.y, p2.y) <= Ya &&
                        Math.max(p1.y, p2.y) >= Ya) {
                    return true;
                }
                return false;
            }
            //если второй отрезок вертикальный
            if (p3.x - p4.x == 0) {

                //найдём Xa, Ya - точки пересечения двух прямых
                double Xa = p3.x;
                double A1 = (p1.y - p2.y) / (p1.x - p2.x);
                double b1 = p1.y - A1 * p1.x;
                double Ya = A1 * Xa + b1;

                if (p1.x <= Xa && p2.x >= Xa && Math.min(p3.y, p4.y) <= Ya &&
                        Math.max(p3.y, p4.y) >= Ya) {
                    return true;
                }
                return false;
            }
            //оба отрезка невертикальные
            double A1 = (p1.y - p2.y) / (p1.x - p2.x);
            double A2 = (p3.y - p4.y) / (p3.x - p4.x);
            double b1 = p1.y - A1 * p1.x;
            double b2 = p3.y - A2 * p3.x;

            if (A1 == A2) {
                return false; //отрезки параллельны
            }

            //Xa - абсцисса точки пересечения двух прямых
            double Xa = (b2 - b1) / (A1 - A2);

            if ((Xa < Math.max(p1.x, p3.x)) || (Xa > Math.min( p2.x, p4.x))) {
                return false; //точка Xa находится вне пересечения проекций отрезков на ось X
            }
            else {
                return true;
            }
        }
    }
}