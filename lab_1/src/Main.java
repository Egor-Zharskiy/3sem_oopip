import planes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<Plane> planes = new ArrayList<>();
        ArrayList<Plane> airline = new ArrayList<>();
        planes.add(new Boeing("f", 100, 100));
        planes.add(new Convair("convair", 12, 2000));
        planes.add(new Airbus("airbus", 125, 4200));

        Function func = (airline_planes) -> {
            if (airline_planes.isEmpty()) {
                System.out.println("в авиакомпанию еще не были добавлены самолеты");
                return;
            }
            int total_seats = 0;
            for (Plane pl : airline_planes)
                total_seats += pl.getSeats();

            System.out.println("Суммарная вместимость самолетов авиакомпании: " + total_seats + " мест");

        };


        int x;
        boolean flag = true;

        while(flag) {
            Menu.PrintMenu();
            try {
                x = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
                continue;
            }
            switch (x) {
                case 1:
                    Airline.CreatePlane(planes);
                    break;
                case 2:
                    Airline.FillAirline(planes, airline);
                    break;
                case 3:
                    func.calc(airline);
//                    Airline.totalSeats(airline);
                    break;
                case 4:
                    Airline.TotalLoadCapacity(airline);
                    break;
                case 5:
                    Airline.DeletePlane(airline);
                    break;
                case 6:
                    planes.forEach(name -> System.out.println((planes.indexOf(name) + 1) + " - " + name));
//                    Menu.PrintList(planes);
                    break;
                case 7:
                    Menu.PrintList(airline);
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        }

    }
}
