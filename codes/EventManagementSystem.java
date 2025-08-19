import java.util.*;

// Base Class
class Event {
    protected int eventId;
    protected String eventName;
    protected String date;
    protected String venue;

    public Event(int eventId, String eventName, String date, String venue) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
    }

    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Date: " + date);
        System.out.println("Venue: " + venue);
    }
}

// Interface
interface Registrable {
    void registerParticipant(String name);
    void showParticipants();
}

// Coding Event Subclass
class CodingEvent extends Event implements Registrable {
    private int maxTeamSize;
    private List<String> participants;

    public CodingEvent(int eventId, String eventName, String date, String venue, int maxTeamSize) {
        super(eventId, eventName, date, venue);
        this.maxTeamSize = maxTeamSize;
        this.participants = new ArrayList<>();
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Max Team Size: " + maxTeamSize);
    }

    @Override
    public void registerParticipant(String name) {
        if (participants.size() < maxTeamSize) {
            participants.add(name);
            System.out.println(name + " registered for " + eventName);
        } else {
            System.out.println("Registration full for " + eventName);
        }
    }

    @Override
    public void showParticipants() {
        System.out.println("Participants in " + eventName + ": " + participants);
    }
}

// Robotics Event Subclass
class RoboticsEvent extends Event implements Registrable {
    private String theme;
    private List<String> participants;

    public RoboticsEvent(int eventId, String eventName, String date, String venue, String theme) {
        super(eventId, eventName, date, venue);
        this.theme = theme;
        this.participants = new ArrayList<>();
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Theme: " + theme);
    }

    @Override
    public void registerParticipant(String name) {
        participants.add(name);
        System.out.println(name + " registered for " + eventName);
    }

    @Override
    public void showParticipants() {
        System.out.println("Participants in " + eventName + ": " + participants);
    }
}

// Hackathon Event Subclass
class HackathonEvent extends Event implements Registrable {
    private int durationHours;
    private List<String> participants;

    public HackathonEvent(int eventId, String eventName, String date, String venue, int durationHours) {
        super(eventId, eventName, date, venue);
        this.durationHours = durationHours;
        this.participants = new ArrayList<>();
    }

    @Override
    public void displayEventDetails() {
        super.displayEventDetails();
        System.out.println("Duration: " + durationHours + " hours");
    }

    @Override
    public void registerParticipant(String name) {
        participants.add(name);
        System.out.println(name + " registered for " + eventName);
    }

    @Override
    public void showParticipants() {
        System.out.println("Participants in " + eventName + ": " + participants);
    }
}

// Test Scenario
public class EventManagementSystem {
    public static void main(String[] args) {
        // Create Events (Polymorphism)
        Event e1 = new CodingEvent(101, "CodeSprint", "2025-09-15", "Lab A", 3);
        Event e2 = new RoboticsEvent(102, "RoboWar", "2025-09-16", "Auditorium", "AI and Automation");
        Event e3 = new HackathonEvent(103, "HackTheFuture", "2025-09-17", "Innovation Hub", 24);

        // Store in a list
        List<Event> events = Arrays.asList(e1, e2, e3);

        // Register Participants (Interface usage)
        Registrable r1 = (Registrable) e1;
        r1.registerParticipant("Alice");
        r1.registerParticipant("Bob");
        r1.registerParticipant("Charlie");
        r1.registerParticipant("David"); // Exceeds max size

        Registrable r2 = (Registrable) e2;
        r2.registerParticipant("Eve");
        r2.registerParticipant("Frank");

        Registrable r3 = (Registrable) e3;
        r3.registerParticipant("Grace");
        r3.registerParticipant("Heidi");

        // Display Details using Polymorphism
        for (Event e : events) {
            System.out.println("\n===== Event Details =====");
            e.displayEventDetails();

            // Show participants
            if (e instanceof Registrable) {
                ((Registrable) e).showParticipants();
            }
        }
    }
}
