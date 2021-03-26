package CaseStudy.Commons;

import CaseStudy.Models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FileUtils {
    public static void writeFile(String pathFile, String line) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(line);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileBooking(String pathFile, String line) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Villa> readFileVilla() {
        List<Villa> villalist = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/Data/Villa.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineVilla;
            String[] readLineVilla;
            Villa villa;
            while ((lineVilla = bufferedReader.readLine()) != null) {
                readLineVilla = lineVilla.split(", ");
                villa = new Villa(readLineVilla[0], readLineVilla[1], Integer.parseInt(readLineVilla[2]),
                        Integer.parseInt(readLineVilla[3]), Integer.parseInt(readLineVilla[4]), readLineVilla[5],
                        readLineVilla[6], readLineVilla[7], Integer.parseInt(readLineVilla[8]), Integer.parseInt(readLineVilla[9]));
                villalist.add(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villalist;
    }

    public static void readNameFileVilla() {
        try {
            FileReader fileReader = new FileReader("src/Data/Villa.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineVilla;
            String[] readLineVilla;
            Villa villa;
            TreeSet<String> villaTreeSet = new TreeSet<>();
            while ((lineVilla = bufferedReader.readLine()) != null) {
                villa = new Villa();
                readLineVilla = lineVilla.split(", ");
                villa.setTenDichVu(readLineVilla[1]);
                villaTreeSet.add(villa.getTenDichVu());
            }
            String[] arr = new String[villaTreeSet.size()];
            villaTreeSet.toArray(arr);
            int i = 1;
            for (String temp: arr){
                System.out.println(i + ". " + temp);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<House> readFileHouse() {
        List<House> houseList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/Data/House.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineHouse;
            String[] readLineHouse;
            House house;
            while ((lineHouse = bufferedReader.readLine()) != null) {
                readLineHouse = lineHouse.split(", ");
                house = new House(readLineHouse[0], readLineHouse[1], Integer.parseInt(readLineHouse[2]),
                        Integer.parseInt(readLineHouse[3]), Integer.parseInt(readLineHouse[4]), readLineHouse[5],
                        readLineHouse[6], readLineHouse[7], Integer.parseInt(readLineHouse[8]));
                houseList.add(house);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }

    public static void readNameFileHouse() {
        try {
            FileReader fileReader = new FileReader("src/Data/House.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineHouse;
            String[] readLineHouse;
            House house;
            TreeSet<String> houseTreeSet = new TreeSet<>();
            while ((lineHouse = bufferedReader.readLine()) != null) {
                house = new House();
                readLineHouse = lineHouse.split(", ");
                house.setTenDichVu(readLineHouse[1]);
                houseTreeSet.add(house.getTenDichVu());
            }
            String[] arr = new String[houseTreeSet.size()];
            houseTreeSet.toArray(arr);
            int i = 1;
            for (String temp: arr){
                System.out.println(i + ". " + temp);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Room> readFileRoom() {
        List<Room> roomList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/Data/Room.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineRoom;
            String[] readLineRoom;
            Room room;
            while ((lineRoom = bufferedReader.readLine()) != null) {
                readLineRoom = lineRoom.split(", ");
                room = new Room(readLineRoom[0], readLineRoom[1], Integer.parseInt(readLineRoom[2]),
                        Integer.parseInt(readLineRoom[3]), Integer.parseInt(readLineRoom[4]), readLineRoom[5],
                        readLineRoom[6]);
               roomList.add(room);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    public static void readNameFileRoom() {
        try {
            FileReader fileReader = new FileReader("src/Data/Room.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineRoom;
            String[] readLineRoom;
            Room room;
            TreeSet<String> roomTreeSet = new TreeSet<>();
            while ((lineRoom = bufferedReader.readLine()) != null) {
                room = new Room();
                readLineRoom = lineRoom.split(", ");
                room.setTenDichVu(readLineRoom[1]);
                roomTreeSet.add(room.getTenDichVu());
            }
            String[] arr = new String[roomTreeSet.size()];
            roomTreeSet.toArray(arr);
            int i = 1;
            for (String temp: arr){
                System.out.println(i + ". " + temp);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readFileCustomer(){
        List<Customer> customerList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/Data/Customer.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineCustomer;
            String[] readLineCustomer;
            Customer customer;
            while ((lineCustomer = bufferedReader.readLine()) != null){
                readLineCustomer = lineCustomer.split(", ");
                customer = new Customer(readLineCustomer[0], readLineCustomer[1], readLineCustomer[2], readLineCustomer[3],
                        readLineCustomer[4], readLineCustomer[5], readLineCustomer[6], readLineCustomer[7]);
                customerList.add(customer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static List<Employee> readFileEmployee(){
        List<Employee> employeeList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/Data/Employee.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineEmployee;
            String[] readLineEmployee;
            Employee employee;
            while ((lineEmployee = bufferedReader.readLine()) != null) {
                readLineEmployee = lineEmployee.split(", ");
                employee = new Employee(readLineEmployee[0], Integer.parseInt(readLineEmployee[1]), readLineEmployee[2]);
                employeeList.add(employee);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}