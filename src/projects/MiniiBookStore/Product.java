package projects.MiniiBookStore;

public class Product {
    //1a- tum urunlerin ortak ozellikleri ve metotlari olacak

    private static int count=0;
    private int id;
    private String name;
    private String price;
    private int stock;

    public Product(String name, String price, int stock) {
        count++; //bu metot cagirilinca count calisir ve otomatik id olusturur.
        this.id = count;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
