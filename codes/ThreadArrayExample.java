public class ThreadArrayExample {
    public static void main(String[] args) {
        // Array to hold 10 threads
        Thread[] threads = new Thread[10];

        // Create 10 threads using a loop
        for (int i = 0; i < threads.length; i++) {
            int threadNumber = i + 1; // For display
            threads[i] = new Thread(() -> {
                System.out.println("Thread " + threadNumber + " started.");
                try {
                    Thread.sleep(2025); // Sleep for 2025 milliseconds
                } catch (InterruptedException e) {
                    System.out.println("Thread " + threadNumber + " interrupted.");
                }
                System.out.println("Thread " + threadNumber + " finished after sleeping.");
            });
        }

        // Start all threads
        for (Thread t : threads) {
            t.start();
        }

        // Optional: wait for all threads to finish (join)
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting.");
            }
        }

        System.out.println("All threads have finished.");
    }
}