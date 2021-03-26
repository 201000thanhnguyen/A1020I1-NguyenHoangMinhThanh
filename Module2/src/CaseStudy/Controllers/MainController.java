package CaseStudy.Controllers;

import CaseStudy.Manager.*;
import CaseStudy.Models.*;
import CaseStudy.Commons.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MainController {
    private static void displayMainMenu(){
        Scanner sc = new Scanner(System.in);
        int chooseMenu;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Search Employee");
            System.out.println("8. Show Queue of Customer");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            chooseMenu = Integer.parseInt(sc.nextLine());

            switch (chooseMenu){
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    CustomerManager.addNewCustomer();
                    break;
                case 4:
                    CustomerManager.showInformationCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    EmployeeManager.showEmployee();
                    break;
                case 7:
                    EmployeeManager.searchEmployee();
                    break;
                case 8:
                    showQueueOfCustomer();
                    break;
                case 9:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseMenu != 0);
    }
    
    private static void addNewServices(){
        Scanner sc = new Scanner(System.in);
        int chooseServices;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            chooseServices = Integer.parseInt(sc.nextLine());

            switch (chooseServices){
                case 1:
                    VillaManager.addNewVilla();
                    break;
                case 2:
                    HouseManager.addNewHouse();
                    break;
                case 3:
                    RoomManager.addNewRoom();
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseServices != 0);
    }

    public static void showServices(){
        Scanner sc = new Scanner(System.in);
        int chooseServices;
        do {
            System.out.println("-----------------------------");
            System.out.println("1. Show all Villa");
            System.out.println("2. Show all House");
            System.out.println("3. Show all Room");
            System.out.println("4. Show all Name Villa Not Duplicate");
            System.out.println("5. Show all Name House Not Duplicate");
            System.out.println("6. Show all Name Room Not Duplicate");
            System.out.println("7. Back to menu");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            chooseServices = sc.nextInt();

            switch (chooseServices){
                case 1:
                    VillaManager.showVillaList();
                    break;
                case 2:
                    HouseManager.showHouseList();
                    break;
                case 3:
                    RoomManager.showRoomList();
                    break;
                case 4:
                    FileUtils.readNameFileVilla();
                    break;
                case 5:
                    FileUtils.readNameFileHouse();
                    break;
                case 6:
                    FileUtils.readNameFileRoom();
                    break;
                case 7:
                    displayMainMenu();
                    break;
                case 8:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }
        }while (chooseServices != 0);
    }

    public static void addNewBooking(){
        Scanner sc = new Scanner(System.in);
        List<Customer> customerList = FileUtils.readFileCustomer();
        CustomerManager.showInformationCustomer();
        System.out.println("Chọn customer: ");
        int chooseCus = Integer.parseInt(sc.nextLine());
        List<Villa> villaList = null;
        List<House> houseList = null;
        List<Room> roomList = null;
        String line;

        Customer customer = customerList.get(chooseCus);
        line = customer.getNameCus() + ", " + customer.getBirthdayCus() + ", " + customer.getGenderCus() + ", " +
                customer.getIdCardCus() + ", " + customer.getPhoneCus() + ", " + customer.getEmailCus() + ", " +
                customer.getTypeCus() + ", " + customer.getAddressCus() + ", ";
        FileUtils.writeFile("src/Data/Booking.csv", line);

        do {
            System.out.println("-----------------------------");
            System.out.println("1. Booking Villa");
            System.out.println("2. Booking House");
            System.out.println("3. Booking Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int chooseBooking = Integer.parseInt(sc.nextLine());

            switch (chooseBooking){
                case 1:
                    villaList = FileUtils.readFileVilla();
                    VillaManager.showVillaList();
                    System.out.println("Chọn villa cần book: ");
                    int chooseVilla = Integer.parseInt(sc.nextLine());
                    Villa villa = villaList.get(chooseVilla - 1);
                    line = villa.getId() + ", " + villa.getTenDichVu() + ", " + villa.getDienTichSuDung() + ", " +
                            villa.getChiPhiThue() + ", " + villa.getSoLuongNguoi() + ", " + villa.getKieuThue() + ", " +
                            villa.getTieuChuanPhong() + ", " + villa.getMoTaTienNghiKhac() + ", " +
                            villa.getDienTichHoBoi() + ", " + villa.getSoTang();
                    FileUtils.writeFileBooking("src/Data/Booking.csv", line);
                    break;
                case 2:
                    houseList = FileUtils.readFileHouse();
                    HouseManager.showHouseList();
                    System.out.println("Chọn villa cần book: ");
                    int chooseHouse = Integer.parseInt(sc.nextLine());
                    House house = houseList.get(chooseHouse - 1);
                    line = house.getId() + ", " + house.getTenDichVu() + ", " + house.getDienTichSuDung() + ", " +
                            house.getChiPhiThue() + ", " + house.getSoLuongNguoi() + ", " + house.getKieuThue() + ", " +
                            house.getMoTaTienNghiKhac() + ", " + house.getTieuChuanPhong() + ", " + house.getSoTang();
                    FileUtils.writeFileBooking("src/Data/Booking.csv", line);
                    break;
                case 3:
                    roomList = FileUtils.readFileRoom();
                    RoomManager.showRoomList();
                    System.out.println("Chọn villa cần book: ");
                    int chooseRoom = Integer.parseInt(sc.nextLine());
                    Room room = roomList.get(chooseRoom - 1);
                    line = room.getId() + ", " + room.getTenDichVu() + ", " + room.getDienTichSuDung() + ", " +
                            room.getChiPhiThue() + ", " + room.getSoLuongNguoi() + ", " + room.getKieuThue() + ", " +
                            room.getDichVuMienPhiDiKem();
                    FileUtils.writeFileBooking("src/Data/Booking.csv", line);
                    break;
                case 4:
                    displayMainMenu();
                    break;
                case 5:
                    System.out.println("Đã thoát!");
                    System.exit(0);
            }

        }while (chooseCus != 0);
    }

    public static void showQueueOfCustomer(){
        Queue<Customer> customerQueue = new LinkedList<>();
        List<Customer> customerList = FileUtils.readFileCustomer();
        CustomerManager.showInformationCustomer();

        customerQueue.add(customerList.get(3));
        customerQueue.add(customerList.get(1));
        customerQueue.add(customerList.get(5));
        Customer customer = null;
        System.out.println("Khách hàng mua vé");
        while (!customerQueue.isEmpty()){
            customer = customerQueue.poll();
            customer.showInfor();
        }
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}