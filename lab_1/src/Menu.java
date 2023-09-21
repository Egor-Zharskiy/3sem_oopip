import planes.Plane;

import java.util.ArrayList;

public class Menu {
    public static void PrintMenu() {
        System.out.println(
                "\n---------------------\n" +
                        "Меню:\n" +
                        "______________________\n" +
                        "1 - посмотреть данные\n" +
                        "2 - сохранить данные\n" +
                        "3 - загрузить данные\n" +
                        "_____________________" +
                        "\nМеню:\n4 - создать самолёт;\t5 - добавить самолет в авиакомпанию;" + // +
                        "\n6 - посчитать общую вместимость всех самолётов;\t" + // -
                        "7 - посчитать общую грузоподъёмность\n" + // -
                        "8 - удалить самолёт из авиакомпании;\n" + // +
                        "9 - вывод всех самолётов;\t" + // +
                        "10 - вывод самолётов авиакомпании;" + "\n" + // +
                        "11 - Выход\n---------------------\n");
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
