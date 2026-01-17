package org.example;

import java.util.ArrayList;
import java.util.Stack;

public class HistoryService {

    //variable for saving history: ;list
    private ArrayList<String> history = new ArrayList<>();

    //define method for saving results>> از کلاس مین قراره به تاریخچه اضافه بشه پس باید پابلیک باشه
    public void add(String record){
        history.add(record);
    }
    //------------show
    public void show(){
        if (history.isEmpty()){
            System.out.println("History is empty");}
        for (String h: history){
            System.out.println(h);};
    }
    //-------------clear
    public void clear(){
        history.clear();
        System.out.println("History is Cleared");
    }













    }
