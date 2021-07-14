package thanh.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectLogCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectLogCustomerApplication.class, args);
    }

}
