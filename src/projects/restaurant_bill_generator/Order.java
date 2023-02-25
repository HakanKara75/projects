package projects.restaurant_bill_generator;

public class Order {
    public static int count=999; //static, objeden bagimsiz.
public int orderCode;
public int numberOfDish;
public double orderPrice;
public Dish dish;

//8- yemek ve adet parametreleri ile obje olusturduk
public Order(Dish dish,int numberOfDish){
    count++;
    this.orderCode=count;
    this.dish=dish;
    this.numberOfDish=numberOfDish;

}


// 9- siparis hesaplama
public void setPrice(){
    this.orderPrice=this.dish.getPrice()*this.numberOfDish;
}

}
