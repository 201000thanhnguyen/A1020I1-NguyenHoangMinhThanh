package _12_Java_Collection_Framework._bai_tap;

import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        int choose;
        boolean exit = false;
        do {
            System.out.println(
                    "1.\tchoose 1\n" +
                    "2.\tchoose 2\n" +
                    "3.\tchoose 3\n" +
                    "4.\tchoose 4\n" +
                    "5.\tchoose 5\n" +
                    "6.\tExit\n"
            );
            System.out.print("choose ? : ");
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("alo1");
                    break;
                case 2:
                    System.out.println("alo2");
                    break;
                case 3:
                    System.out.println("alo3");
                    break;
                case 4:
                    System.out.println("alo4");
                    break;
                case 5:
                    System.out.println("alo5");
                    break;
                case 6:
                    stop = true;
                    break;
                default:
                    break;
            }
        }while (!stop);
    }
}
