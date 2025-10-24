
// Класс Point для Zad1
class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String Coordinates() {
        return "{" + x + ";" + y + "}";
    }
}

// Класс Name для Zad2
class Name {
    private String Surname;     // Фамилия
    private String Name;        // Личное имя
    private String MiddleName;  // Отчество

    // Конструктор для всех трех параметров
    public Name(String Surname, String Name, String MiddleName) {
        this.Surname = Surname;
        this.Name = Name;
        this.MiddleName = MiddleName;
    }

    public Name(String Surname, String Name) {
        this(Surname, Name, null);
    }

    public Name(String Name) {
        this(null, Name, null);
    }

    // Метод для приведения к строковому виду
    public String getFullName() {
        StringBuilder fullName = new StringBuilder();

        if (Surname != null && !Surname.isEmpty()) {
            fullName.append(Surname);
        }

        if (Name != null && !Name.isEmpty()) {
            if (fullName.length() > 0) {
                fullName.append(" ");
            }
            fullName.append(Name);
        }

        if (MiddleName != null && !MiddleName.isEmpty()) {
            if (fullName.length() > 0) {
                fullName.append(" ");
            }
            fullName.append(MiddleName);
        }

        return fullName.toString();
    }

    // Переопределение метода toString() для удобного вывода
    @Override
    public String toString() {
        return getFullName();
    }
}

// Класс City для Zad3 и Zad4
class City {
    private String name;
    private City[] connectedCities; // массив связанных городов
    private int[] costs;             // массив стоимостей поездок

    // Конструктор 1 — только название
    public City(String name) {
        this.name = name;
        this.connectedCities = new City[0];
        this.costs = new int[0];
    }

    // Конструктор 2 — название + связанные города и их стоимости
    public City(String name, City[] connectedCities, int[] costs) {
        this.name = name;
        // если передано null — создаём пустые массивы, чтобы не было ошибок
        if (connectedCities == null || costs == null) {
            this.connectedCities = new City[0];
            this.costs = new int[0];
        } else {
            this.connectedCities = connectedCities;
            this.costs = costs;
        }
    }

    // Метод для добавления пути к новому городу
    public void addPath(City city, int cost) {
        int newSize = connectedCities.length + 1;

        City[] newCities = new City[newSize];
        int[] newCosts = new int[newSize];

        // копируем старые данные
        for (int i = 0; i < connectedCities.length; i++) {
            newCities[i] = connectedCities[i];
            newCosts[i] = costs[i];
        }

        // добавляем новый путь
        newCities[newSize - 1] = city;
        newCosts[newSize - 1] = cost;

        connectedCities = newCities;
        costs = newCosts;
    }

    @Override
    public String toString() {
        String result = "Город " + name + " связан с: ";
        if (connectedCities.length == 0) {
            result += "нет путей";
        } else {
            for (int i = 0; i < connectedCities.length; i++) {
                result += connectedCities[i].name + ":" + costs[i] + " ";
            }
        }
        return result;
    }
}

// Класс Fraction для работы с дробями
class Fraction {
    private final int numerator;
    private final int denominator;

    // Конструктор с числителем и знаменателем
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Конструктор только с числителем (знаменатель = 1)
    public Fraction(int numerator) {
        this(numerator, 1);
    }

    // Геттеры
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Строковое представление
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Нахождение наибольшего общего делителя (НОД)
    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    // Сокращение дроби
    private Fraction simplify() {
        int gcd = gcd(numerator, denominator);
        int sign = (numerator * denominator < 0) ? -1 : 1;
        int simplifiedNumerator = Math.abs(numerator) / gcd * sign;
        int simplifiedDenominator = Math.abs(denominator) / gcd;
        return new Fraction(simplifiedNumerator, simplifiedDenominator);
    }

    // Сложение с другой дробью
    public Fraction add(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator).simplify();
    }

    // Сложение с целым числом
    public Fraction add(int number) {
        return add(new Fraction(number));
    }

    // Вычитание другой дроби
    public Fraction subtract(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        return new Fraction(newNumerator, commonDenominator).simplify();
    }

    // Вычитание целого числа
    public Fraction subtract(int number) {
        return subtract(new Fraction(number));
    }

    // Умножение на другую дробь
    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator).simplify();
    }

    // Умножение на целое число
    public Fraction multiply(int number) {
        return multiply(new Fraction(number));
    }

    // Деление на другую дробь
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Деление на ноль невозможно");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator).simplify();
    }

    // Деление на целое число
    public Fraction divide(int number) {
        return divide(new Fraction(number));
    }
}

