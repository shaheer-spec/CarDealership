package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
        // empty constructor
    }

    private void init(){
        DealershipFileManager dealershipCars = new DealershipFileManager();
        this.dealership = dealershipCars.getDealership();
    }

    public void display(){
        Scanner scanner = new Scanner(System.in);
        init();

        boolean running = true;
        while(running){

            System.out.println(" ");
            System.out.println("╔═════════════════╗");
            System.out.println("║    Dealership   ║");
            System.out.println("╚═════════════════╝");
            System.out.println("1- Find vehicles within a price range");
            System.out.println("2- Find vehicles by make / model");
            System.out.println("3- Find vehicles by year range");
            System.out.println("4- Find vehicles by color");
            System.out.println("5- Find vehicles by mileage range");
            System.out.println("6- Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7- List ALL vehicles");
            System.out.println("8- Add a vehicle");
            System.out.println("9- Remove a vehicle");
            System.out.println("99- Quit");
            System.out.print("Your Input: ");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput){
                case 1 -> processGetByPriceRequest(scanner);
                case 2 -> processGetByMakeModelRequest(scanner);
                case 3 -> processGetByYearRequest(scanner);
                case 4 -> processGetByColorRequest(scanner);
                case 5 -> processGetByMileageRequest(scanner);
                case 6 -> processGetByVehicleTypeRequest(scanner);
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest(scanner);
                case 9 -> processRemoveVehicleRequest(scanner);
                case 99 -> {
                    System.out.println("Goodbye! ");
                    running = false;
                }
                default -> System.out.println("Wrong Input, Try Again");
            }
        }
        System.out.println(" ");
    }

    public void processGetByPriceRequest(Scanner scanner){
        System.out.print("What is the minimum value: ");
        double userMin = scanner.nextDouble();
        System.out.print("What is the maximum value: ");
        double userMax = scanner.nextDouble();

        List<Vehicle> temp = dealership.getVehiclesByPrice(userMin, userMax);
        displayVehicles(temp);
    }

    public void processGetByMakeModelRequest(Scanner scanner){
        System.out.print("What is the make: ");
        String make = scanner.nextLine();
        System.out.print("What is the model: ");
        String model = scanner.nextLine();

        List<Vehicle> temp = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(temp);
    }

    public void processGetByYearRequest(Scanner scanner){
        System.out.print("What is the minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("What is the maximum year: ");
        int maxYear = scanner.nextInt();

        List<Vehicle> temp = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(temp);
    }

    public void processGetByColorRequest(Scanner scanner){
        System.out.print("What is the color: ");
        String color = scanner.nextLine();

        List<Vehicle> temp = dealership.getVehiclesByColor(color);
        displayVehicles(temp);
    }

    public void processGetByMileageRequest(Scanner scanner){
        System.out.print("What is the minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("What is the maximum mileage: ");
        int maxMileage = scanner.nextInt();

        List<Vehicle> temp = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(temp);
    }

    public void processGetByVehicleTypeRequest(Scanner scanner){
        System.out.print("What is the Vehicle Type: ");
        String type = scanner.nextLine();

        List<Vehicle> temp = dealership.getVehiclesByType(type);
        displayVehicles(temp);
    }

    public void processGetAllVehiclesRequest(){
        List<Vehicle> vehicle = dealership.getAllVehicles();
        displayVehicles(vehicle);
    }

    public void processAddVehicleRequest(Scanner scanner){
        System.out.print("What is the vin: ");
        int vin = scanner.nextInt();
        System.out.print("What is the year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What is the make: ");
        String make = scanner.nextLine();
        System.out.print("What is the model: ");
        String model = scanner.nextLine();
        System.out.print("What is the Vehicle Type:");
        String vehicleType = scanner.nextLine();
        System.out.print("What is the Color: ");
        String color = scanner.nextLine();
        System.out.print("What is the odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("What is the Price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle1 = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle1);
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle Added");
    }

    public void processRemoveVehicleRequest(Scanner scanner){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        System.out.print("What is the vin: ");
        int vinRemove = scanner.nextInt();

        for (Vehicle vehicle1 : dealership.getAllVehicles()) {
            if (vinRemove == vehicle1.getVin()){
                dealership.removeVehicle(vehicle1);
                dealershipFileManager.saveDealership(dealership);
                return;
            }
        }
        System.out.println("No vehicle with that vin.");
    }

    private void displayVehicles(List<Vehicle> vehicle){
        System.out.println(" ");
        System.out.println("╔═══════════╗");
        System.out.println("║    Cars   ║");
        System.out.println("╚═══════════╝");
        for (Vehicle vehicle1 : vehicle) {
            System.out.println(vehicle1.getYear() + " " + vehicle1.getMake() + " " + vehicle1.getModel() + " (" + vehicle1.getColor() + ") - $" + vehicle1.getPrice() + " - " + vehicle1.getOdometer() + " miles");
        }
    }
}
