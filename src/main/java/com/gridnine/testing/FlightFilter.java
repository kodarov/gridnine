package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilter {

    static List<Flight> beforeFiltration(List<Flight> flights) {
        List<Flight> filtFlignts = flights.stream()
                .filter(f -> f.getSegments().stream()
                        .allMatch(s -> s.getDepartureDate().isBefore(LocalDateTime.now()))
                )
                .collect(Collectors.toList());
        return filtFlignts;
    }

    static List<Flight> arrivalBeforeDepartureFiltration(List<Flight> flights) {
        List<Flight> filtFlignts = flights.stream()
                .filter(f -> f.getSegments().stream().
                        allMatch(s -> s.getArrivalDate().isBefore(s.getDepartureDate()))
                )
                .collect(Collectors.toList());
        return filtFlignts;
    }

    /*        static List<Flight> timeOnEarthFiltration(List<Flight> flights, int hours) {
            List<Flight> filtFlignts = flights.stream()
                    .filter(e -> {
                        List<Segment> segments = e.getSegments();
                        for (int i = 0; i <segments.size()-1 ; i++) {
                            LocalDateTime currentArrivalDate = segments.get(i).getArrivalDate();
                            LocalDateTime nextDepartureDate = segments.get(i+1).getDepartureDate();
                            Duration duration = Duration.between(nextDepartureDate,currentArrivalDate);
                            if (duration.toHours()> hours){
                                return true;
                            }
                            return false;
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            return filtFlignts;
        }*/
    static List<Flight> timeOnEarthFiltration(List<Flight> flights, int hours) {
        List<Flight> filtFlignts = flights.stream().
                filter(e -> {
                    List<Segment> segments = e.getSegments();
                    for (int i = 0; i < segments.size() - 1; i++) {
                        LocalDateTime currentArrivalDate = segments.get(i).getArrivalDate();
                        LocalDateTime nextDepartureDate = segments.get(i + 1).getDepartureDate();
                        Duration duration = Duration.between(currentArrivalDate, nextDepartureDate).abs();
                        if (duration.toHours() > hours) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return filtFlignts;
    }
}
