package com.sample.backend;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BackEndController {

    private final String hostName = System.getenv("HOSTNAME");

	@RequestMapping("/")
	public String ribbonPing() {
		System.out.println("Ribbon ping");
		return this.hostName;
    }

    @RequestMapping(value="/names/list", method=RequestMethod.GET)
    List<String> getNames() {
        return Arrays.asList("1-BackendName","2-BackendName","3-BackendName");
    }
    
}