package org.example.Model;

import java.util.Random;

public class Reminders {
    String[] remindersArray = new String[10];
    int arraySize = 0;

    public Reminders() {
        remindersArray[0] = "Did you eat today?";
        remindersArray[1] = "Did you drink water?";
        remindersArray[2] = "Did you workout?";
        arraySize = 3;
    }

    public String getRemindersArray() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(arraySize);
        return remindersArray[randomIndex];
    }

    public void setRemindersArray(String newReminder) {
        arraySize++;
        remindersArray[arraySize] = newReminder;
    }
}
