package goods;

public class Good {
    static final int size = 5;
    private static int id = 0;
    static int listCount = 0;
    public static Good [] list = new Good[size];
    int ID;
    String name;
    int count;
    int price;
    String description;

    public Good () {}

    public Good(String name, int count, int price, String description) {
        ++id;
        this.ID = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.description = description;
        list[listCount] = this;
        ++listCount;
    }

    public static void change_name (int id, String new_name) { // изменение наименования товара
        Good g1 = Good_List.find(id);
        if (g1 != null) {
            g1.name = new_name;
            print(g1);
        }
    }

    public static void change_count (int id, int cnt) { // изменение наименования товара
        Good g1 = Good_List.find(id);
        if (g1 != null) {
            g1.count += cnt;
            print(g1);
        }
    }

    public static void change_price (int id, int prc) { // изменение наименования товара
        Good g1 = Good_List.find(id);
        if (g1 != null) {
            g1.price = prc;
            print(g1);
        }
    }

    public static void change_description (int id, String desc) { // изменение оптсания товара
        Good g1 = Good_List.find(id);
        if (g1 != null) {
            g1.description = desc;
            print(g1);
        }
    }

    public static void print (Good g1) { // изменение наименования товара
        if (g1 != null) System.out.println(g1.ID + " " + g1.name + " " + g1.price + " руб. " + g1.count + " шт. " + g1.description);
    }
}
