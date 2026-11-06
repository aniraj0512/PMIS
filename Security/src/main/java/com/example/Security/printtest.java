
package com.example.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class printtest {

    @GetMapping("/hi")
    public String hi() {
        return "hi raj";
    }
    @GetMapping("/hello")
    public int ac(){
        return 1+6;
    }
}
