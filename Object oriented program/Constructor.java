public class Constructor {
    public static void main(String[] args) {
<<<<<<< HEAD
        Student s1 = new Student();  //constructor कॉल हो रहा है
=======
        Student s1 = new Student();  // 👈 यहीं constructor कॉल हो रहा है
>>>>>>> aa93e69e9b3f0029002b85970be5b77ed3159f50
        // System.out.println(s1.name);
    }
}

class Student {
    String name;
    int roll;

    Student() {
        System.out.println("constructor is called...");
    }
}
