/**
 * represents car manufacturer with models and revenue tracking
 */
public class manufacturer {
    private final String name;
    private car_model[] models;

    /**
     * constructs manufacturer
     * @param name name of the manufacturer
     * @param models array of car models
     */
    public manufacturer(String name, car_model[] models) {
        this.name = name;
        this.models = models;
    }

    /**
     * gets manufacturer name
     * @return name of manufacturer
     */
    public String getName() {
        return name;
    }

    /**
     * gets car models
     * @return array of car models
     */
    public car_model[] getModels() {
        return models;
    }

    /**
     * set car models for manufacturer
     * @param models array of car models
     */
    public void set_models(car_model[] models) {
        this.models = models;
    }

    /**
     * calc total revenue by car type
     * @param type car type (HATCHBACK, SALOON, ESTATE)
     * @return total revenue for given type
     */
    public double total_revenue_by_type(car_model.car_type type) {
        double total = 0;
        for (car_model model : models) {
            if (model.get_type() == type) {
                total += model.model_revenue();
            }
        }
        return total;
    }

    /**
     * filter models by min price
     * @param minPrice minimum price threshold
     * @return array of models above min price
     */
    public car_model[] filter_models_by_price(double minPrice) {
        int count = 0;
        for (car_model model : models) {
            if (model.get_sales_price() > minPrice) {
                count++;
            }
        }

        car_model[] filtered_models = new car_model[count];
        int index = 0;
        for (car_model model : models) {
            if (model.get_sales_price() > minPrice) {
                filtered_models[index++] = model;
            }
        }
        return filtered_models;
    }

    /**
     * find most expensive car model
     * @return most expensive car model
     */
    public car_model most_expensive_car() {
        if (models.length == 0) {
            return null;
        }

        car_model most_expensive = models[0];
        for (car_model model : models) {
            if (model.get_sales_price() > most_expensive.get_sales_price()) {
                most_expensive = model;
            }
        }
        return most_expensive;
    }

    /**
     * return string details of manufacturer and models
     * @return formatted string of manufacturer details
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Manufacturer: ").append(name);
        sb.append("\nCar Models:\n");
        for (car_model model : models) {
            sb.append(model.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * main method to test manufacturer class
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("manufacturer.java runs");
    }}
