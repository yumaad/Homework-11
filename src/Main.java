import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // task #1
        int year = 2024;
        checkYear(year);

        // task #2
        int clientOS = 1;
        int clientDeviceYear = 2020;
        selectVersion(clientOS, clientDeviceYear);

        // task #3
        int deliveryDistance = 150;
        int deliveryTime = calculateDeliveryTime(deliveryDistance);
        if (deliveryTime == -1) {
            System.out.println("На данное расстояние доставки нет, введите расстояние от 0 до 100 км");
        } else {
            System.out.println("Потребуется дней: " + deliveryTime);
        }
    }

    // метод для проверки является ли год високосным
    public static void checkYear(int year) {
        if (year >= 1584) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println(year + " год является високосным\n");
            } else {
                System.out.println(year + " год не является високосным\n");
            }
        } else {
            System.out.println("Введите, пожалуйста, другой год за 1584 годом\n");
        }
    }

    // предоставление ссылки в зависимости от ОС и года выпуска устройства
    public static void selectVersion(int clientOS, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();
        switch (clientOS) {
            case 0:
                if (clientDeviceYear < currentYear) {
                    System.out.println("Установите облегченную версию приложения для iOS по ссылке\n");
                } else {
                    System.out.println("Установите версию приложения для iOS по ссылке\n");
                }
                break;
            case 1:
                if (clientDeviceYear < currentYear) {
                    System.out.println("Установите облегченную версию приложения для Android по ссылке\n");
                } else {
                    System.out.println("Установите версию приложения для Android по ссылке\n");
                }
                break;
            default:
                System.out.println("Версии приложения для такой операционный системы нет\n");
        }
    }

    // метод для вычисления сроков доставки
    public static int calculateDeliveryTime(int deliveryDistance) {
        int deliveryTerm = 0;
        if (deliveryDistance > 0 && deliveryDistance <= 20) {
            deliveryTerm = 1;
        } else if (deliveryDistance <= 60) {
            deliveryTerm = 2;
        } else if (deliveryDistance <= 100){
            deliveryTerm = 3;
        }
        else {
            deliveryTerm = -1;
        }
        return deliveryTerm;
    }
}