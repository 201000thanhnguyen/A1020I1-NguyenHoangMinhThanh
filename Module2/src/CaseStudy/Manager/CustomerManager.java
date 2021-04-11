package CaseStudy.Manager;

import CaseStudy.Commons.FileUtils;
import CaseStudy.Models.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    private static final String FILE_NAME_CUSTOMER = "src/Data/Customer.csv";

    public static void addNewCustomer(){
        List<Customer> listInfoCustomer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean checkValid = false;
        Customer cus = new Customer();

        String nameCus;
        do {
            System.out.println("Nhập họ tên customer: ");
            nameCus = sc.nextLine();
            try{
                ExceptionCustomer.checkNameException(nameCus);
                checkValid = true;
            } catch (Exception e) {
                System.err.println("Tên khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
            }
        }while (!checkValid);
        checkValid = false;

        String birthdayCus;
        do {
            System.out.println("Nhập ngày sinh: ");
            birthdayCus = sc.nextLine();
            try{
                ExceptionCustomer.checkBirthdayException(birthdayCus);
                checkValid = true;
            } catch (Exception e) {
                System.err.println("Năm sinh phải > 1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
            }
        }while (!checkValid);
        checkValid = false;

        String genderCus;
        do {
            System.out.println("Nhập giới tính: ");
            genderCus = sc.nextLine();
            try{
                if (ExceptionCustomer.checkGenderException(genderCus).equals("Male")){
                    cus.setGenderCus("Male");
                    checkValid = true;
                }
                else if (ExceptionCustomer.checkGenderException(genderCus).equals("Female")){
                    cus.setGenderCus("Female");
                    checkValid = true;
                }
                else if (ExceptionCustomer.checkGenderException(genderCus).equals("Unknown")){
                    cus.setGenderCus("Unknown");
                    checkValid = true;
                }

            } catch (Exception e) {
                System.err.println("Giới tính phải đúng định dạng");
            }
        }while (!checkValid);
        checkValid = false;

        String idCardCus;
        do {
            System.out.println("Nhập số CMND: ");
            idCardCus = sc.nextLine();
            try{
                ExceptionCustomer.checkIdCardException(idCardCus);
                checkValid = true;
            } catch (Exception e) {
                System.err.println("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
            }
        }while (!checkValid);
        checkValid = false;

        System.out.println("Nhập số điện thoại: ");
        String phoneCus = sc.nextLine();

        String emailCus;
        do {
            System.out.println("Nhập email: ");
            emailCus = sc.nextLine();
            try{
                ExceptionCustomer.checkEmailException(emailCus);
                checkValid = true;
            } catch (Exception e) {
                System.err.println("Email phải đúng định dạng abc@abc.abc");
            }
        }while (!checkValid);
        checkValid = false;


        System.out.println("Nhập loại khách: ");
        String typeCus = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String addressCus = sc.nextLine();

        Customer inforCustomer = new Customer(nameCus, birthdayCus, genderCus, idCardCus, phoneCus,
                emailCus, typeCus, addressCus);
        listInfoCustomer.add(inforCustomer);

        String line;
        for (Customer customer: listInfoCustomer){
            line = customer.getNameCus() + ", " + customer.getBirthdayCus() + ", " + cus.getGenderCus() + ", " +
                    customer.getIdCardCus() + ", " + customer.getPhoneCus() + ", " + customer.getEmailCus() + ", " +
                    customer.getTypeCus() + ", " + customer.getAddressCus();

            FileUtils.writeFile(FILE_NAME_CUSTOMER, line);
        }
    }

    public static void showInformationCustomer(){
        List<Customer> customerList = FileUtils.readFileCustomer();
        Collections.sort(customerList, new SortCustomer());
        for (int i = 0; i < customerList.size(); i++){
            System.out.println((1 + i) + " -----------------" + customerList.get(i)+ "\n");
        }
    }
}
