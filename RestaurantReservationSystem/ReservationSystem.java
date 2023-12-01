package RestaurantReservationSystem;

/**
 * The time complexity of the addReservation method is O(1) because it involves
 * inserting a reservation into a hash table, which has an average case time
 * complexity of O(1). The time complexity of the cancelReservation method is
 * also O(1) because it involves deleting a reservation from the hash table,
 * which again has an average case time complexity of O(1). The time complexity
 * of the displayReservations method is O(n) because it needs to print all the
 * reservations stored in the hash table, which takes linear time proportional
 * to the number of reservations.
 */
public class ReservationSystem {
    private HashTable<String, Reservation> reservationsByCustomer;

    public ReservationSystem(int initialCapacity) {
        this.reservationsByCustomer = new HashTable<>(initialCapacity);
    }

    /**
     * // Time complexity is O(n)
     * @param customer
     * @param table
     * @param date
     * @param time
     */
    public void addReservation(Customer customer, Table table, String date, String time) {
        Reservation newReservation = new Reservation(customer, table, date, time);
        reservationsByCustomer.insert(newReservation);
        System.out.println("Reservation added successfully.");
    }

    /**
     * // Time complexity is O(n)
     * @param customerName
     */
    public void cancelReservation(String customerName) {
        Reservation reservationToDelete = reservationsByCustomer.search(customerName);

        if (reservationToDelete != null) {
            reservationsByCustomer.delete(customerName);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Reservation not found for customer: " + customerName);
        }
    }

    /**
     * // Time complexity is O(n)
     */
    public void displayReservations() {
        System.out.println("Current Reservations:");
        System.out.println(reservationsByCustomer);
    }

    /**
     * // Time complexity is O(n)
     * @return
     */
    public HashTable<String, Reservation> getReservationsByCustomer() {
        return this.reservationsByCustomer;
    }
}
