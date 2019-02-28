package com.sample.backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class StartupInit {

    @PostConstruct
    public void init() throws IOException{
        File tmpFile = new File("/tmp/ready.txt");
        FileWriter fileWriter = new FileWriter(tmpFile);
        fileWriter.write("App Ready");
        fileWriter.flush();
        fileWriter.close();
    }
}