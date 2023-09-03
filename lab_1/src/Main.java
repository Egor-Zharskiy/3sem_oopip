import planes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<Plane> planes = new ArrayList<>();
        ArrayList<Plane> airline = new ArrayList<>();
        planes.add(new Boeing("f", 1, 1));
        planes.add(new Convair("convair", 12, 2000));
        planes.add(new Airbus("airbus", 125, 4200));

        int x;
        boolean flag = true;

        do {
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
                    Airline.totalSeats(planes);
                    break;
                case 4:
                    Airline.TotalLoadCapacity(planes);
                    break;
                case 5:
                    Airline.DeletePlane(airline);
                    break;
                case 6:
                    Menu.PrintList(planes);
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
        } while (flag);

    }
}
