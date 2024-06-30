package ru.practicum.dinner;

import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    static DinnerConstructor dinnerConstructor;
    static Scanner scanner;

    public static void main(String[] args) {
        dinnerConstructor = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    dinnerConstructor.printAllDishes();
                    break;
                case "4":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Вывести все типы и блюда");
        System.out.println("4 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dinnerConstructor.addDish(dishType, dishName);

    }

    private static void generateDishCombo() {

            System.out.println("Начинаем конструировать обед...");
            System.out.println("Введите количество наборов, которые нужно сгенерировать:");
            int numberOfCombos = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

            ArrayList<String> dishTypes = new ArrayList<>();
            String nextItem;
            while (!(nextItem = scanner.nextLine()).isEmpty()) {
                if (dinnerConstructor.checkType(nextItem)) {
                    dishTypes.add(nextItem);
                } else {
                    System.out.println("Тип блюда \"" + nextItem + "\" не существует. Пожалуйста, введите другой тип.");
                }
            }

            System.out.println("Сгенерированные комбинации блюд:");
            for (int i = 0; i < numberOfCombos; i++) {
                System.out.print("Комбинация " + (i + 1) + ": ");
                for (String type : dishTypes) {
                    String dish = dinnerConstructor.randomDish(type);
                    if (dish != null) {
                        System.out.print(dish + " ");
                    } else {
                        System.out.print("(нет блюд данного типа) ");
                    }
                }
                System.out.println();
            }
        }
}

