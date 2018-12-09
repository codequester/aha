package com.sample.frontend;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
class FrontEndController {

    @Autowired
    private FronEndService frontEndService;

    @RequestMapping(value="/names/list", method=RequestMethod.GET)
    List<String> getNames() {
        return frontEndService.getNamesFromBackend();
    }

    @RequestMapping(value="/hello", method=RequestMethod.GET)
    String sayHello() {
        return "Hey Hello";
    }

}