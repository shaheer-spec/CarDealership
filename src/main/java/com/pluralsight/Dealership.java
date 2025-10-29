package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private final ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    //------------------------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
//----------------------------------------------------------------

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> temp = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                temp.add(vehicle);
            }
        }
        return temp;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> temp = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                temp.add(vehicle);
            }
        }
        return temp;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> temp = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                temp.add(vehicle);
            }
        }
        return temp;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> temp = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)){
                temp.add(vehicle);
            }
        }
        return temp;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> temp = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                temp.add(vehicle);
            }
        }
        return temp;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> temp = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                temp.add(vehicle);
            }
        }
        return temp;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

}
