public class Objectclass {
    public static void main(String[] args) {
        // Create a Pen object
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor());

        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("Yellow");
        System.out.println(p1.getColor());

        // Example of using Student class
        Student s1 = new Student();
        s1.name = "Riya";
        s1.age = 17;
        s1.calcPercentage(85, 90, 95);  // Physics, Chemistry, Math
        System.out.println("Student Name: " + s1.name);
        System.out.println("Percentage: " + s1.percentage);
    }
}

// BankAccount class
class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }
}

// Pen class
class Pen {
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) {
        this.color = newColor;
    }

    void setTip(int newTip) {
        this.tip = newTip;
    }
}

// Student class
class Student {
    String name;
    int age;
    float percentage;

    void calcPercentage(int phy, int chem, int math) {
        this.percentage = (phy + chem + math) / 3.0f;
    }
}
