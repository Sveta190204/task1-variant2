import java.util.Random;
import java.util.Scanner;

public class NonpositiveElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continueProgram;

        do {
            System.out.println("Введите количество строк массива: ");
            int rows = getPositiveInteger(scanner);
            System.out.println("Введите количество столбцов массива: ");
            int cols = getPositiveInteger(scanner);

            // Создание и заполнение двумерного массива
            int[][] array = new int[rows][cols];
            fillArrayWithRandomValues(array, random);

            // Вывод двумерного массива
            System.out.println("Сгенерированный массив:");
            printArray(array);

            // Запрос числа у пользователя
            System.out.println("Введите число для проверки условия: ");
            int specifiedDifference = scanner.nextInt();

            // Поиск неположительных элементов с учетом условия
            int count = 0;
            System.out.printf("Неположительные элементы и их положения (модуль разности индексов < %d):%n", specifiedDifference);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (array[i][j] <= 0 && Math.abs(i - j) < specifiedDifference) {
                        System.out.printf("Элемент: %3d, Положение: [%d, %d]%n", array[i][j], i, j);
                        count++;
                    }
                }
            }

            // Вывод результата
            System.out.printf("Количество неположительных элементов с модулем разности индексов меньше %d: %d%n", specifiedDifference, count);

            // Запрос на продолжение работы программы
            System.out.println("Хотите продолжить? (да/нет)");
            String response = scanner.next();
            continueProgram = response.equalsIgnoreCase("да");
        } while (continueProgram); // Цикл продолжает работу, пока пользователь отвечает "да"

        scanner.close();
        System.out.println("Завершение работы программы.");
    }

    // Метод для заполнения массива случайными значениями в диапазоне [-50, 50]
    private static void fillArrayWithRandomValues(int[][] array, Random random) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(101) - 50; // Генерация значения от -50 до 50
            }
        }
    }

    // Метод для вывода двумерного массива
    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println();
        }
    }

    // Метод для получения положительного целого числа
    private static int getPositiveInteger(Scanner scanner) {
        int number;
        while (true) {
            number = scanner.nextInt();
            if (number > 0) {
                break;
            } else {
                System.out.println("Введите положительное число. Попробуйте еще раз:");
            }
        }
        return number;
    }
}