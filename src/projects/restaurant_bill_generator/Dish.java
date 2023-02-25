package projects.restaurant_bill_generator;

public class Dish {
// yiyeceklerin fieldlarina ulasilamasin. okunsun ancak degistirilemesin.
private int code;
private String name;
private double price;

//yiyecek olusturulurken ozellikleri set edilsin.

    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    //dish objesini yazdirmak icin
    @Override
    public String toString() {
        return "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
