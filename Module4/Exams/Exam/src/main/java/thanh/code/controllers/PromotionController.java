package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.models.Promotion;
import thanh.code.service.IPromotionService;

@Controller
@RequestMapping("/Promotion")
public class PromotionController {

    private final IPromotionService promotionService;

    public PromotionController(IPromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping({"/index", "/", ""})
    public ModelAndView index() {
        return new ModelAndView("/Promotion/index", "listPromotion", this.promotionService.listEntity());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/Promotion/create", "promotion", new Promotion());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        Promotion promotion = this.promotionService.findByIdInt(id);
        if (promotion == null) {
            return index();
        } else {
            return new ModelAndView("/Promotion/edit", "promotion", promotion);
        }
    }

    @PostMapping("/create")
    public ModelAndView create(@Validated @ModelAttribute Promotion promotion, BindingResult bindingResult) {
        new Promotion().validate(promotion, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/Promotion/create");
        } else {
            this.promotionService.addOrUpdateEntity(promotion);
            return index();
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Validated @ModelAttribute Promotion promotion, BindingResult bindingResult) {
        new Promotion().validate(promotion, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/Promotion/edit");
        } else {
            this.promotionService.addOrUpdateEntity(promotion);
            return index();
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        this.promotionService.removeEntity(this.promotionService.findByIdInt(id));
        return index();
    }
}
