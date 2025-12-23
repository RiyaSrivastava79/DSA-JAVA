import java.util.*;

<<<<<<< HEAD
public class CopyConstructor {
=======
public class Copyconstructor {
>>>>>>> aa93e69e9b3f0029002b85970be5b77ed3159f50
    public static void main(String[] args) {
        // पहला object बनाना
        Student s1 = new Student("Riya", 101);

        // दूसरा object कॉपी करके बनाना
        Student s2 = new Student(s1);

        // दोनों objects को print करना
        System.out.println("Student 1: " + s1.name + ", Roll: " + s1.roll);
        System.out.println("Student 2: " + s2.name + ", Roll: " + s2.roll);
    }
}

class Student {
    String name;
    int roll;

    // Parameterized constructor
    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    // Copy constructor
    Student(Student s) {
        this.name = s.name;
        this.roll = s.roll;
    }
}
