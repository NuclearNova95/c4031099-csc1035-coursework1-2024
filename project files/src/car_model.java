/**
 * represents cars with name, weight, price, sales and type
 */
public class car_model {
    private final String name;
    private double weight;
    private double sales_price;
    private int number_sold;
    private car_type type;

    /**
     * enum representing the car type
     */
    public enum car_type {
        HATCHBACK, SALOON, ESTATE
    }

    /**
     * constructs car
     *
     * @param name        name of the car model
     * @param weight      weight of the car in kg (500-3000 kg)
     * @param sales_price sales price of the car in £
     * @param number_sold number of units sold
     * @param type        type of car (HATCHBACK, SALOON, ESTATE)
     * @throws IllegalArgumentException if weight, price, or number sold is invalid
     */
    public car_model(String name, double weight, double sales_price, int number_sold, car_type type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be blank.");
        }
        if (weight < 500 || weight > 3000) {
            throw new IllegalArgumentException("Weight must be between 500kg and 3000kg.");
        }
        if (sales_price < 0) {
            throw new IllegalArgumentException("Sales price must be a positive number.");
        }
        if (number_sold < 0) {
            throw new IllegalArgumentException("Number sold can't be negative.");
        }
        this.name = name;
        this.weight = weight;
        this.sales_price = sales_price;
        this.number_sold = number_sold;
        this.type = type;
    }

    /**
     * Gets car name
     * @return name of car model
     */
    public String get_name() {
        return name;
    }

    /**
     * gets the car weight
     * @return weight of car in kg
     */
    public double get_weight() {
        return weight;
    }

    /**
     * Get sales price of the car
     * @return sales price in £
     */
    public double get_sales_price() {
        return sales_price;
    }

    /**
     * Get number of units sold
     * @return number of cars sold
     */
    public int get_number_sold() {
        return number_sold;
    }

    /**
     * gets car type
     * @return type of the car (HATCHBACK, SALOON, ESTATE)
     */
    public car_type get_type() {
        return type;
    }

    /**
     * set car weight
     * @param weight new weight in kg (500-3000 kg).
     * @throws IllegalArgumentException if weight not in valid range.
     */
    public void set_weight(double weight) {
        if (weight < 500 || weight > 3000) {
            throw new IllegalArgumentException("Weight must be between 500kg and 3000kg.");
        }
        this.weight = weight;
    }

    /**
     * set the sales price
     * @param sales_price new sales price in £
     * @throws IllegalArgumentException if price is negative.
     */
    public void set_sales_price(double sales_price) {
        if (sales_price < 0) {
            throw new IllegalArgumentException("Sales price must be a positive number.");
        }
        this.sales_price = sales_price;
    }

    /**
     * sets the number of units sold
     * @param number_sold number of cars sold
     */
    public void set_number_sold(int number_sold) {
        this.number_sold = number_sold;
    }

    /**
     * sets type of car
     * @param type new car type (HATCHBACK, SALOON, ESTATE).
     */
    public void set_type(car_type type) {
        this.type = type;
    }

    /**
     * return string details of any model
     * @return string containing all details.
     */
    @Override
    public String toString() {
        return "Car model(name: " + name + ", weight: " + weight + " kg, sales price: £" + sales_price +
                ", number sold: " + number_sold + ", type: " + type + ")";
    }

    /**
     * calc total rev by model
     * @return total rev as sales * price
     */
    public double model_revenue() {
        return sales_price * number_sold;
    }

    /**
     * main method
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("car_model.java runs successfully.");
    }}
