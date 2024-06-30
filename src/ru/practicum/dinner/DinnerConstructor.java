package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
public class DinnerConstructor {
    HashMap<String, ArrayList<String>> typeOfDish = new HashMap<>();//будем хранить тут тип блюд
    Random random = new Random();

    public void addDish(String dishType, String dishName) {
        // если тип блюда отсутствует, создаем новый список и добавляем его в карту
        if (!typeOfDish.containsKey(dishType)) {
            typeOfDish.put(dishType, new ArrayList<String>());
        }
        // добавляем название блюда в список соответствующего типа
        typeOfDish.get(dishType).add(dishName);
    }

    //проверка на наличие типа блюда
    boolean checkType(String type) {
        return typeOfDish.containsKey(type);// да/нет
    }

    // метод для рандомного выбора блюда для конкретного типа
    public String randomDish(String type) {
        ArrayList<String> dishes = typeOfDish.get(type);
        if (dishes != null && !dishes.isEmpty()) {
            int rand = random.nextInt(dishes.size());
            return dishes.get(rand);
        }
        return null;
    }
    //добавил метод для отладки чтобы видеть весь список добавления
    public void printAllDishes() {
        if (typeOfDish.isEmpty()) {
            System.out.println("Либо список пусть, либо вы ошиблись.");
        } else {
            for (String type : typeOfDish.keySet()) {
                System.out.println("Тип блюда: " + type);
                ArrayList<String> dishes = typeOfDish.get(type);
                for (String dish : dishes) {
                    System.out.println("  - " + dish);
                }
            }
        }
    }
}



