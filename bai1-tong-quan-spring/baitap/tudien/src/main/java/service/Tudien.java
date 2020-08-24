package service;

import java.util.HashMap;
import java.util.Map;

public class Tudien {

    public Map<String,String> list(){
        Map<String,String> list=new HashMap<>();
        list.put("hello","xin chào");
        list.put("goodbye","tạm biệt");
        return list;
    }
}
