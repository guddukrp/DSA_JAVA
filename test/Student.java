package test;

import java.util.Comparator;

public class Student {
    int roll;
    String name;
    public Student(){
    }
    public Student(int roll,String name){
        this.roll=roll;
        this.name=name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public int getRoll() {
        return roll;
    }

    @Override
    public String toString() {
        return "Student{" +  roll + ", name=" + name + "} \n ";
    }
}
