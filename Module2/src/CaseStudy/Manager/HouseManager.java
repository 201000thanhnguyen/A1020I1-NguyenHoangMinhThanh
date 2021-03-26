package CaseStudy.Manager;

import Commons.FileUtils;
import Models.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseManager {
    private static final String FILE_NAME_HOUSE = "src/Data/House.csv";

    public static void addNewHouse() {
        List<House> listInfoHouse = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean checkValid = false;

        String idHouse;
        do {
            System.out.println("Nhập id: ");
            idHouse = sc.nextLine();
            if (idHouse.matches("^(SVHO)([\\\\w-])([\\d]{4})")){
                checkValid = true;
            }
            else {
                System.out.println("Id ko hợp lệ, nhập lại.");
            }
        }while (!checkValid);
        checkValid = false;

        String tenDichVuHouse;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            tenDichVuHouse = sc.nextLine();
            if (tenDichVuHouse.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int dienTichSuDungHouse;
        do {
            System.out.println("Nhập diện tích sử dụng: ");
            dienTichSuDungHouse = Integer.parseInt(sc.nextLine());
            if (dienTichSuDungHouse > 30){
                checkValid = true;
            }
            else {
                System.out.println("Diện tích phải lớn hơn 30, mời nhập lại");
            }
        }while (!checkValid);
        checkValid=false;

        int chiPhiThueHouse;
        do {
            System.out.println("Nhập chi phí thuê: ");
            chiPhiThueHouse  = Integer.parseInt(sc.nextLine());
            if (chiPhiThueHouse > 0){
                checkValid = true;
            }
            else {
                System.out.println("Chi phí thuê phải là số dương, mới nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int soLuongNguoiHouse;
        do {
            System.out.println("Nhập so lượng người tối đa: ");
            soLuongNguoiHouse  = Integer.parseInt(sc.nextLine());
            if (soLuongNguoiHouse > 0 && soLuongNguoiHouse < 20){
                checkValid = true;
            }
            else {
                System.out.println("Số lượng người ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String kieuThueHouse;
        do {
            System.out.println("Nhập kiểu thuê: ");
            kieuThueHouse  = sc.nextLine();
            if (kieuThueHouse.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String tieuChuanPhongHouse;
        do {
            System.out.println("Nhập tiêu chuẩn phòng: ");
            tieuChuanPhongHouse  = sc.nextLine();
            if (tieuChuanPhongHouse.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        System.out.println("Nhập mô tả tiện nghi khác: ");
        String tienNghiKhacHouse  = sc.nextLine();

        int soTangHouse;
        do {
            System.out.println("Nhập số tầng: ");
            soTangHouse  = Integer.parseInt(sc.nextLine());
            if (soTangHouse > 0){
                checkValid = true;
            }
            else {
                System.out.println("Số tầng phải là số nguyên dương, mời nhập lại");
            }
        }while (!checkValid);

        House inforHouse = new House(idHouse, tenDichVuHouse, dienTichSuDungHouse, chiPhiThueHouse, soLuongNguoiHouse,
                kieuThueHouse, tieuChuanPhongHouse, tienNghiKhacHouse, soTangHouse);
        listInfoHouse.add(inforHouse);

        String line = null;
        for (House house: listInfoHouse){
            line = house.getId() + ", " + house.getTenDichVu() + ", " + house.getDienTichSuDung() + ", " +
                    house.getChiPhiThue() + ", " + house.getSoLuongNguoi() + ", " + house.getKieuThue() + ", " +
                    house.getMoTaTienNghiKhac() + ", " + house.getTieuChuanPhong() + ", " + house.getSoTang();

            FileUtils.writeFile(FILE_NAME_HOUSE, line);
        }
    }

    public static void showHouseList(){
        List<House> houseList = FileUtils.readFileHouse();
        for (int i = 0; i < houseList.size(); i++){
            System.out.println((1 + i) + " -----------------" + houseList.get(i)+ "\n");
        }
    }
}
