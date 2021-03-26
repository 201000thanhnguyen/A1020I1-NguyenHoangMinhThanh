package CaseStudy.Manager;

import Commons.FileUtils;
import Models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VillaManager {
    private static final String FILE_NAME_VILLA = "src/Data/Villa.csv";

    public static void addNewVilla() {
        List<Villa> listInfoVilla = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean checkValid = false;

        String idVilla;
        do {
            System.out.println("Nhập id: ");
            idVilla = sc.nextLine();
            if (idVilla.matches("^(SVVL)([\\\\w-])([\\d]{4})")) {
                checkValid = true;
            }
            else {
                System.out.println("Id ko hợp lệ, mời nhập lại.");
            }
        } while (!checkValid);
        checkValid = false;

        String tenDichVuVilla;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            tenDichVuVilla = sc.nextLine();
            if (tenDichVuVilla.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int dienTichSuDungVilla;
        do {
            System.out.println("Nhập diện tích sử dụng: ");
            dienTichSuDungVilla = Integer.parseInt(sc.nextLine());
            if (dienTichSuDungVilla > 30){
                checkValid = true;
            }
            else {
                System.out.println("Diện tích phải lớn hơn 30, mời nhập lại");
            }
        }while (!checkValid);
        checkValid=false;

        int chiPhiThueVilla;
        do {
            System.out.println("Nhập chi phí thuê: ");
            chiPhiThueVilla  = Integer.parseInt(sc.nextLine());
            if (chiPhiThueVilla > 0){
                checkValid = true;
            }
            else {
                System.out.println("Chi phí thuê phải là số dương, mới nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int soLuongNguoiVilla;
        do {
            System.out.println("Nhập so lượng người tối đa: ");
            soLuongNguoiVilla  = Integer.parseInt(sc.nextLine());
            if (soLuongNguoiVilla > 0 && soLuongNguoiVilla < 20){
                checkValid = true;
            }
            else {
                System.out.println("Số lượng người ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String kieuThueVilla;
        do {
            System.out.println("Nhập kiểu thuê: ");
            kieuThueVilla  = sc.nextLine();
            if (kieuThueVilla.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String tieuChuanPhongVilla;
        do {
            System.out.println("Nhập tiêu chuẩn phòng: ");
            tieuChuanPhongVilla  = sc.nextLine();
            if (tieuChuanPhongVilla.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        System.out.println("Nhập mô tả tiện nghi khác: ");
        String tienNghiKhacVilla  = sc.nextLine();

        int dienTichHoBoiVilla;
        do {
            System.out.println("Nhập diện tích hồ bơi: ");
            dienTichHoBoiVilla  = Integer.parseInt(sc.nextLine());
            if (dienTichHoBoiVilla > 30){
                checkValid = true;
            }
            else {
                System.out.println("Diện tích hồ bơi phải lớn hơn 30, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int soTangVilla;
        do {
            System.out.println("Nhập số tầng: ");
            soTangVilla  = Integer.parseInt(sc.nextLine());
            if (soTangVilla > 0){
                checkValid = true;
            }
            else {
                System.out.println("Số tầng phải là số nguyên dương, mời nhập lại");
            }
        }while (!checkValid);

        Villa inforVilla = new Villa(idVilla, tenDichVuVilla, dienTichSuDungVilla, chiPhiThueVilla, soLuongNguoiVilla,
                kieuThueVilla, tieuChuanPhongVilla, tienNghiKhacVilla, dienTichHoBoiVilla, soTangVilla);
        listInfoVilla.add(inforVilla);

        String line;
        for (Villa villa: listInfoVilla){
            line = villa.getId() + ", " + villa.getTenDichVu() + ", " + villa.getDienTichSuDung() + ", " +
                    villa.getChiPhiThue() + ", " + villa.getSoLuongNguoi() + ", " + villa.getKieuThue() + ", " +
                    villa.getTieuChuanPhong() + ", " + villa.getMoTaTienNghiKhac() + ", " +
                    villa.getDienTichHoBoi() + ", " + villa.getSoTang();

            FileUtils.writeFile(FILE_NAME_VILLA, line);
        }
    }

    public static void showVillaList(){
        List<Villa> villaList = FileUtils.readFileVilla();
        for (int i = 0; i < villaList.size(); i++){
            System.out.println((1 + i) + " -----------------" + villaList.get(i)+ "\n");
        }
    }
}
