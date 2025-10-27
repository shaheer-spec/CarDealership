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

            System.out.println("Dealership: ");
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

            int userInput = scanner.nextInt();

            switch (userInput){
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> running = false;
                default -> System.out.println("Wrong Input, Try Again");
            }
        }
        System.out.println(" ");
    }

    public void processGetByPriceRequest(){}

    public void processGetByMakeModelRequest(){}

    public void processGetByYearRequest(){}

    public void processGetByColorRequest(){}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest(){}

    public void processAllVehiclesRequest(){
        List<Vehicle> vehicle = dealership.getAllVehicles();
        displayVehicles(vehicle);
    }

    public void processAddVehicleRequest(){}

    public void processRemoveVehicleRequest(){}

    private void displayVehicles(List<Vehicle> vehicle){
        for (Vehicle vehicle1 : vehicle) {
            System.out.println(vehicle1.getYear() + " " + vehicle1.getMake() + " " + vehicle1.getModel() + " (" + vehicle1.getColor() + ") - " + vehicle1.getPrice() + " - " + vehicle1.getOdometer() + " miles");
        }
    }
}
