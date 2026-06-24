public class FileSimulator {
    public static void saveAccountAsync(Account account) {
        Thread saveThread = new Thread(() -> {
            try {
                System.out.println("[Background] Saving account " + account.getAccountNumber() + " to file...");
                Thread.sleep(2000); // pretend this is slow disk I/O
                System.out.println("[Background] Save complete for account " + account.getAccountNumber());
            } catch (InterruptedException e) {
                System.out.println("Save was interrupted.");
            }
        });
        saveThread.start(); // runs in background, doesn't block main thread
    }
}