// Главный класс с дружественным интерфейсом
public class lab2 {
    public static void main(String[] args) {
        System.out.println("=== ОБЪЕДИНЕННАЯ ПРОГРАММА ===");
        System.out.println();

        // Zad1 - Работа с точками
        System.out.println("=== ZAD1 - РАБОТА С ТОЧКАМИ ===");
        zad1Demo();
        System.out.println();

        // Zad2 - Работа с именами
        System.out.println("=== ZAD2 - РАБОТА С ИМЕНАМИ ===");
        zad2Demo();
        System.out.println();

        // Zad3 и Zad4 - Работа с городами
        System.out.println("=== ZAD3 и ZAD4 - РАБОТА С ГОРОДАМИ ===");
        zad3zad4Demo();
        System.out.println();

        // Zad5 - Работа с дробями
        System.out.println("=== ZAD5 - РАБОТА С ДРОБЯМИ ===");
        zad5Demo();
        System.out.println();

        System.out.println("=== ПРОГРАММА ЗАВЕРШЕНА ===");
    }

    // Демонстрация Zad1
    public static void zad1Demo() {
        Point point1 = new Point(2, 3.);
        Point point2 = new Point(7, -4);
        Point point3 = new Point(0, -1.6);

        System.out.println("Точка 1: " + point1.Coordinates());
        System.out.println("Точка 2: " + point2.Coordinates());
        System.out.println("Точка 3: " + point3.Coordinates());
    }

    // Демонстрация Zad2
    public static void zad2Demo() {
        // Создание имен согласно заданию
        Name name1 = new Name("Клеопатра");                          // Только имя
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");  // Фамилия, имя, отчество
        Name name3 = new Name("Маяковский", "Владимир");            // Фамилия и имя

        // Вывод на экран
        System.out.println("Имя 1: " + name1.getFullName());
        System.out.println("Имя 2: " + name2.getFullName());
        System.out.println("Имя 3: " + name3.getFullName());
    }

    // Демонстрация Zad3 и Zad4
    public static void zad3zad4Demo() {
        // Создаем города
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        // Добавляем пути вручную
        A.addPath(B, 5);
        A.addPath(D, 6);
        A.addPath(F, 1);

        // Пример создания города с уже заданными путями
        City[] citiesForF2 = {B, E};
        int[] costsForF2 = {1, 2};
        City F2 = new City("F2", citiesForF2, costsForF2);

        // Вывод информации
        System.out.println(A);
        System.out.println(F2);
    }

    // Zad5 - Работа с дробями
    public static void zad5Demo() {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);
        Fraction f4 = new Fraction(2, 5);

        System.out.println("Созданные дроби:");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f4 = " + f4);
        System.out.println();


        System.out.println("Примеры операций:");


        Fraction sumResult = f1.add(f2);
        System.out.println(f1 + " + " + f2 + " = " + sumResult);


        Fraction subtractResult = f3.subtract(f4);
        System.out.println(f3 + " - " + f4 + " = " + subtractResult);


        Fraction multiplyResult = f1.multiply(f2);
        System.out.println(f1 + " * " + f2 + " = " + multiplyResult);


        Fraction divideResult = f3.divide(f4);
        System.out.println(f3 + " / " + f4 + " = " + divideResult);


        Fraction addWithInt = f1.add(2);
        System.out.println(f1 + " + 2 = " + addWithInt);

        Fraction subtractWithInt = f3.subtract(1);
        System.out.println(f3 + " - 1 = " + subtractWithInt);

        Fraction multiplyWithInt = f2.multiply(3);
        System.out.println(f2 + " * 3 = " + multiplyWithInt);

        Fraction divideWithInt = f4.divide(2);
        System.out.println(f4 + " / 2 = " + divideWithInt);
        System.out.println();

        //Вывод в формате «1/3 * 2/3 = 2/9»
        System.out.println("Вывод в требуемом формате:");
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f3 + " - " + f4 + " = " + f3.subtract(f4));
        System.out.println(f3 + " / " + f4 + " = " + f3.divide(f4));
        System.out.println();

        // Вычисление f1.sum(f2).div(f3).minus(5)
        System.out.println("Вычисление f1.add(f2).divide(f3).subtract(5):");
        Fraction result = f1.add(f2).divide(f3).subtract(5);
        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1.add(f2) + " / " + f3 + " = " + f1.add(f2).divide(f3));
        System.out.println(f1.add(f2).divide(f3) + " - 5 = " + result);
        System.out.println("Итоговый результат: " + result);
    }
}