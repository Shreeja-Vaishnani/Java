// Abstract Base Class
abstract class Instrument {
    abstract void play();
    String what() {
        return "Generic Instrument";
    }
    abstract void adjust();
}

// -------------------- First level --------------------
class Wind extends Instrument {
    @Override
    void play() {
        System.out.println("Wind instrument played");
    }

    @Override
    String what() {
        return "Wind Instrument";
    }

    @Override
    void adjust() {
        System.out.println("Wind instrument tuned properly");
    }
}

class Percussion extends Instrument {
    @Override
    void play() {
        System.out.println("Percussion instrument played");
    }

    @Override
    String what() {
        return "Percussion Instrument";
    }

    @Override
    void adjust() {
        System.out.println("Percussion instrument tuned properly");
    }
}

class Stringed extends Instrument {
    @Override
    void play() {
        System.out.println("Stringed instrument played");
    }

    @Override
    String what() {
        return "Stringed Instrument";
    }

    @Override
    void adjust() {
        System.out.println("Stringed instrument tuned properly");
    }
}

// -------------------- Second level --------------------
class Woodwind extends Wind {
    @Override
    void play() {
        System.out.println("Woodwind instrument played");
    }

    @Override
    String what() {
        return "Woodwind Instrument";
    }
}

class Brass extends Wind {
    @Override
    void play() {
        System.out.println("Brass instrument played");
    }

    @Override
    void adjust() {
        System.out.println("Brass instrument tuned properly");
    }
}

// -------------------- Main Class --------------------
public class InstrumentTest {
    public static void main(String[] args) {
        // Lowest child calls
        Instrument i1 = new Woodwind();
        i1.play();
        System.out.println(i1.what());
        i1.adjust();

        System.out.println();

        Instrument i2 = new Brass();
        i2.play();
        System.out.println(i2.what());
        i2.adjust();

        System.out.println();

        // Other direct subclasses
        Instrument i3 = new Percussion();
        i3.play();
        System.out.println(i3.what());
        i3.adjust();

        System.out.println();

        Instrument i4 = new Stringed();
        i4.play();
        System.out.println(i4.what());
        i4.adjust();
    }
}
