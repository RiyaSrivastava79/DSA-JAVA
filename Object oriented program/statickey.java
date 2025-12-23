public class statickey {
    public static void main(String[] args) {
        // Access static variable through class name
        Student.schoolName = "JMV";

        Student s1 = new Student();
        System.out.println("Student 1 school: " + Student.schoolName);

        Student s2 = new Student();
        System.out.println("Student 2 school: " + Student.schoolName);
    }
}

class Student {
    String name;
    int roll;

    // static variable shared by all objects
    static String schoolName;

    Student() {
        System.out.println("Constructor is called...");
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
