import java.util.Random;
import java.util.Scanner;
class HomeWork3 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n" + " ");
            System.out.println("Выберите номер задания");
            System.out.println("1: метод, принимающий в качестве аргументов целое число и строку,\n и печатающий консоль строку указанное количество раз");
            System.out.println("2: метод, принимающий в качестве аргумента целочисленный массив, \n суммирующий все элементы, значение которых больше 5, и печатающий полученную сумму в консоль");
            System.out.println("3: метод, принимающий в качестве аргументов целое число и ссылку \n на целочисленный массив, метод должен заполнить каждую ячейку массива указанным числом");
            System.out.println("4: метод, принимающий в качестве аргумент целое число и ссылку \n на целочисленный массив, увеличивающий каждый элемент массива на указанное число;");
            System.out.println("5: метод, принимающий в качестве аргумента целочисленный массив, \n и печатающий в\n консоль информацию о том, сумма элементов какой из половин массива больше");

            if (scanner.hasNextInt()) {
                int ch = scanner.nextInt();
                scanner.nextLine(); // Считываем новую строку
                int[] array = null; // Объявляем массив вне switch

                switch (ch) {
                    case 1:
                        exNumberOne(scanner);
                        break;
                    case 2:
                        exNumberTwo(scanner);
                        break;
                    case 3:
                        array = exNumberThree(scanner); // Получаем массив из exNumberThree
                        break;
                    case 4:
                        int[] arrayFromFour = exNumberThree(scanner); // Получаем массив из exNumberThree
                        exNumberFour(scanner, arrayFromFour); // Передаем массив в exNumberFour
                        break;
                    case 5:
                        array = exNumberThree(scanner); // Получаем массив для exNumberFive
                        exNumberFive(array); // Передаем массив в exNumberFive
                        break;
                    default:
                        System.out.println("Неверный номер задания. Попробуйте снова.");
                        break;
                }
            } else {
                System.out.println("Введите корректное число.");
                scanner.next(); // Пропускаем некорректный ввод
            }
        }
    }

    public static void exNumberOne(Scanner scanner) {
        System.out.println("Напишите фразу");
        String a = scanner.nextLine();
        System.out.println("Напишите натуральное число\n" + "На которое вы хотите умножить фразу");
        int b = scanner.nextInt();
        for (int c = 0; c < b; c++) { // Изменил c <= b на c < b
            System.out.println(a);
        }
    }

    public static void exNumberTwo(Scanner scanner) {
        System.out.println("Введите размер одномерного массива");
        int m = scanner.nextInt();
        int[] array = new int[m];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt(); // Считываем элементы массива
        }
        int sum = 0;
        for (int i : array) { // Используем enhanced for
            if (i > 5) { // Проверяем значение элемента массива
                sum += i; // Суммируем элементы больше 5
            }
        }
        System.out.println("Сумма элементов больше 5: " + sum);
    }

    public static int[] exNumberThree(Scanner scanner) {
        System.out.println("Введите целое число для указания размера массива:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Выберите:\n" + "1: Ввести числа для ячеек\n" + "2: Взять числа наугад для ячеек");
        int input = scanner.nextInt();
        if (input == 1) {
            // Запрашиваем значения для каждой ячейки массива
            for (int i = 0; i < n; i++) {
                System.out.println("Введите число для ячейки " + (i + 1) + ":");
                array[i] = scanner.nextInt(); // Считываем значение для каждой ячейки
            }
        } else {
            Random random = new Random(); // Создаем объект Random

            // Заполняем массив случайными числами от 1 до 100
            for (int i = 0; i < n; i++) {
                array[i] = random.nextInt(100) + 1; // Случайное число от 1 до 100
            }
        }

        // Выводим заполненный массив
        System.out.println("Заполненный массив:");
        printArray(array); // Вызов метода вывода массива
        return array; // Возвращаем заполненный массив
    }

    public static void exNumberFour(Scanner scanner, int[] array) {
        System.out.println("Введите число, на которое хотите увеличить каждый элемент:");
        int incrementValue = scanner.nextInt(); // Число, на которое увеличиваем каждый элемент

        System.out.println("Исходный массив:");
        printArray(array); // Выводим массив до изменения

        increaseArrayElements(array, incrementValue); // Увеличиваем элементы

        System.out.println("Массив после увеличения:");
        printArray(array); // Выводим массив после изменения
    }

    // Метод, увеличивающий каждый элемент массива на указанное число
    public static void increaseArrayElements(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] += value; // Увеличиваем каждый элемент на указанное число
        }
    }

    // Вспомогательный метод для вывода массива
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(); // Для новой строки после вывода массива
    }

    public static void exNumberFive(int[] array) {
        int mid = array.length / 2; // Находим середину массива
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;

        // Считаем сумму первой половины
        for (int i = 0; i < mid; i++) {
            sumFirstHalf += array[i];
        }
        System.out.println(sumFirstHalf);
        // Считаем сумму второй половины
        for (int i = array.length - 1; i >= array.length - mid; i--) {
            sumSecondHalf += array[i];
        }
        System.out.println(sumSecondHalf);

        // Сравниваем суммы
        if (sumFirstHalf > sumSecondHalf) {
            System.out.println("Сумма первой половины массива больше: " + sumFirstHalf);
        } else if (sumSecondHalf > sumFirstHalf) {
            System.out.println("Сумма второй половины массива больше: " + sumSecondHalf);
        } else {
            System.out.println("Суммы обеих половин равны: " + sumFirstHalf);
        }
    }
}