


import planes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        FileIO file = new FileIO();

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

        while (flag) {
            Menu.PrintMenu();
            try {
                x = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
                continue;
            }
            switch (x) {
                case 1:
                    file.View();
                    break;
                case 2:
                    file.Write(planes, airline);
                    break;
                case 3:
                    ArrayList<ArrayList<Plane>> lists = file.Read();
                    planes = lists.get(0);
                    airline = lists.get(1);
                    break;
                case 4:
                    Airline.CreatePlane(planes);
                    break;
                case 5:
                    Airline.FillAirline(planes, airline);
                    break;
                case 6:
                    func.calc(airline);
//                    Airline.totalSeats(airline);
                    break;
                case 7:
                    Airline.TotalLoadCapacity(airline);
                    break;
                case 8:
                    Airline.DeletePlane(airline);
                    break;
                case 9:
                    Menu.PrintList(planes);
                    break;
                case 10:
                    Menu.PrintList(airline);
                    break;

                case 11:
                    double averageCapacity = airline.stream()
                            .mapToDouble(Plane::getLoad_capacity)
                            .average()
                            .orElse(0.0);
                    System.out.println("Средняя грузоподъемность самолетов авиакомпании: " + averageCapacity);
                    break;
                case 12:
                    MyThread first_thread = new MyThread(planes);
                    first_thread.start();

                    try {
                        first_thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    Thread second_thread = new Thread(new Runner(planes));
                    second_thread.start();
                    System.out.println();
                    try {
                        second_thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 13:
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        }

    }
}

class MyThread extends Thread {
    private ArrayList<Plane> planes;

    public MyThread(ArrayList<Plane> planes) {

        this.planes = planes;
    }

    public void run() {
        ArrayList<Plane> sort = (ArrayList<Plane>) planes.stream()
                .sorted(Comparator.comparing(Plane::getSeats))
                .collect(Collectors.toList());
        System.out.println("Сортировка по возрастанию");
        sort.forEach(System.out::println);
    }
}

class Runner implements Runnable {
    private ArrayList<Plane> planes;

    public Runner(ArrayList<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public void run() {
        ArrayList<Plane> sort = (ArrayList<Plane>) planes.stream()
                .sorted(Comparator.comparing(Plane::getSeats).reversed())
                .collect(Collectors.toList());
        System.out.println("Сортировка по убыванию:");
        sort.forEach(System.out::println);
    }
}