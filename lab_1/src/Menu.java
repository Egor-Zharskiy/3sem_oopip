import planes.Plane;

import java.util.ArrayList;

public class Menu {
    public static void PrintMenu() {
        System.out.println("\n---------------------\nМеню:\n1 - создать самолёт;\t2 - добавить самолет в авиакомпанию;" + // +
                "\n3 - посчитать общую вместимость всех самолётов;\t" + // -
                "4 - посчитать общую грузоподъёмность\n" + // -
                "5 - удалить самолёт из авиакомпании;\n" + // +
                "6 - вывод всех самолётов;\t" + // +
                "7 - вывод самолётов авиакомпании;\\n\" +\n" + // +
                "8 - Выход\n---------------------\n");
    }

    public static void PrintList(ArrayList<Plane> list) {
        int i = 0;
        if (list.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }

        for (Plane pl : list) {
            i++;
            System.out.println(i + " - " + pl);
        }
    }


}
