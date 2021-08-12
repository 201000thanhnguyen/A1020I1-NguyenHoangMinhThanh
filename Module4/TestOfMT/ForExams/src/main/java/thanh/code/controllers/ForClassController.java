package thanh.code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.tracking.exception.ForClassException;

@Controller
@RequestMapping
public class ForClassController {

    @GetMapping(value = {"/index", "/", " "})
    public ModelAndView index(){
        return new ModelAndView("/index");
    }
    @GetMapping("/search/{id}")
    public ModelAndView search(@PathVariable int id) throws Exception{
        if (id > 10){
            throw new ForClassException();
        }
        return new ModelAndView("/index");
    }

    @ExceptionHandler(ForClassException.class)
    public ModelAndView error(){
        return new ModelAndView("/index");
    }
}
