package by.epam.classesLevchuk.classes1BusinesTrip;

public class Runner {

    public static void main(String[] args) {

        // condition 1
        BusinessTrip[] trips =
                {new BusinessTrip("Andy", 1001, 4),
                        new BusinessTrip("Bobby", 1010, 8),
                        null,
                        new BusinessTrip("Lorry", 1011, 3),
                        new BusinessTrip()};

        BusinessTrip maxCostBusinessTrip = trips[0];

        // condition 2
        for (BusinessTrip trip : trips) {
            if (trip != null && trip.getAccount()!=null) {
                trip.show();
                System.out.println();
                if (trip.getTotal() > maxCostBusinessTrip.getTotal()) {
                    maxCostBusinessTrip = trip;
                }
            }
        }

        System.out.println("Max cost trip = " + maxCostBusinessTrip.getPriceInByn(maxCostBusinessTrip.getTotal()) + "\n");

        // condition 3
        trips[trips.length-1].setTransportExpenses(1501);

        // condition 4
        // моя версия: System.out.println("Duration = " + (trips[0].getDays() + trips[1].getDays()) + "\n");
        // подсмотрел:
        System.out.printf("Duration=%d\n", trips[0].getDays()+trips[1].getDays());

        // condition 5
        for (BusinessTrip trip : trips) {
            if (trip != null && trip.getAccount()!=null) {
                System.out.println(trip);
            }
        }
    }
}