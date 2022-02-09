package goods;

import java.util.Arrays;
import java.util.Scanner;


public class Good_List {

    public static Good find(int id) { // поиск товара по ID
        Good g1 = new Good();
        for (int i = 0; i < Good.list.length; ++i) {
            if (Good.list[i].ID == id) {
                g1 = Good.list[i];
                return g1;
            }
        }
        System.out.println("Товар с таким ID не найден!");
        return null;
    }



    public static void delete(int id) { // удаление товара
        if (find(id) != null) {
        for (int i = 0; Good.list[i] != null && i < Good.size; ++i) {
            if (Good.list[i].ID == id) {
                for (int j = i; j < Good.size - 1; ++j) {
                    Good.list[j] = Good.list[j + 1];
                }
                Good.list[Good.size - 1] = null;
                --Good.list_count;
                break;
            }
        }
        System.out.println("Товар успешно удален!");
        }
    }

    public static void show_list() { // показать список товаров
        System.out.println("Список товаров:");
        for (int i = 0; i < Good.size && Good.list[i] != null; ++i) {
            System.out.println(Good.list[i].ID + " " + Good.list[i].name + " " + Good.list[i].price + " руб. " +
                    Good.list[i].count + " шт. " + Good.list[i].description);
        }
    }

    public static void add(Scanner scanner, Scanner str_scanner) { // добавление товара
        if (Good.list_count == Good.size) {
            System.out.println("Нельзя больше добавлять товары, список заполнен");
            return;
        }
        String name;
        int count;
        int price;
        String descr;
        System.out.println("Введите наименование товара:");
        name = str_scanner.nextLine();
        System.out.println("Введите количество товара:");
        count = scanner.nextInt();
        System.out.println("Введите цену товара:");
        price = scanner.nextInt();
        System.out.println("Введите описание товара:");
        descr = str_scanner.nextLine();
        Good.print(new Good(name, count, price, descr));
        System.out.println("Товар успешно добавлен!");
    }

    public static void sell() { // добавление товара
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID товара, для его продажи");
        int id = scanner.nextInt();
        Good g1 = Good_List.find(id);
        if (g1 != null) {
            Good.print(g1);
            if (g1.count <= 0) {
                System.out.println("Нельзя выполнить продажу, кол-во товара " + g1.count);
                return;
            }
            System.out.println("Введите кол-во товара для продажи:");
            int cnt = scanner.nextInt();
            if (g1.count < cnt) System.out.println("Нельзя выполнить продажу, кол-во товара " + g1.count);
            else {
                for (int i = 0; Good.list[i] != null && i < Good.size; ++i) {
                    if (Good.list[i].ID == id) {
                        Good.list[i].count -= cnt;
                        System.out.println("Товар продан, остаток " + Good.list[i].count + " шт");
                        break;
                    }
                }

            }
        }
    }
}
