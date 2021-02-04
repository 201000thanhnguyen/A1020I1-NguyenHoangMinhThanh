package CaseStudy.Models.Controllers;

import java.util.Scanner;

public class MainController {

    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        boolean exit = false;
        do {
            System.out.println(
                    "1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n"
            );
            System.out.print("moi ban chon menu : ");
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    addNewServices();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    exit = !exit;
                    break;
                default:
                    break;
            }
        }while (!exit);
    }

    public static void addNewServices(){
        System.out.println("addNewServices()");
        displayMainMenu();
    }

    public static void showServices(){
        System.out.println("showServices()");
    }

}
