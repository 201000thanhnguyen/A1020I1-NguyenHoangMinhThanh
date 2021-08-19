package thanh.code.service;

import thanh.code.models.Promotion;

public interface IPromotionService extends ICRUDService<Promotion> {

    Promotion findByIdInt(int id);

}
