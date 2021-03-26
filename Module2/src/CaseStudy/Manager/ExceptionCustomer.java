package CaseStudy.Manager;

public class ExceptionCustomer {
    public static boolean checkNameException(String nameCus) throws Exception {
        final String FULLNAME_REGEX =
                "^([A-Z_ÁÀÃẢẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÔỐỒỔỖỘƠỚỜỞỠỢÓÒÕỎỌƯỨỪỬỮỰÚÙỦŨỤÝỲỶỸỴ][a-z_áàãảạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịôốồổỗộơớờởỡợóòõỏọưứừửữựúùủũụýỳỷỹỵ \\s]+)+";

        if (nameCus.matches(FULLNAME_REGEX)){
            return true;
        }
        else {
            throw new Exception();
        }
    }

    public static boolean checkBirthdayException(String birthdayCus) throws Exception {
        final String BIRTHDAY_REGEX = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";

        if (birthdayCus.matches(BIRTHDAY_REGEX)){
            return true;
        }
        else {
            throw new Exception();
        }
    }

    public static String checkGenderException(String genderCus) throws Exception {
        if (genderCus.equalsIgnoreCase("Male")){
            return "Male";
        }
        else if (genderCus.equalsIgnoreCase("Female")){
            return "Female";
        }
        else if (genderCus.equalsIgnoreCase("Unknown")){
            return "Unknown";
        }
        else {
            throw new Exception();
        }
    }

    public static boolean checkIdCardException(String idCardCus) throws Exception {
        final String IDCARD_REGEX = "^[0-9]{3} [0-9]{3} [0-9]{3}";

        if (idCardCus.matches(IDCARD_REGEX)){
            return true;
        }
        else {
            throw new Exception();
        }
    }

    public static boolean checkEmailException(String emailCus) throws Exception {
        final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        if (emailCus.matches(EMAIL_REGEX)){
            return true;
        }
        else {
            throw new Exception();
        }
    }

}
