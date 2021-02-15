package com.scb.parser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileReader {
    @Autowired
    private SymbolMapper symbolMapper;
    public Stream<String> getFileStream(String filePath) {
        try {
            return Files.lines(Paths.get(filePath));
        } catch (Exception e) {

        }
        return null;
    }

    //to inclusive , from exclusive
    private List<String> readLines(Stream<String> st) {
        List<String> lines = new ArrayList<>();
           try {
               st.forEach(e->{
                   lines.add(e);
               });

           }catch (Exception e){
               return lines;
           }
        return lines;
    }


    public void fileReader(String path) {
        Stream s = getFileStream(path);
        List<String> lines = readLines(s);
        boolean invalid = false;
        for (int j=0;j < lines.size(); j =j +3) {
            String finalValue = "";
            for (int i =0;i < 27 ; i=i+3) {
                String str = lines.get(j).substring(i,i+3)+"\n"+lines.get(j+1).substring(i,i+3)+"\n"+lines.get(j+2).substring(i,i+3);
                Integer val = symbolMapper.getValue(str);
                if (val==null) {
                    invalid= true;
                    finalValue = finalValue + "?";
                }else {
                    finalValue = finalValue + val;
                }
            }
            if (invalid) {
                finalValue = finalValue + "ILL";
            }
            System.out.println(finalValue);
        }

    }

}
