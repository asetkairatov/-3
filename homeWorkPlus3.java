import java.util.Scanner; // Импортируем класс Scanner для ввода
public class homeWorkPlus3 {
    public static void main(String[] args) {
        run(); // Запуск программы
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите задание");
            System.out.println("1: метод, принимающий на вход набор целочисленных массивов, и получающий новый\n" +
                    "массив равный сумме входящих");
            System.out.println("2: метод, проверяющий, что есть “точка” в массиве, в которой сумма левой и правой части\n" +
                    "равны. “Точка находится между элементами”");
            System.out.println("3: метод, проверяющий, что все элементы массива идут в порядке убывания или\n" +
                    "возрастания (по выбору пользователя)");
            System.out.println("4: метод, “переворачивающий” входящий массив");

            if (scanner.hasNextInt()) {
                int ch = scanner.nextInt();
                scanner.nextLine(); // Считываем новую строку
                switch (ch) {
                    case 1:
                        metodOne(scanner);
                        break;
                    case 2:
                        metodTwo(scanner);
                        break;
                    case 3:
                        metodThree(scanner);
                        break;
                    case 4:
                        metodFour(scanner); // Вызов метода переворота массива
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

    public static void metodOne(Scanner scanner) {
        System.out.println("Введите количество массивов:");
        int numberOfArrays = scanner.nextInt();
        int[][] arrays = new int[numberOfArrays][]; // Инициализируем массив массивов
        System.out.println("Хотите выбрать размер?\n1: да\n2: пусть будет рандом");
        int input = scanner.nextInt();

        if (input == 1) {
            for (int i = 0; i < numberOfArrays; i++) {
                System.out.println("Введите размер массива " + (i + 1) + ":");
                int size = scanner.nextInt();
                arrays[i] = new int[size];
                System.out.println("Введите элементы массива " + (i + 1) + ":");
                for (int j = 0; j < size; j++) {
                    arrays[i][j] = scanner.nextInt(); // Заполняем массив
                }
            }
        } else if (input == 2) {
            for (int i = 0; i < numberOfArrays; i++) {
                int size = (int) (Math.random() * 6) + 1; // Размер от 1 до 6
                arrays[i] = new int[size];
                System.out.println("Элементы массива " + (i + 1) + ":");
                for (int j = 0; j < size; j++) {
                    arrays[i][j] = (int) (Math.random() * 100); // Случайные числа от 0 до 99
                    System.out.print(arrays[i][j] + " "); // Вывод случайных элементов массива
                }
                System.out.println(); // Для новой строки после вывода массива
            }
        } else {
            System.out.println("Неверный ввод, попробуйте снова.");
            return; // Завершаем метод при неверном вводе
        }

        int[] resultArray = sumArrays(arrays);
        System.out.println("Результирующий массив:");
        printArray(resultArray);
    }

    public static int[] sumArrays(int[][] arrays) {
        // Находим максимальную длину массива
        int maxLength = 0;
        for (int[] array : arrays) {
            if (array.length > maxLength) {
                maxLength = array.length;
            }
        }

        int[] resultArray = new int[maxLength];

        // Суммируем соответствующие элементы
        for (int[] array : arrays) {
            for (int i = 0; i < array.length; i++) {
                resultArray[i] += array[i]; // Суммируем значения
            }
        }

        return resultArray; // Возвращаем результирующий массив
    }

    // Метод для вывода одномерного массива
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println(); // Для новой строки после вывода массива
    }

    public static void metodTwo(Scanner scanner) {
        System.out.println("Хотите задать размер и элементы массива вручную или сгенерировать случайные числа?");
        System.out.println("1: Ввод вручную");
        System.out.println("2: Генерация случайных чисел");

        int choice = scanner.nextInt();
        int[] array;

        if (choice == 1) {
            System.out.println("Введите размер массива:");
            int size = scanner.nextInt();
            array = new int[size];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt(); // Заполняем массив
            }
        } else if (choice == 2) {
            int size = (int) (Math.random() * 6) + 1; // Размер от 1 до 6
            array = new int[size];
            System.out.println("Сгенерированные элементы массива:");
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * 11); // Случайные числа от 0 до 10
                System.out.print(array[i] + " "); // Выводим сгенерированные элементы
            }
            System.out.println(); // Для новой строки после вывода массива
        } else {
            System.out.println("Неверный ввод, попробуйте снова.");
            return; // Завершаем метод при неверном вводе
        }

