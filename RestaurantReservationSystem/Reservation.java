package RestaurantReservationSystem;

/**
 * This class represents a reservation in the restaurant reservation system. A
 * reservation has a customer, table, date, time, and status. The status of a
 * reservation can be either "Available" or "Booked".
 * 
 * The Reservation class does not contain any loops or recursive calls, so the
 * time complexity of each method is O(1), meaning it takes a constant amount of time to
 * execute regardless of the size of the input.
 */
public class Reservation extends Entry<String, Reservation> {
    private Customer customer;
    private Table table;
    private String date;
    private String time;
    private String status = "Available";

    public Reservation(Customer customer, Table table, String date, String time) {
        super(customer.getLastName(), null);
        this.customer = customer;
        this.table = table;
        this.date = date;
        this.time = time;
        this.status = "Booked";
        this.table.setAvailablility(false);
    }

    /**
     *  Time complexity is O(1)
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *  Time complexity is O(1)
     * @return the table
     */
    public Table getTable() {
        return table;
    }

    /**
     *  Time complexity is O(1)
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     *  Time complexity is O(1)
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     *  Time complexity is O(1)
     * @return the key
     */
    public String getKey() {
        return customer.getLastName();
    }

    /**
     *  Time complexity is O(1)
     * @return the status
     */
    public String getStatus() {
        return status;
    }
}