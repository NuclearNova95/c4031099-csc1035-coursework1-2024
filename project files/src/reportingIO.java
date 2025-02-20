import java.util.Scanner;

/**
 * handles user input and reporting system for manufacturers and car models
 */
public class reportingIO {
    private static manufacturer[] manufacturers = new manufacturer[10]; // store up to 10 manufacturers
    private static int manufacturerCount = 0; // track how many have been added

    /**
     * main method to run reporting system
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nCar Investor System");
            System.out.println("1. Enter Manufacturer Data");
            System.out.println("2. View Manufacturers");
            System.out.println("3. View Most Expensive Car");
            System.out.println("4. View Total Revenue by Car Type");
            System.out.println("5. View Cars Above a Given Price");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> enter_data(scanner);
                case 2 -> view_all();
                case 3 -> view_most_expensive();
                case 4 -> view_type_rev(scanner);
                case 5 -> view_above_price(scanner);
                case 6 -> {
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }}
        scanner.close();
    }

    /**
     * enter manufacturer and car data
     * @param scanner scanner object for user input
     */
    private static void enter_data(Scanner scanner) {
        if (manufacturerCount >= manufacturers.length) {
            System.out.println("Maximum number of manufacturers reached.");
            return;
        }

        System.out.print("\nEnter Manufacturer Name: ");
        String name = scanner.nextLine();

        System.out.print("How many car models does this manufacturer have? ");
        int numModels = scanner.nextInt();
        scanner.nextLine();

        car_model[] models = new car_model[numModels];

        for (int i = 0; i < numModels; i++) {
            System.out.println("\nEnter details for Car Model #" + (i + 1) + ":");

            System.out.print("Name: ");
            String modelName = scanner.nextLine();

            System.out.print("Weight (500-3000 kg): ");
            double weight = scanner.nextDouble();

            System.out.print("Sales Price (£): ");
            double salesPrice = scanner.nextDouble();

            System.out.print("Number Sold: ");
            int numberSold = scanner.nextInt();

            System.out.println("Choose Car Type (1: Hatchback, 2: Saloon, 3: Estate): ");
            int typeChoice = scanner.nextInt();
            scanner.nextLine();

            car_model.car_type type;
            switch (typeChoice) {
                case 1 -> type = car_model.car_type.HATCHBACK;
                case 2 -> type = car_model.car_type.SALOON;
                case 3 -> type = car_model.car_type.ESTATE;
                default -> {
                    System.out.println("Invalid type, defaulting to HATCHBACK.");
                    type = car_model.car_type.HATCHBACK;
                }}

            // create car
            models[i] = new car_model(modelName, weight, salesPrice, numberSold, type);
        }

        // create manufacturer
        manufacturers[manufacturerCount++] = new manufacturer(name, models);
        System.out.println("\nManufacturer and car models added successfully!");
    }

    /**
     * view all manufacturers
     */
    private static void view_all() {
        if (manufacturerCount == 0) {
            System.out.println("\nNo manufacturers available.");
            return;
        }

        System.out.println("\n===== List of Manufacturers =====");
        for (int i = 0; i < manufacturerCount; i++) {
            System.out.println(manufacturers[i]);
        }}

    /**
     * view most expensive car across all manufacturers
     */
    private static void view_most_expensive() {
        if (manufacturerCount == 0) {
            System.out.println("\nNo manufacturers available.");
            return;
        }

        reporting report = new reporting(manufacturers);
        car_model mostExpensive = report.most_expensive_car();

        if (mostExpensive != null) {
            System.out.println("\nMost Expensive Car:");
            System.out.println(mostExpensive);
        }
        else {
            System.out.println("\nNo car models available.");
        }}

    /**
     * view total revenue by car type
     * @param scanner scanner object for user input
     */
    private static void view_type_rev(Scanner scanner) {
        if (manufacturerCount == 0) {
            System.out.println("\nNo manufacturers available.");
            return;
        }

        System.out.println("\nChoose Car Type (1: Hatchback, 2: Saloon, 3: Estate): ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        car_model.car_type type;
        switch (typeChoice) {
            case 1 -> type = car_model.car_type.HATCHBACK;
            case 2 -> type = car_model.car_type.SALOON;
            case 3 -> type = car_model.car_type.ESTATE;
            default -> {
                System.out.println("Invalid choice. Defaulting to HATCHBACK.");
                type = car_model.car_type.HATCHBACK;
            }}

        reporting report = new reporting(manufacturers);
        manufacturer topManufacturer = report.most_rev_type(type);

        if (topManufacturer != null) {
            System.out.println("\nManufacturer with highest revenue for " + type + ": " + topManufacturer.getName());
            System.out.println("Revenue: £" + topManufacturer.total_revenue_by_type(type));
        }
        else {
            System.out.println("\nNo revenue found for that car type.");
        }}

    /**
     * view cars above given price
     * @param scanner scanner object for user input
     */
    private static void view_above_price(Scanner scanner) {
        if (manufacturerCount == 0) {
            System.out.println("\nNo manufacturers available.");
            return;
        }

        System.out.print("\nEnter the minimum price (£): ");
        double minPrice = scanner.nextDouble();
        scanner.nextLine();

        reporting report = new reporting(manufacturers);
        car_model[] expensiveCars = report.above_price(minPrice);

        if (expensiveCars.length > 0) {
            System.out.println("\nCars priced above £" + minPrice + ":");
            for (car_model model : expensiveCars) {
                System.out.println(model);
            }}
        else {
            System.out.println("\nNo cars found above that price.");
        }}}