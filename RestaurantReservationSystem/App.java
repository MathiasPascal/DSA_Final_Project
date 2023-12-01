package RestaurantReservationSystem;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ReservationSystem reservationSystem = new ReservationSystem(13);
        BinarySearchTree tableAvailabilityTree = new BinarySearchTree();
        initializeTables(tableAvailabilityTree);
        Waitlist waitlist = new Waitlist();

        while (true) {
            displayMenu();

            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    makeReservation(scanner, reservationSystem, tableAvailabilityTree, waitlist);
                    break;
                case 2:
                    cancelReservation(scanner, reservationSystem, waitlist);
                    break;
                case 3:
                    reservationSystem.displayReservations();
                    break;
                case 4:
                    waitlist.displayWaitlist();
                    break;
                case 5:
                    displayOccupancyOverview(reservationSystem.getReservationsByCustomer(), waitlist);
                    break;
                case 6:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n===== Restaurant Reservation System =====");
        System.out.println("1. Make a Reservation");
        System.out.println("2. Cancel a Reservation");
        System.out.println("3. View Reservations");
        System.out.println("4. View Waitlist");
        System.out.println("5. View Occupancy Overview");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    private static void makeReservation(Scanner scanner, ReservationSystem reservationSystem,
                                       BinarySearchTree tableAvailabilityTree, Waitlist waitlist) {
        System.out.print("Enter customer first name: ");
        String firstName = scanner.next();

        System.out.print("Enter customer last name: ");
        String lastName = scanner.next();

        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.next();

        System.out.print("Enter customer address: ");
        String address = scanner.next();

        System.out.print("Enter customer email address: ");
        String email = scanner.next();

        Customer customer = new Customer(firstName, lastName, phoneNumber, address, email, false, false);

        System.out.print("Enter reservation date (YYYY-MM-DD): ");
        String date = scanner.next();

        System.out.print("Enter reservation time: ");
        String time = scanner.next();

        Table availableTable = findAvailableTable(tableAvailabilityTree, 4);

        if (availableTable != null) {
            reservationSystem.addReservation(customer, availableTable, date, time);
            System.out.println("Reservation added successfully.");
        } else {
            waitlist.addToWaitlist(customer);
            System.out.println("No available tables. Added to the waitlist.");
        }
    }

    private static void initializeTables(BinarySearchTree tableAvailabilityTree) {
        for (int i = 1; i <= 10; i++) {
            Table table = new Table(i, 4, true);
            tableAvailabilityTree.insert(table);
        }
    }

    private static void cancelReservation(Scanner scanner, ReservationSystem reservationSystem, Waitlist waitlist) {
        System.out.print("Enter customer last name for cancellation: ");
        String lastName = scanner.next();

        Reservation reservationToDelete = reservationSystem.getReservationsByCustomer().search(lastName);

        if (reservationToDelete != null) {
            reservationSystem.cancelReservation(lastName);
            System.out.println("Reservation canceled successfully.");
            processWaitlist(reservationSystem, waitlist);
        } else {
            System.out.println("Reservation not found for customer: " + lastName);
        }
    }

    private static void processWaitlist(ReservationSystem reservationSystem, Waitlist waitlist) {
        while (!waitlist.isEmpty()) {
            Customer nextCustomer = waitlist.peek();
            Table availableTable = findAvailableTable(reservationSystem.getTableAvailabilityTree(), 4);

            if (availableTable != null) {
                waitlist.removeFromWaitlist();
                reservationSystem.addReservation(nextCustomer, availableTable, "2023-12-01", "19:00");
                System.out.println("Reservation for " + nextCustomer.getName() + " added from waitlist.");
            } else {
                System.out.println("No available tables. Please try again later.");
                break;
            }
        }
    }

    private static void displayOccupancyOverview(HashTable<String, Reservation> reservationsByCustomer, Waitlist waitlist) {
        System.out.println("Current Reservations:");
        reservationsByCustomer.getAllEntries();
        System.out.println("\nWaitlist:");
        waitlist.displayWaitlist();
    }

     private static Table findAvailableTable(BinarySearchTree tableAvailabilityTree, int capacity) {
        return findTableWithCapacity(tableAvailabilityTree.getRoot(), capacity);
    }

    private static Table findTableWithCapacity(Node node, int capacity) {
        if (node != null) {
            if (node.getTable().getCapacity() >= capacity && node.getTable().getAvailablity()) {
                return node.getTable();
            } else {
                Table leftResult = findTableWithCapacity(node.getLeft(), capacity);
                Table rightResult = findTableWithCapacity(node.getRight(), capacity);
                return (leftResult != null) ? leftResult : rightResult;
            }
        }
        return null;
    }
}