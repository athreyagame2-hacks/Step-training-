import java.util.ArrayList;
import java.util.Scanner;

class Habit {
    String name;
    boolean completed;

    Habit(String name) {
        this.name = name;
        this.completed = false;
    }
}

class HabitTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Habit> habits = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Daily Habit Tracker ---");
            System.out.println("1. Add Habit");
            System.out.println("2. Mark Habit Completed");
            System.out.println("3. View Habits");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter habit name: ");
                    String name = sc.nextLine();
                    habits.add(new Habit(name));
                    System.out.println("Habit added!");
                    break;

                case 2:
                    if (habits.isEmpty()) {
                        System.out.println("No habits added yet.");
                        break;
                    }
                    for (int i = 0; i < habits.size(); i++) {
                        System.out.println((i + 1) + ". " + habits.get(i).name);
                    }
                    System.out.print("Select habit number: ");
                    int num = sc.nextInt();
                    if (num > 0 && num <= habits.size()) {
                        habits.get(num - 1).completed = true;
                        System.out.println("Marked as completed!");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    if (habits.isEmpty()) {
                        System.out.println("No habits to show.");
                    } else {
                        System.out.println("\nYour Habits:");
                        for (Habit h : habits) {
                            System.out.println("- " + h.name +
                                    " : " + (h.completed ? "Done ✅" : "Pending ❌"));
                        }
                    }
                    break;
            }

        } while (choice != 4);

        System.out.println("Stay consistent! Goodbye 👋");
        sc.close();
    }
}

