package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {

        System.out.println(FlightBuilder.createFlights());
        FlightBuilder.createFlights();
        System.out.println("----------------------");
        System.out.println(FlightFilter.beforeFiltration(FlightBuilder.createFlights()));
        System.out.println("----------------------");
        System.out.println(FlightFilter.arrivalBeforeDepartureFiltration(FlightBuilder.createFlights()));
        System.out.println("----------------------");
        System.out.println(FlightFilter.timeOnEarthFiltration(FlightBuilder.createFlights(), 2));
        FlightFilter.timeOnEarthFiltration(FlightBuilder.createFlights(),2);
    }
}
