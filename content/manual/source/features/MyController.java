package com.company.test.portal.myapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.test.services.SomeService;

@RestController
@RequestMapping("/myapi")
public class MyController {

    @Inject
    protected SomeService someService;

    @GetMapping("/dosmth")
    public String doSmth() {
        return someService.getResult();
    }
}
