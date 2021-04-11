package CaseStudy.Manager;

import CaseStudy.Commons.FileUtils;
import CaseStudy.Models.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManager {
    private static final String FILE_NAME_ROOM = "src/Data/Room.csv";

    public static void addNewRoom() {
        List<Room> listInfoRoom = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean checkValid = false;

        String idRoom;
        do {
            System.out.println("Nhập id: ");
            idRoom = sc.nextLine();
            if (idRoom.matches("^(SVRO)([\\\\w-])([\\d]{4})")){
                checkValid = true;
            }
            else {
                System.out.println("Id ko hợp lệ, nhập lại.");
            }
        }while (!checkValid);
        checkValid = false;

        String tenDichVuRoom;
        do {
            System.out.println("Nhập tên dịch vụ: ");
            tenDichVuRoom = sc.nextLine();
            if (tenDichVuRoom.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int dienTichSuDungRoom;
        do {
            System.out.println("Nhập diện tích sử dụng: ");
            dienTichSuDungRoom = Integer.parseInt(sc.nextLine());
            if (dienTichSuDungRoom > 30){
                checkValid = true;
            }
            else {
                System.out.println("Diện tích phải lớn hơn 30, mời nhập lại");
            }
        }while (!checkValid);
        checkValid=false;

        int chiPhiThueRoom;
        do {
            System.out.println("Nhập chi phí thuê: ");
            chiPhiThueRoom  = Integer.parseInt(sc.nextLine());
            if (chiPhiThueRoom > 0){
                checkValid = true;
            }
            else {
                System.out.println("Chi phí thuê phải là số dương, mới nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        int soLuongNguoiRoom;
        do {
            System.out.println("Nhập so lượng người tối đa: ");
            soLuongNguoiRoom  = Integer.parseInt(sc.nextLine());
            if (soLuongNguoiRoom > 0 && soLuongNguoiRoom < 20){
                checkValid = true;
            }
            else {
                System.out.println("Số lượng người ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String kieuThueRoom;
        do {
            System.out.println("Nhập kiểu thuê: ");
            kieuThueRoom  = sc.nextLine();
            if (kieuThueRoom.matches("^[A-Z][^A-Z]+")){
                checkValid = true;
            }
            else {
                System.out.println("Tên dịch vụ ko hợp lệ, mời nhập lại");
            }
        }while (!checkValid);
        checkValid = false;

        String dichVuMienPhiDiKem;
        do {
            System.out.println("Nhập dịch vụ miễn phí đi kèm: ");
            dichVuMienPhiDiKem   = sc.nextLine();
            if (dichVuMienPhiDiKem.matches("^(massage|karaoke|food|drink|car)$")){
                checkValid = true;
            }
            else {
                System.out.println("ko có dịch vụ này");
            }
        }while (!checkValid);

        Room inforRoom = new Room(idRoom, tenDichVuRoom, dienTichSuDungRoom, chiPhiThueRoom, soLuongNguoiRoom,
                kieuThueRoom, dichVuMienPhiDiKem);
        listInfoRoom.add(inforRoom);

        String line = null;
        for (Room room: listInfoRoom){
            line = room.getId() + ", " + room.getTenDichVu() + ", " + room.getDienTichSuDung() + ", " +
                    room.getChiPhiThue() + ", " + room.getSoLuongNguoi() + ", " + room.getKieuThue() + ", " +
                    room.getDichVuMienPhiDiKem();

            FileUtils.writeFile(FILE_NAME_ROOM, line);
        }
    }

    public static void showRoomList(){
        List<Room> roomList = FileUtils.readFileRoom();
        for (int i = 0; i < roomList.size(); i++){
            System.out.println((1 + i) + " -----------------" + roomList.get(i)+ "\n");
        }
    }
}
