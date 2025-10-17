import java.util.Scanner;
import java.util.Random;

public class lab1 {
    private Scanner scanner = new Scanner(System.in);

    // ========== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ==========

    private int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    private void arrPrint(int[] arr) {
        System.out.print("массив: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // ========== МЕТОДЫ РЕШЕНИЯ ЗАДАЧ ==========

    // Zad1_1
    private double fraction(double x) {
        return (x - (int)x);
    }

    // Zad1_2
    private int sumLastNums(int x) {
        return (Math.abs(x) % 10) + ((Math.abs(x) % 100) / 10);
    }

    // Zad1_6
    private boolean isUpperCase(char x) {
        return (x >= 'A' && x <= 'Z');
    }

    // Zad1_7
    private boolean isInRange(int a, int b, int num) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return (num >= min) && (num <= max);
    }

    // Zad1_10
    private int lastNumSum(int a, int b) {
        while (a >= 10) {
            a = Math.abs(a) / 10;
        }
        return a + Math.abs(b) % 10;
    }

    // Zad2_1
    private int abs(int x) {
        if (x > 0) {
            return x;
        } else {
            return x * -1;
        }
    }

    // Zad2_4
    private String makeDecision(int x, int y) {
        String a = String.valueOf(x);
        String b = String.valueOf(y);
        if (x > y) {
            return a + ">" + b;
        } else if (x == y) {
            return a + "=" + b;
        } else {
            return a + "<" + b;
        }
    }

    // Zad2_5
    private int max3(int x, int y, int z) {
        if (x >= y && x >= z) return x;
        if (y >= z) return y;
        return z;
    }

    // Zad2_8
    private String age(int x) {
        String a = String.valueOf(x);
        if (x % 10 == 1 && x != 11) {
            return a + " год";
        } else if ((x % 10 == 2 || x % 10 == 3 || x % 10 == 4) && (x != 12 && x != 13 && x != 14)) {
            return a + " года";
        } else {
            return a + " лет";
        }
    }

    // Zad2_9
    private String day(int x) {
        switch (x) {
            case 1: return "Понедельник";
            case 2: return "Вторник";
            case 3: return "Среда";
            case 4: return "Четверг";
            case 5: return "Пятница";
            case 6: return "Суббота";
            case 7: return "Воскресенье";
            default: return "это не день недели";
        }
    }

    // Zad3_2
    private String reservelistNums(int x) {
        String a = "";
        while (x >= 0) {
            a = a + String.valueOf(x) + " ";
            x = x - 1;
        }
        return a;
    }

    // Zad3_3
    private String chet(int x) {
        String a = "";
        for (int i = 0; i <= x; i += 2) {
            a = a + String.valueOf(i) + " ";
        }
        return a;
    }

    // Zad3_7
    private void square(int x) {
        for (int i = 0; i < x; i++) {
            String a = "*";
            System.out.println(a.repeat(x));
        }
    }

    // Zad3_8
    private void leftTriangle(int x) {
        String a = "";
        for (int i = 0; i < x; i++) {
            a = a + "*";
            System.out.println(a);
        }
    }

    // Zad3_10
    private void guessGame() {
        Random random = new Random();
        int RandomNumber = random.nextInt(10);
        int x = -1;
        int i = 0;
        while (x != RandomNumber) {
            x = getValidInt("Введи число от 0 до 9 - ");
            i = i + 1;
            if (x == RandomNumber) {
                System.out.println("Вы угадали число за " + i + " попыток");
            } else {
                System.out.println("Вы не угадали число");
            }
        }
    }

    // Zad4_3
    private int maxAbs(int[] arr) {
        int maxAbsValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int currentAbs = Math.abs(arr[i]);
            int maxAbs = Math.abs(maxAbsValue);
            if (currentAbs > maxAbs) {
                maxAbsValue = arr[i];
            }
        }
        return maxAbsValue;
    }