        // Проверяем, есть ли точка равенства
        if (hasEqualSumPoint(array)) {
            System.out.println("Существует точка, где сумма левой и правой частей равны.");
        } else {
            System.out.println("Такой точки не существует.");
        }
    }

    public static boolean hasEqualSumPoint(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int leftSum = 0;
            int rightSum = 0;

            // Считаем сумму элементов слева
            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }

            // Считаем сумму элементов справа
            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }

            // Сравниваем суммы
            if (leftSum == rightSum) {
                return true; // Найдена точка
            }
        }
        return false; // Точка не найдена
    }

    public static void metodThree(Scanner scanner) {
        System.out.println("Хотите задать размер и элементы массива вручную или сгенерировать случайные числа?");
        System.out.println("1: Ввод вручную");
        System.out.println("2: Генерация случайных чисел");

        int choice = scanner.nextInt();
        int[] array;

        if (choice == 1) {
            System.out.println("Введите размер массива:");
            int size = scanner.nextInt();
            array = new int[size];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt(); // Заполняем массив
            }
        } else if (choice == 2) {
            int size = (int) (Math.random() * 6) + 1; // Размер от 1 до 6
            array = new int[size];
            System.out.println("Сгенерированные элементы массива:");
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * 11); // Случайные числа от 0 до 10
                System.out.print(array[i] + " "); // Выводим сгенерированные элементы
            }
            System.out.println(); // Для новой строки после вывода массива
        } else {
            System.out.println("Неверный ввод, попробуйте снова.");
            return; // Завершаем метод при неверном вводе
        }

        System.out.println("Выберите порядок проверки:");
        System.out.println("1: Возрастание");
        System.out.println("2: Убывание");
        int orderChoice = scanner.nextInt();

        boolean isOrdered = false;

        if (orderChoice == 1) {
            isOrdered = isAscending(array);
        } else if (orderChoice == 2) {
            isOrdered = isDescending(array);
        } else {
            System.out.println("Неверный ввод, попробуйте снова.");
            return; // Завершаем метод при неверном вводе
        }

        // Вывод результата проверки
        if (isOrdered) {
            System.out.println("Массив отсортирован в выбранном порядке.");
        } else {
            System.out.println("Массив не отсортирован в выбранном порядке.");
        }
    }

    public static boolean isAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false; // Найдено нарушение порядка
            }
        }
        return true; // Массив отсортирован
    }

    public static boolean isDescending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false; // Найдено нарушение порядка
            }
        }
        return true; // Массив отсортирован
    }

    public static void metodFour(Scanner scanner) {
        System.out.println("Хотите задать размер и элементы массива вручную или сгенерировать случайные числа?");
        System.out.println("1: Ввод вручную");
        System.out.println("2: Генерация случайных чисел");

        int choice = scanner.nextInt();
        int[] array;

        if (choice == 1) {
            System.out.println("Введите размер массива:");
            int size = scanner.nextInt();
            array = new int[size];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt(); // Заполняем массив
            }
        } else if (choice == 2) {
            int size = (int) (Math.random() * 6) + 1; // Размер от 1 до 6
            array = new int[size];
            System.out.println("Сгенерированные элементы массива:");
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * 11); // Случайные числа от 0 до 10
                System.out.print(array[i] + " "); // Выводим сгенерированные элементы
            }
            System.out.println(); // Для новой строки после вывода массива
        } else {
            System.out.println("Неверный ввод, попробуйте снова.");
            return; // Завершаем метод при неверном вводе
        }

        int[] reversedArray = reverseArray(array); // Переворачиваем массив
        System.out.println("Перевернутый массив:");
        printArray(reversedArray); // Выводим перевернутый массив
    }

    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i]; // Переворот массива
        }
        return reversed; // Возвращаем перевернутый массив
    }
}