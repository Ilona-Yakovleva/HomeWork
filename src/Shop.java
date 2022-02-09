import goods.Good;
import goods.Good_List;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        byte choise = 77;

        new Good("Хлеб", 15, 55, "Вкусненький хлебушек");
        new Good("Молоко", 8, 90, "");
        new Good("Колбаса", 20, 225, "");
        new Good("Кефир", 18, 70, "");
        new Good("Сыр", 30, 150, "");

        while(choise != 0) {
            System.out.println("\nВедите:");
            System.out.println("1 - для показа списка товаров");
            System.out.println("2 - для перехода в карточку товара");
            System.out.println("3 - для добавления нового товара");
            System.out.println("4 - для удаления товара из списка");
            System.out.println("5 - для продажи товара");
            System.out.println("0 - для выхода");
            choise = scanner.nextByte();
            switch (choise){
                case 1:
                    Good_List.show_list();
                    break;
                case 2:
                    System.out.println("Введите ID товара:");
                    int id = scanner.nextInt();
                    Good g1 = Good_List.find(id);
                    if (g1 != null) {
                    Good.print(g1);
                    byte choise_in_card = 8;
                    while (choise_in_card != 0) {
                        System.out.println("\nВедите:");
                        System.out.println("1 - для изменения наименования товаров");
                        System.out.println("2 - для изменения количества (списание, приход) товара");
                        System.out.println("3 - для изменения цены товара");
                        System.out.println("4 - для изменения описания товара");
                        System.out.println("0 - для выхода в основное меню");
                        choise_in_card = scanner.nextByte();
                        switch (choise_in_card) {
                            case 1:
                                System.out.println("Введите новое наименование:");
                                String name1 = strScanner.nextLine();
                                Good.change_name(id, name1);
                                break;
                            case 2:
                                System.out.println("Введите количество (\"-\" перед числом если было списание):");
                                int cnt = scanner.nextInt();
                                Good.change_count(id, cnt);
                                break;
                            case 3:
                                System.out.println("Введите новую цену:");
                                int prc = scanner.nextInt();
                                Good.change_price(id, prc);
                                break;
                            case 4:
                                System.out.println("Введите новое описание:");
                                String descr = strScanner.nextLine();
                                Good.change_description(id, descr);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Нет такого действия в меню");
                                break;
                        }
                    }
                    }
                    break;
                case 3:
                    Good_List.add(scanner, strScanner);
                    break;
                case 4:
                    System.out.println("Введите ID товара для удаления:");
                    Good_List.delete(scanner.nextInt());
                    break;
                case 5:
                    Good_List.sell();
                    break;
                case 0:
                    System.out.println("До свидания!!!");
                    break;
                default:
                    System.out.println("Нет такого действия в меню");
                    break;
            }
        }
    }
}
