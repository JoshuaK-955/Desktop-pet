package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private List<String> myList;

    public Statistics() {
        myList = new ArrayList<>();
    }

    public void addEvent(String theEvent) {
        myList.add(theEvent);
    }


}
