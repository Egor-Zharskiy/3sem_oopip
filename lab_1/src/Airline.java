import planes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
    public static void FillAirline(ArrayList<Plane> planes, ArrayList<Plane> airline) {
        System.out.println("Выберите самолет, который вы хотите добавить в авиакомпанию");
        int choice = 0, size = planes.size();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);


        System.out.println("0 - выход из добавления самолетов");

        try {
            Menu.PrintList(planes);
            choice = Integer.parseInt(scanner.nextLine());

            airline.add(planes.get(choice - 1));
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неверный индекс элемента");
        }

    }

    public static void DeletePlane(ArrayList<Plane> list) {
        Scanner scanner = new Scanner(System.in);
        int x;

        try {
            if (list.isEmpty()) {
                throw new ZeroLength();
            }
        } catch (ZeroLength e) {
            System.out.println("Список пуст");
            return;
        }

        Menu.PrintList(list);

        System.out.println("Введите номер самолёта для удаления");

        try {
            x = Integer.parseInt(scanner.nextLine());
            list.remove(x - 1);
            System.out.println("Удалено");
            System.out.println("Список самолетов после удаления:");
            Menu.PrintList(list);

        } catch (NumberFormatException e) {
            System.out.println("Значение введено некорректно");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Введенный номер не соответствует ни одному из индексов списка");

        }

    }


    public static void input(Plane plane, String name, int seats, float load_capacity, ArrayList<Plane> planes) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название самолета");

            name = scanner.nextLine();

            try {
                System.out.println("Введите вместимость самолета");
                seats = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите грузоподъемность самолета");
                load_capacity = Float.parseFloat(scanner.nextLine());
                if (seats < 0 || load_capacity < 0) throw new NegativeValue();
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
                continue;
            } catch (NegativeValue e) {
                System.out.println("Введены отрицательные значения");
                continue;
            }


            plane.setName(name);
            plane.setSeats(seats);
            plane.setLoad_capacity(load_capacity);
            planes.add(plane);
            return;
        }
    }


    public static void CreatePlane(ArrayList<Plane> planes) {
        System.out.println("Выберите тип самолета для создания\n1 - Airbus\n2 - Boeing\n3 - Convair");
        Scanner scanner = new Scanner(System.in);

        String name = "";
        int seats = 0, key;
        float load_cap = 0f;

        key = scanner.nextInt();


        switch (key) {
            case 1:
                Airbus pl = new Airbus("", 0, 0f);
                input(pl, name, seats, load_cap, planes);
                break;
            case 2:
                Boeing bg = new Boeing("", 0, 0f);
                input(bg, name, seats, load_cap, planes);
                break;
            case 3:
                Convair cv = new Convair("", 0, 0f);
                input(cv, name, seats, load_cap, planes);
                break;
            default:
                System.out.println("Неверный выбор");

        }
    }


    public static void totalSeats(ArrayList<Plane> planes) {
        if (planes.isEmpty()) {
            System.out.println("в авиакомпанию еще не были добавлены самолеты");
            return;
        }
        int total_seats = 0;
        for (Plane pl : planes)
            total_seats += pl.getSeats();

        System.out.println("Суммарная вместимость самолетов авиакомпании: " + total_seats + " мест");
    }


    public static void TotalLoadCapacity(ArrayList<Plane> planes) {
        if (planes.isEmpty()) {
            System.out.println("в авиакомпанию еще не были добавлены самолеты");
            return;
        }
        float total_load = 0f;
        for (Plane pl : planes) {
            total_load += pl.getLoad_capacity();
        }

        System.out.println("Общая грузоподъемность самолетов авиакомпании: " + total_load + "кг");

    }
}
