import planes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        FileIO file = new FileIO();

        ArrayList<Plane> planes = new ArrayList<>();
        ArrayList<Plane> airline = new ArrayList<>();
        planes.add(new Boeing("f", 100, 100));
        planes.add(new Convair("convair", 12, 2000));
        planes.add(new Airbus("airbus", 125, 4200));


        MyThread first_thread = new MyThread(planes);
        first_thread.start();


        Thread second_thread = new Thread(new Runner(planes));
        second_thread.start();


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
        int n = this.planes.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (this.planes.get(i - 1).getLoad_capacity() > this.planes.get(i).getLoad_capacity()) {
                    Plane temp = this.planes.get(i - 1);
                    this.planes.set(i - 1, this.planes.get(i));
                    this.planes.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);

        System.out.print("\nОтсортированный по возрастанию массив по load_capacity: " + planes);


    }
}

class Runner implements Runnable {
    private ArrayList<Plane> planes;

    public Runner(ArrayList<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public void run() {


        int n = this.planes.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (this.planes.get(i - 1).getLoad_capacity() < this.planes.get(i).getLoad_capacity()) {
                    Plane temp = this.planes.get(i - 1);
                    this.planes.set(i - 1, this.planes.get(i));
                    this.planes.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);


        System.out.print("\nОтсортированный по убыванию массив по load_capacity: " + planes);

    }
}