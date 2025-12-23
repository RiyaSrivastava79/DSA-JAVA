abstract class Animal {
    abstract void sound();
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Horse extends Animal {
    @Override
    void sound() {
        System.out.println("Horse says neigh!");
    }
    void run() {
        System.out.println("Horse runs fast.");
    }
}

class Mustang extends Horse {
    void showMustang() {
        System.out.println("This is a Mustang horse.");
    }
}

public class abstraction {
    public static void main(String[] args) {
        Mustang myMustang = new Mustang();
        myMustang.sound();
        myMustang.eat();
        myMustang.run();
        myMustang.showMustang();
    }
}
