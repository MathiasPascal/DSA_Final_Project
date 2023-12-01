package RestaurantReservationSystem;

/**
 * This class represents a table in the restaurant reservation system. A table
 * has
 * a table number, capacity, and availability.
 * 
 * // The Table class does not contain any loops or recursive calls that depend on
 * the input size. Therefore, the time complexity of all methods in the Table
 * class is O(1), which means the operations are constant time and independent
 * of the input size.
 * 
 * @param tableNumber the table number of the table
 * @param capacity    the capacity of the table
 * @param isAvailable whether or not the table is available
 * 
 */
public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isAvailable;

    /**
     * Constructs a new Table object with the specified table number, capacity, and
     * availability.
     * 
     * @param tableNumber the table number of the table
     * @param capacity    the capacity of the table
     * @param isAvailable whether or not the table is available
     */
    public Table(int tableNumber, int capacity, boolean isAvailable) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
    }

    /**
     * // Time complexity is O(1)
     * @return
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * // Time complexity is O(1)
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * // Time complexity is O(1)
     * @return
     */
    public boolean getAvailablity() {
        return isAvailable;
    }

    /**
     * // Time complexity is O(1)
     * @return
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * // Time complexity is O(1)
     * @return
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * // Time complexity is O(1)
     * @return
     */
    public void setAvailablility(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * // Time complexity is O(1)
     * @return
     */
    public String toString() {
        return "Table Number: " + tableNumber + "\nCapacity: " + capacity + "\nIs Available: " + isAvailable;
    }

    /**
     * // Time complexity is O(1)
     * @return
     */
    public boolean equals(Object o) {
        if (o instanceof Table) {
            Table other = (Table) o;
            return tableNumber == other.getTableNumber() && capacity == other.getCapacity()
                    && isAvailable == other.getAvailablity();
        }
        return false;
    }

}