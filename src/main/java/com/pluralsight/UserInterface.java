package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    private UserInterface() {
        // empty constructor
    }

    private void init(){
        DealershipFileManager dealershipCars = new DealershipFileManager();
        this.dealership = dealershipCars.getDealership();
    }

    public void display(){
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while(running){

            System.out.println("Dealership: ");
            System.out.println("1- ");
            System.out.println("2- ");
            System.out.println("3- ");
            System.out.println("4- ");
            System.out.println("5- ");
            System.out.println("6- ");
            System.out.println("7- ");
            System.out.println("8- ");
            System.out.println("9- ");
            System.out.println("99- ");
        }
    }

    public void processGetByPriceRequest(){}

    public void processGetByMakeModelRequest(){}

    public void processGetByYearRequest(){}

    public void processGetByColorRequest(){}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest(){}

    public void processGetAllVehicleRequest(){}

    public void processAddVehicleRequest(){}

    public void processRemoveVehicleRequest(){}


}
