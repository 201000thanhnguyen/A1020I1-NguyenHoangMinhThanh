package CaseStudy.Controllers;

import CaseStudy.Models.Villa;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class MainController {

    private static boolean stop = false;

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
                    showServices();
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
                    stop = true;
                    break;
                default:
                    break;
            }
        }while (!stop);
    }

    // complete menu add new services
    public static void addNewServices(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        boolean exit = false;
        do {
            System.out.println(
                    "1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n"
            );
            System.out.print("moi ban chon menu : ");
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("add new villa");
                    addNewVilla();
                    break;
                case 2:
                    System.out.println("add new house");
                    break;
                case 3:
                    System.out.println("add new room");
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    stop = true;
                    break;
                default:
                    break;
            }
        }while (!stop);
    }

    // complete add new villa template
    public static void addNewVilla(){
        Scanner scanner = new Scanner(System.in);
        Villa villa = new Villa();
        villa.showInfor();
        System.out.print("nhap id cho villa: ");
        villa.setId(scanner.nextLine());
        System.out.print("nhap kieu thue cho villa: ");
        villa.setKieuThue(scanner.nextLine());
        System.out.print("nhap so luong nguoi toi da cho villa: ");
        villa.setSoLuongNguoiToiDa(scanner.nextInt());
        System.out.print("nhap chi phi thue cho villa: ");
        villa.setChiPhiThue(scanner.nextDouble());
        System.out.print("nhap dien tich su dung cho villa: ");
        villa.setDienTichSuDung(scanner.nextDouble());
        System.out.print("nhap ten dich vu cho villa: ");
        scanner.skip("\\R");
        villa.setTenDichVu(scanner.nextLine());
        System.out.print("nhap so tang cho villa: ");
        villa.setSoTang(scanner.nextInt());
        System.out.print("nhap dien tich ho boi cho villa: ");
        villa.setDienTichHoBoi(scanner.nextDouble());
        System.out.print("nhap mo ta tien nghi khac cho villa: ");
        scanner.skip("\\R");
        villa.setMoTaTienNghiKhac(scanner.nextLine());
        System.out.print("nhap tieuu chuan phong cho villa: ");
        villa.setTieuChuanPhong(scanner.nextLine());

        try {
            FileWriter fileWriter = new FileWriter("D:\\NguyenHoangMinhThanh_A1020I1\\A1020I1-NguyenHoangMinhThanh\\Module2\\src\\CaseStudy\\Data\\Villa.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println(villa.toString());
            bufferedWriter.write(
                    villa.getId()+";"+
                    villa.getKieuThue()+";"+
                    villa.getSoLuongNguoiToiDa()+";"+
                    villa.getChiPhiThue()+";"+
                    villa.getDienTichSuDung()+";"+
                    villa.getTenDichVu()+";"+
                    villa.getSoTang()+";"+
                    villa.getDienTichHoBoi()+";"+
                    villa.getMoTaTienNghiKhac()+";"+
                    villa.getTieuChuanPhong()+";"+
                    villa.getKieuThue());
            bufferedWriter.newLine();

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void showServices(){
        Scanner scanner = new Scanner(System.in);
        int choose;
        boolean exit = false;
        do {
            System.out.println(
                    "1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n"
            );
            System.out.print("moi ban chon menu : ");
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    showAllVilla();
                    break;
                case 2:
                    System.out.println("chua co");
                    break;
                case 3:
                    System.out.println("chua co");
                    break;
                case 4:
                    System.out.println("chua co");
                    break;
                case 5:
                    System.out.println("chua co");
                    break;
                case 6:
                    System.out.println("chua co");
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    stop = true;
                    break;
                default:
                    break;
            }
        }while (!stop);
    }

    public static void showAllVilla(){
        try {
            FileReader fileReader = new FileReader("D:\\NguyenHoangMinhThanh_A1020I1\\A1020I1-NguyenHoangMinhThanh\\Module2\\src\\CaseStudy\\Data\\Villa.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            String[] lineString = null;
            while (true){
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lineString = line.split(";");
                System.out.print(lineString[0]);
                System.out.print(lineString[1]);
                System.out.print(lineString[2]);
                System.out.print(lineString[3]);
                System.out.print(lineString[4]);
                System.out.print(lineString[5]);
                System.out.print(lineString[6]);
                System.out.print(lineString[7]);
                System.out.print(lineString[8]);
                System.out.print(lineString[9]);
                System.out.println(lineString[10]);

            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
