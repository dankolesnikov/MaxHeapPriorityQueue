package danil;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW1 Fall 2017
 * Professor: Dr. Mike Wu
 */

public class Patient {
    String name;
    int priority;

    // Constructor
    Patient(String name, int priority){
        this.name = name;
        this.priority = priority;
    }

    // Getters
    public int getPriority(){
        return priority;
    }
    public void setPriority(int input)
    {
        this.priority=input;
    }
    public String getName(){
        return name;
    }
}
