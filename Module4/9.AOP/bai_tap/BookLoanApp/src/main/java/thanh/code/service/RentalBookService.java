package thanh.code.service;

import thanh.code.bean.RentalBook;

public interface RentalBookService {
    RentalBook findById(Integer id);

    void save(RentalBook rentalBook);

    void delete(RentalBook rentalBook);
}
