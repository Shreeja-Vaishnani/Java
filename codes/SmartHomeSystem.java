import java.util.*;

// ---------- INTERFACES FOR SMART HOME ----------
interface Switchable {
    void turnOn();
    void turnOff();

    default void toggle(boolean state) {
        if (state) turnOn();
        else turnOff();
    }

    static void logSwitch(String device) {
        System.out.println("[LOG] Switchable action on: " + device);
    }
}

interface Schedulable {
    void schedule(String time);

    static void logSchedule(String device, String time) {
        System.out.println("[LOG] " + device + " scheduled at " + time);
    }
}

interface SensorEnabled {
    void detectMotion();

    static void logSensor(String device) {
        System.out.println("[LOG] Sensor triggered on: " + device);
    }
}

// ---------- SMART HOME DEVICES ----------
class Light implements Switchable, Schedulable {
    public void turnOn() {
        System.out.println("Light turned ON");
        Switchable.logSwitch("Light");
    }

    public void turnOff() {
        System.out.println("Light turned OFF");
    }

    public void schedule(String time) {
        System.out.println("Light scheduled at: " + time);
        Schedulable.logSchedule("Light", time);
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan turned ON");
    }

    public void turnOff() {
        System.out.println("Fan turned OFF");
    }
}

class Thermostat implements Schedulable {
    public void schedule(String time) {
        System.out.println("Thermostat scheduled at: " + time);
    }
}

class Camera implements Switchable, SensorEnabled {
    public void turnOn() {
        System.out.println("Camera turned ON");
    }

    public void turnOff() {
        System.out.println("Camera turned OFF");
    }

    public void detectMotion() {
        System.out.println("Motion detected by Camera");
        SensorEnabled.logSensor("Camera");
    }
}

// ---------- EVENT NOTIFICATION INTERFACES ----------
@FunctionalInterface
interface Notifier {
    void send(String message);

    private static String format(String msg) {
        return "[Notification] " + msg;
    }

    default void sendFormatted(String message) {
        String formatted = Notifier.format(message);
        send(formatted);
    }

    static void log(String channel) {
        System.out.println("[LOG] Notification sent via: " + channel);
    }
}

// Marker interface
interface UrgentNotification {}

// ---------- NOTIFICATION CHANNELS ----------
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSNotifier implements Notifier, UrgentNotification {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class PushNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Push Notification: " + message);
    }
}

// ---------- MAIN CLASS ----------
public class SmartHomeSystem {
    public static void main(String[] args) {
        System.out.println("=== SMART HOME AUTOMATION SYSTEM ===");
        Light light = new Light();
        Fan fan = new Fan();
        Thermostat thermostat = new Thermostat();
        Camera camera = new Camera();

        light.turnOn();
        light.schedule("6:00 PM");

        fan.turnOff();

        thermostat.schedule("8:00 AM");

        camera.turnOn();
        camera.detectMotion();

        System.out.println("\n=== EVENT NOTIFICATION SYSTEM ===");
        List<Notifier> notifiers = Arrays.asList(
            new EmailNotifier(),
            new SMSNotifier(),
            new PushNotifier()
        );

        for (Notifier notifier : notifiers) {
            notifier.sendFormatted("System Alert!");
            Notifier.log(notifier.getClass().getSimpleName());

            if (notifier instanceof UrgentNotification) {
                System.out.println("[URGENT] " + notifier.getClass().getSimpleName() + " is high-priority");
            }
        }

        // Lambda-based notifier
        Notifier lambdaNotifier = msg -> System.out.println("Lambda Notifier: " + msg);
        lambdaNotifier.send("Test Lambda Notification");
    }
}
