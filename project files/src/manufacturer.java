public class manufacturer {
    private String name;
    private car_model[] models;

    // Constructor
    public manufacturer(String name, car_model[] models) {
        this.name = name;
        this.models = models;
    }

    // Getters
    public String getName() {
        return name;
    }

    public car_model[] getModels() {
        return models;
    }

    // Setters
    public void setModels(car_model[] models) {
        this.models = models;
    }

    //method to return total revenue of type
    public double totalRevenueByType(car_model.car_type type) {
        double total = 0;
        for (car_model model : models) {
            if (model.getType() == type) {
                total += model.model_revenue();
            }
        }
        return total;
    }

    //method to return all models with price greater than value
    public car_model[] filterModelsByPrice(double minPrice) {
        int count = 0;
        for (car_model model : models) {
            if (model.getSales_price() > minPrice) {
                count++;
            }
        }

        car_model[] filteredModels = new car_model[count];
        int index = 0;
        for (car_model model : models) {
            if (model.getSales_price() > minPrice) {
                filteredModels[index++] = model;
            }
        }
        return filteredModels;
    }

    //method to find most expensive car
    public car_model mostExpensiveCar() {
        if (models.length == 0) {
            return null;
        }

        car_model mostExpensive = models[0];
        for (car_model model : models) {
            if (model.getSales_price() > mostExpensive.getSales_price()) {
                mostExpensive = model;
            }
        }
        return mostExpensive;
    }

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

    public static void main(String[] args) {
        System.out.println("manufacturer.java runs");
    }
}
