public class car_model {
    private String name;
    private double weight;
    private double sales_price;
    private int number_sold;
    private car_type type;

    // Enum for car types
    public enum car_type {
        HATCHBACK, SALOON, ESTATE
    }

    //constructor
    public car_model(String name, double weight, double sales_price, int number_sold, car_type type) {
        if (weight < 500 || weight > 3000) {
            throw new IllegalArgumentException("Weight must be between 500kg and 3000kg");
        }
        if (sales_price < 0) {
            throw new IllegalArgumentException("Sales price must be a positive number");
        }
        if (number_sold < 0) {
            throw new IllegalArgumentException("Number of sold can't be a negative number");
        }
        this.name = name;
        this.weight = weight;
        this.sales_price = sales_price;
        this.number_sold = number_sold;
        this.type = type; // No conversion needed since it's already car_type
    }

    //getters
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSales_price() {
        return sales_price;
    }

    public int getNumber_sold() {
        return number_sold;
    }

    public car_type getType() {
        return type;
    }

    //setters
    public void setWeight(double weight) {
        if (weight < 500 || weight > 3000) {
            throw new IllegalArgumentException("Weight must be between 500kg and 3000kg");
        }
        this.weight = weight;
    }

    public void setSales_price(double sales_price) {
        if (sales_price < 0) {
            throw new IllegalArgumentException("Sales price must be a positive number");
        }
        this.sales_price = sales_price;
    }

    public void setNumber_sold(int number_sold) {
        this.number_sold = number_sold;
    }

    public void setType(car_type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car model(name: " + name + ", weight: " + weight + " kg, sales price: £" + sales_price +
                ", number sold: " + number_sold + ", type: " + type + ")";
    }

    public double model_revenue() {
        return sales_price * number_sold;
    }

    public static void main(String[] args) {
        System.out.println("car_model.java runs");
    }
}