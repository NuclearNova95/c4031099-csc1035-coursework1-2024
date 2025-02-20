/**
 * handles reporting for manufacturers and car models
 */
public class reporting {
    private final manufacturer[] manufacturers; // stores all manufacturers

    /**
     * constructs reporting object
     * @param manufacturers array of manufacturers
     */
    public reporting(manufacturer[] manufacturers) {
        this.manufacturers = manufacturers;
    }

    /**
     * gets most expensive car across all manufacturers
     * @return most expensive car model
     */
    public car_model most_expensive_car() {
        car_model most_expensive = null;
        for (manufacturer m : manufacturers) {
            car_model expensive_car = m.most_expensive_car();
            if (most_expensive == null || (expensive_car != null && expensive_car.get_sales_price() > most_expensive.get_sales_price())) {
                most_expensive = expensive_car;
            }}
        return most_expensive;
    }

    /**
     * finds manufacturer with most revenue for given type
     * @param type car type (HATCHBACK, SALOON, ESTATE)
     * @return manufacturer with highest revenue for type
     */
    public manufacturer most_rev_type(car_model.car_type type) {
        manufacturer top_manufacturer = null;
        double most_rev = 0;

        for (manufacturer m : manufacturers) {
            double revenue = m.total_revenue_by_type(type);
            if (revenue > most_rev) {
                most_rev = revenue;
                top_manufacturer = m;
            }}
        return top_manufacturer;
    }

    /**
     * gets all models above a given price
     * @param minPrice minimum price threshold
     * @return array of car models above price
     */
    public car_model[] above_price(double minPrice) {
        int count = 0;
        for (manufacturer m : manufacturers) {
            for (car_model model : m.getModels()) {
                if (model.get_sales_price() > minPrice) {
                    count++;
                }}}

        car_model[] expensive_cars = new car_model[count];
        int index = 0;
        for (manufacturer m : manufacturers) {
            for (car_model model : m.getModels()) {
                if (model.get_sales_price() > minPrice) {
                    expensive_cars[index++] = model;
                }}}
        return expensive_cars;
    }

    /**
     * main method to test reporting class
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("reporting.java runs");
    }}
