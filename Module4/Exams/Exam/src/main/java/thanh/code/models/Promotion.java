package thanh.code.models;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Promotion implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int promotionId;
    @NotBlank
    private String promotionTitle;
    private String promotionStartDate;
    private String promotionEndDate;
    @Min(10000)
    private double promotionDiscount;
    @NotBlank
    private String promotionDetail;

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionTitle() {
        return promotionTitle;
    }

    public void setPromotionTitle(String promotionTitle) {
        this.promotionTitle = promotionTitle;
    }

    public String getPromotionStartDate() {
        return promotionStartDate;
    }

    public void setPromotionStartDate(String promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public String getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(String promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public double getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(double promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public String getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(String promotionDetail) {
        this.promotionDetail = promotionDetail;
    }

    public Promotion() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Promotion.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Promotion promotion = (Promotion) target;
        LocalDateTime localDateTimeCurrent = LocalDateTime.now();
        if (!promotion.getPromotionStartDate().isEmpty() && !promotion.getPromotionEndDate().isEmpty()) {

            LocalDateTime localDateTimeStart = LocalDateTime.parse(promotion.getPromotionStartDate());
            LocalDateTime localDateTimeEnd = LocalDateTime.parse(promotion.getPromotionEndDate());

            // check promotion date with current date
            if (localDateTimeStart.getYear() > localDateTimeCurrent.getYear()) {
                errors.rejectValue("promotionStartDate", "promotion.greaterThanCurrentYear");
            } else {
                if (localDateTimeStart.getDayOfYear() > localDateTimeCurrent.getDayOfYear()) {
                    errors.rejectValue("promotionStartDate", "promotion.greaterThanCurrentDate");
                }

                // check promotion date with promotion end date
                // 1.promotion termination date before the promotion date
                if (localDateTimeStart.getDayOfYear() > localDateTimeEnd.getDayOfYear()) {
                    errors.rejectValue("promotionEndDate", "promotion.invalidTwoDay");
                }
                if (localDateTimeEnd.getDayOfYear() < localDateTimeStart.getDayOfYear()) {
                    errors.rejectValue("promotionStartDate", "promotion.invalidTwoDay");
                }

                // end in 1 day
                if (localDateTimeStart.getDayOfYear() == localDateTimeEnd.getDayOfYear()) {
                    System.out.println(localDateTimeStart.getHour());
                    System.out.println(localDateTimeEnd.getHour());
                    if (localDateTimeStart.getHour() > localDateTimeEnd.getHour()) {
                        errors.rejectValue("promotionStartDate", "promotion.invalidTwoTime");
                        errors.rejectValue("promotionEndDate", "promotion.invalidTwoTime");
                    }
                }
            }
        } else {
            errors.rejectValue("promotionStartDate", "promotion.blank");
            errors.rejectValue("promotionEndDate", "promotion.blank");
        }
    }
}
