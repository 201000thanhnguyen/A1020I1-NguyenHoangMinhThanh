package CaseStudy.Manager;

import CaseStudy.Models.Customer;

import java.util.Comparator;

public class SortCustomer implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getNameCus().compareTo(o2.getNameCus()) != 0){
            return o1.getNameCus().compareTo(o2.getNameCus());
        }
        else {
            int yearO1 = Integer.parseInt(o1.getBirthdayCus().substring(6, 10));
            int yearO2 = Integer.parseInt(o2.getBirthdayCus().substring(6, 10));
            return yearO1 - yearO2;
        }
    }
}
