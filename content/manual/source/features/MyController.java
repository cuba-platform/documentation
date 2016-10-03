package com.company.test.portal.myapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapi")
public class MyController {

    @GetMapping("/dosmth")
    public String doSmth() {
        return "done";
    }
}
