public class reporting {
    private final manufacturer[] manufacturers; // Stores all manufacturers

    // Constructor
    public reporting(manufacturer[] manufacturers) {
        this.manufacturers = manufacturers;
    }

    // most expensive CarModel between all manufacturers
    public car_model mostExpensiveCarOverall() {
        car_model mostExpensive = null;
        for (manufacturer m : manufacturers) {
            car_model expensiveCar = m.mostExpensiveCar();
            if (mostExpensive == null || (expensiveCar != null && expensiveCar.getSales_price() > mostExpensive.getSales_price())) {
                mostExpensive = expensiveCar;
            }
        }
        return mostExpensive;
    }

    // manufacturer with the highest revenue for given type
    public manufacturer highestRevenueByType(car_model.car_type type) {
        manufacturer topManufacturer = null;
        double highestRevenue = 0;

        for (manufacturer m : manufacturers) {
            double revenue = m.totalRevenueByType(type);
            if (revenue > highestRevenue) {
                highestRevenue = revenue;
                topManufacturer = m;
            }
        }
        return topManufacturer;
    }

    // all CarModels above a given price threshold
    public car_model[] carsAbovePrice(double minPrice) {
        int count = 0;
        for (manufacturer m : manufacturers) {
            for (car_model model : m.getModels()) {
                if (model.getSales_price() > minPrice) {
                    count++;
                }
            }
        }

        car_model[] expensiveCars = new car_model[count];
        int index = 0;
        for (manufacturer m : manufacturers) {
            for (car_model model : m.getModels()) {
                if (model.getSales_price() > minPrice) {
                    expensiveCars[index++] = model;
                }
            }
        }
        return expensiveCars;
    }

    public static void main(String[] args) {
        System.out.println("reporting.java runs");
    }
}