    // Zad4_4
    private int[] add(int[] arr, int x, int pos) {
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Некорректная позиция: " + pos);
        }

        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr[i];
        }

        newArr[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    // Zad4_6
    private void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        arrPrint(arr);
    }

    // Zad4_9
    private int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }

        int[] newArr = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                newArr[index] = i;
                index++;
            }
        }
        return newArr;
    }

    // ========== ГЛАВНЫЙ МЕТОД ==========

    public static void main(String[] args) {
        lab1 program = new lab1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ПРОГРАММА ДЛЯ РЕШЕНИЯ РАЗЛИЧНЫХ ЗАДАЧ ===");
        System.out.println("Выберите задачу для выполнения:");
        System.out.println("1. Zad1_1 - Дробная часть числа");
        System.out.println("2. Zad1_2 - Сумма последних цифр");
        System.out.println("3. Zad1_6 - Проверка заглавной буквы");
        System.out.println("4. Zad1_7 - Проверка вхождения в диапазон");
        System.out.println("5. Zad1_10 - Многократное сложение последних цифр");
        System.out.println("6. Zad2_1 - Модуль числа");
        System.out.println("7. Zad2_4 - Сравнение чисел");
        System.out.println("8. Zad2_5 - Максимум из трех чисел");
        System.out.println("9. Zad2_8 - Склонение возраста");
        System.out.println("10. Zad2_9 - День недели");
        System.out.println("11. Zad3_2 - Числа в обратном порядке");
        System.out.println("12. Zad3_3 - Четные числа");
        System.out.println("13. Zad3_7 - Квадрат из звездочек");
        System.out.println("14. Zad3_8 - Левый треугольник");
        System.out.println("15. Zad3_10 - Угадай число");
        System.out.println("16. Zad4_3 - Максимум по модулю");
        System.out.println("17. Zad4_4 - Вставка в массив");
        System.out.println("18. Zad4_6 - Переворот массива");
        System.out.println("19. Zad4_9 - Поиск всех вхождений");
        System.out.println("0. Выход");

        while (true) {
            System.out.print("\nВведите номер задачи: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n=== Zad1_1 - Дробная часть числа ===");
                    double num1_1 = program.getValidInt("Введите число: ");
                    System.out.println("Дробная часть: " + program.fraction(num1_1));
                    break;

                case 2:
                    System.out.println("\n=== Zad1_2 - Сумма последних цифр ===");
                    int num1_2 = program.getValidInt("Введите число больше 100: ");
                    if (num1_2 <= 100) {
                        System.out.println("Число должно быть больше 100");
                    } else {
                        System.out.println("Результат: " + program.sumLastNums(num1_2));
                    }
                    break;

                case 3:
                    System.out.println("\n=== Zad1_6 - Проверка заглавной буквы ===");
                    System.out.print("Введите символ: ");
                    char ch = scanner.next().charAt(0);
                    System.out.println("Результат: " + program.isUpperCase(ch));
                    break;

                case 4:
                    System.out.println("\n=== Zad1_7 - Проверка вхождения в диапазон ===");
                    int a1_7 = program.getValidInt("Введите начало диапазона: ");
                    int b1_7 = program.getValidInt("Введите конец диапазона: ");
                    int num1_7 = program.getValidInt("Введите число для проверки: ");
                    System.out.println("Результат: " + program.isInRange(a1_7, b1_7, num1_7));
                    break;

                case 5:
                    System.out.println("\n=== Zad1_10 - Многократное сложение последних цифр ===");
                    int a1_10 = program.getValidInt("Введите первое число: ");
                    int b1_10 = program.getValidInt("Введите второе число: ");
                    int result1_10 = program.lastNumSum(a1_10, b1_10);
                    System.out.println(a1_10 + "+" + b1_10 + " = " + result1_10);

                    for (int i = 0; i < 3; i++) {
                        a1_10 = result1_10;
                        b1_10 = program.getValidInt("Введите следующее число: ");
                        result1_10 = program.lastNumSum(a1_10, b1_10);
                        System.out.println(a1_10 + "+" + b1_10 + " = " + result1_10);
                    }
                    System.out.println("Итого: " + result1_10);
                    break;

                case 6:
                    System.out.println("\n=== Zad2_1 - Модуль числа ===");
                    int num2_1 = program.getValidInt("Введите число: ");
                    System.out.println("Модуль равен: " + program.abs(num2_1));
                    break;

                case 7:
                    System.out.println("\n=== Zad2_4 - Сравнение чисел ===");
                    int x2_4 = program.getValidInt("Введите первое число: ");
                    int y2_4 = program.getValidInt("Введите второе число: ");
                    System.out.println("Результат: " + program.makeDecision(x2_4, y2_4));
                    break;

                case 8:
                    System.out.println("\n=== Zad2_5 - Максимум из трех чисел ===");
                    int x2_5 = program.getValidInt("Введите первое число: ");
                    int y2_5 = program.getValidInt("Введите второе число: ");
                    int z2_5 = program.getValidInt("Введите третье число: ");
                    System.out.println("Максимальное число: " + program.max3(x2_5, y2_5, z2_5));
                    break;

                case 9:
                    System.out.println("\n=== Zad2_8 - Склонение возраста ===");
                    int age2_8 = program.getValidInt("Введите возраст: ");
                    if (age2_8 < 0) {
                        System.out.println("Нужно положительное число");
                    } else {
                        System.out.println("Результат: " + program.age(age2_8));
                    }
                    break;

                case 10:
                    System.out.println("\n=== Zad2_9 - День недели ===");
                    int day2_9 = program.getValidInt("Введите день недели (1-7): ");
                    System.out.println("Результат: " + program.day(day2_9));
                    break;

                case 11:
                    System.out.println("\n=== Zad3_2 - Числа в обратном порядке ===");
                    int num3_2 = program.getValidInt("Введите число: ");
                    System.out.println("Результат: " + program.reservelistNums(num3_2));
                    break;

                case 12:
                    System.out.println("\n=== Zad3_3 - Четные числа ===");
                    int num3_3 = program.getValidInt("Введите число: ");
                    System.out.println("Результат: " + program.chet(num3_3));
                    break;

                case 13:
                    System.out.println("\n=== Zad3_7 - Квадрат из звездочек ===");
                    int size3_7 = program.getValidInt("Введите размер квадрата: ");
                    program.square(size3_7);
                    break;

                case 14:
                    System.out.println("\n=== Zad3_8 - Левый треугольник ===");
                    int height3_8 = program.getValidInt("Введите высоту треугольника: ");
                    program.leftTriangle(height3_8);
                    break;

                case 15:
                    System.out.println("\n=== Zad3_10 - Угадай число ===");
                    program.guessGame();
                    break;

                case 16:
                    System.out.println("\n=== Zad4_3 - Максимум по модулю ===");
                    int n4_3 = program.getValidInt("Введите количество элементов в массиве: ");
                    if (n4_3 <= 0) {
                        System.out.println("Количество элементов должно быть положительным числом!");
                        break;
                    }
                    int[] arr4_3 = new int[n4_3];
                    System.out.println("Введите " + n4_3 + " чисел:");
                    for (int i = 0; i < n4_3; i++) {
                        arr4_3[i] = program.getValidInt("Элемент " + (i + 1) + ": ");
                    }
                    program.arrPrint(arr4_3);
                    System.out.println("Максимальное число по модулю: " + program.maxAbs(arr4_3));
                    break;

                case 17:
                    System.out.println("\n=== Zad4_4 - Вставка в массив ===");
                    int n4_4 = program.getValidInt("Введите количество элементов в массиве: ");
                    if (n4_4 <= 0) {
                        System.out.println("Количество элементов должно быть положительным числом!");
                        break;
                    }
                    int[] arr4_4 = new int[n4_4];
                    System.out.println("Введите " + n4_4 + " чисел:");
                    for (int i = 0; i < n4_4; i++) {
                        arr4_4[i] = program.getValidInt("Элемент " + (i + 1) + ": ");
                    }
                    program.arrPrint(arr4_4);
                    int x4_4 = program.getValidInt("Введите число для вставки: ");
                    int pos4_4 = program.getValidInt("Введите позицию для вставки: ");
                    if (0 <= pos4_4 && pos4_4 <= n4_4) {
                        arr4_4 = program.add(arr4_4, x4_4, pos4_4);
                        System.out.println("Массив после вставки:");
                        program.arrPrint(arr4_4);
                    } else {
                        System.out.println("Неверная позиция!");
                    }
                    break;

                case 18:
                    System.out.println("\n=== Zad4_6 - Переворот массива ===");
                    int n4_6 = program.getValidInt("Введите количество элементов в массиве: ");
                    if (n4_6 <= 0) {
                        System.out.println("Количество элементов должно быть положительным числом!");
                        break;
                    }
                    int[] arr4_6 = new int[n4_6];
                    System.out.println("Введите " + n4_6 + " чисел:");
                    for (int i = 0; i < n4_6; i++) {
                        arr4_6[i] = program.getValidInt("Элемент " + (i + 1) + ": ");
                    }
                    System.out.println("Исходный массив:");
                    program.arrPrint(arr4_6);
                    System.out.println("Перевернутый массив:");
                    program.reverse(arr4_6);
                    break;

                case 19:
                    System.out.println("\n=== Zad4_9 - Поиск всех вхождений ===");
                    int n4_9 = program.getValidInt("Введите количество элементов в массиве: ");
                    if (n4_9 <= 0) {
                        System.out.println("Количество элементов должно быть положительным числом!");
                        break;
                    }
                    int[] arr4_9 = new int[n4_9];
                    System.out.println("Введите " + n4_9 + " чисел:");
                    for (int i = 0; i < n4_9; i++) {
                        arr4_9[i] = program.getValidInt("Элемент " + (i + 1) + ": ");
                    }
                    program.arrPrint(arr4_9);
                    int x4_9 = program.getValidInt("Введите число для поиска: ");
                    int[] result4_9 = program.findAll(arr4_9, x4_9);
                    System.out.println("Индексы, где найден элемент " + x4_9 + ":");
                    program.arrPrint(result4_9);
                    break;

                case 0:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }
}
