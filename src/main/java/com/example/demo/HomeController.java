package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /**
     * Greeter REST controller
     * Please refer to the following swagger api for more detail on the available
     * operations and corresponding response status
     * https://app.swaggerhub.com/apis/nboumaza/springboot/1.0.0#/
     *
     * @return greeting message
     */
    @RequestMapping("/first")
    public String first() {
        return "Greetings from the ATM first page";
    }
    
    /**
     * Greeter REST controller
     * Please refer to the following swagger api for more detail on the available
     * operations and corresponding response status
     * https://app.swaggerhub.com/apis/nboumaza/springboot/1.0.0#/
     *
     * @return greeting message
     */
    @RequestMapping("/second")
    public String second() {
        return "Greetings from Spring Boot! second page  from the ATM";
    }
    
    
    /**
     * Greeter REST controller
     * Please refer to the following swagger api for more detail on the available
     * operations and corresponding response status
     * https://app.swaggerhub.com/apis/nboumaza/springboot/1.0.0#/
     *
     * @return greeting message
     */
    @RequestMapping("/")
    public String home() {
        return "Greetings from Spring Boot!  from the ATM";
    }

}
