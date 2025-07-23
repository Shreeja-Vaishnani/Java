abstract class Game {
    abstract void play(); // no body
}

class Cricket extends Game {
    void play() {
        System.out.println("Cricket");
    }
}

class Tennis extends Game {
    void play() {
        System.out.println("Tennis");
    }
}

public class Abstraction_class {
    public static void main(String[] args) {
        Cricket c = new Cricket();
        c.play();
        
        Tennis t = new Tennis();
        t.play();
    }
}

