package com.scb.parser.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class SymbolMapper {
    private Map<String, Integer> symbolMap = new HashMap<>();

    public Integer getValue(String symbol) {
        if (symbolMap.containsKey(symbol)){
            return symbolMap.get(symbol);
        }
        return null;
    }

    @PostConstruct
    private void init() {
        symbolMap.put("...\n|.|\n|_|",0);
        symbolMap.put("...\n..|\n..|",1);
        symbolMap.put("._.\n._|\n|_.",2);
        symbolMap.put("._.\n._|\n._|",3);
        symbolMap.put("...\n|_|\n..|",4);
        symbolMap.put("._.\n|_.\n._|",5);
        symbolMap.put("._.\n|_.\n|_|",6);
        symbolMap.put("._.\n..|\n..|",7);
        symbolMap.put("._.\n|_|\n|_|",8);
        symbolMap.put("._.\n|_|\n._|",9);
    }
}
