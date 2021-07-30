package thanh.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import thanh.code.methodbymt.ManipulationFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 *2,
//                maxFileSize = 1024 * 1024 *2,
//                maxRequestSize = 1024 * 1024 * 50)
@MultipartConfig
public class HomeController {

    @PostMapping("/upload")
    public ModelAndView upload(HttpServletRequest request) throws IOException, ServletException
    {
        ManipulationFile.uploadFile(request);
        String fullNameFile = ManipulationFile.getFullFilename(request);
        String nameFile = ManipulationFile.getNameFile(fullNameFile);
        System.out.println(nameFile);
        return new ModelAndView("/index", "message", "upload success !");
    }

}
