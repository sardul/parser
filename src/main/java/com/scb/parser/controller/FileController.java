package com.scb.parser.controller;

import com.scb.parser.service.FileReader;
import com.scb.parser.pojo.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FileController {
    @Autowired
    private FileReader fileReader;
    @PostMapping("/parse")
    public void parse(@RequestBody Path filePath) {
        System.out.println("hello"+filePath.getName());
        fileReader.fileReader(filePath.getPath());
    }
}
