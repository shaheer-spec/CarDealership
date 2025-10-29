package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DealershipFileManager {
    public static final String FILE_NAME = "dealership.csv";

    public Dealership getDealership(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));

            String line;
            line = bufferedReader.readLine();
            String[] parts = line.split("\\|");

            Dealership dealership = new Dealership(parts[0], parts[1], parts[2]);

            while ((line = bufferedReader.readLine()) != null){
                String[] vehicleParts = line.split("\\|");
                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String vehicleType = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                double price = Double.parseDouble(vehicleParts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            bufferedReader.close();
            return dealership;

        } catch (Exception ex) {
            System.err.println("Error in getDealership class: " + ex.getMessage());
            return null;
        }

    }

    public void saveDealership(Dealership dealership){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle vehicle1 : dealership.getAllVehicles()) {
                writer.write(vehicle1.getVin() + "|" + vehicle1.getYear() + "|" + vehicle1.getMake()
                + "|" + vehicle1.getModel() + "|" + vehicle1.getVehicleType() + "|" + vehicle1.getColor()
                + "|" + vehicle1.getOdometer() + "|" + vehicle1.getPrice());
                writer.newLine();
            }
            writer.close();

        } catch (Exception ex){
            System.err.println("Error saving the dealership");
        }
    }
}
