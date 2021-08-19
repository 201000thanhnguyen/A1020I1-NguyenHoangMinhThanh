package thanh.code.service.impl;

import org.springframework.stereotype.Service;
import thanh.code.models.Promotion;
import thanh.code.repository.IPromotionRepository;
import thanh.code.service.IPromotionService;

import java.util.List;

@Service
public class PromotionService implements IPromotionService {

    private final IPromotionRepository promotionRepository;

    public PromotionService(IPromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion findByIdInt(int id) {
        return this.promotionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Promotion> listEntity() {
        return this.promotionRepository.findAll();
    }

    @Override
    public void addOrUpdateEntity(Promotion promotion) {
        this.promotionRepository.save(promotion);
    }

    @Override
    public void removeEntity(Promotion promotion) {
        this.promotionRepository.delete(promotion);
    }
}
