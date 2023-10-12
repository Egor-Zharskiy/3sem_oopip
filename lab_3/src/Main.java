// 7.	a=8, b - возрастание, c – кратные 3;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < 8; i++) {
                int num = random.nextInt(20) - 3;
                numbers.add(num);
            }

            System.out.println("Исходный массив: " + numbers);

            List<Integer> sortedNumbers = numbers.stream()
                    .sorted()
                    .toList();

            System.out.println("Отсортированный массив: " + sortedNumbers);

            List<Integer> filteredNumbers = sortedNumbers.stream()
                    .filter(num -> num % 3 != 0)
                    .toList();

            System.out.println("Отфильтрованный массив: " + filteredNumbers);

            String[] stringArray = filteredNumbers.stream()
                    .map(Object::toString)
                    .toArray(String[]::new);

            System.out.println("String массив: " + Arrays.toString(stringArray));
        }
    }