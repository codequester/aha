package com.sample.frontend;

import java.util.Arrays;
import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
class FronEndService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getNamesFromCache")
    List<String> getNamesFromBackend() {
        return restTemplate.getForObject("http://service-backend/names/list", List.class);
    }

    List<String> getNamesFromCache() {
        return Arrays.asList("1-CachedName", "2-CachedName", "3-CachedName");
    }

}
