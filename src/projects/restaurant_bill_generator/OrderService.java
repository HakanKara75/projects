package projects.restaurant_bill_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//10- order islemler
public class OrderService {
    Scanner inp = new Scanner(System.in);
    List<Order> orderList = new ArrayList<>(); //siparis listesi. yapilan siparis bu obje ustune kaydediliyor.

    //11- siparis olusturma
    public void createOrder(DishService dishService) { // metot icinde bu class tan metot cagiracagimdan buraya girdim

        int dishCode;

        do {
            System.out.println("Lutfen istediginiz urunun kodunu giriniz: (Cikis icin urun kodu yerine 0 giriniz)");
            dishCode = inp.nextInt(); //verilen code ile urunu bulmaliyiz
            if (dishService.findByDishCode(dishCode) != null) {
                Dish dish = dishService.findByDishCode(dishCode);
                System.out.println("Adet giriniz");
                int number = inp.nextInt();
                //bu yemek daha once siparis edilmis mi, bakmaliyiz ki siparis adeti artsin veya eksilsin.
                Order order;
                if (findByOrderByDish(dish) != null) {
                    order = findByOrderByDish(dish);
                    order.numberOfDish += number;
                    order.setPrice();
                } else {
                    order = new Order(dish, number); //siparis olusturduk, otomatik olarak order kodu da olustu
                    order.setPrice();
                    this.orderList.add(order);
                }
            }//siparis olusunca altta siparis listesini goruntuleyecegim
            listOrders();


        } while (dishCode != 0);

    }

    //14- siparisleri listele
    private void listOrders() {
        this.orderList.
                forEach(order -> System.out.printf("Siparis kodu:%-5s   Lezzet kodu:%-4s   " +
                                "Lezzet adi:%-5s   Adet:%-3s\n",
                        order.orderCode, order.dish.getCode(), order.dish.getName(), order.numberOfDish));
    }

    // 13- dish bilgisi ile siparis bulma
    private Order findByOrderByDish(Dish dish) { // dish objesi kullanacagim icin parametreyi buraya girdim
        for (Order order : this.orderList) {

            if (order.dish.equals(dish)) {
                return order;
            }
        }


        return null;
    }

    //15- siparisi iptal

    public void deleOrder() {
        System.out.println("Iptal etmek istedidiginiz siparisin kodunu giriniz");
        int code = inp.nextInt();
        boolean isValid=true;
        for (Order order : this.orderList) {
            if (order.orderCode == code) {
                System.out.println("Iptal etmek istediginiz miktari giriniz");
                int num = inp.nextInt();
                if (order.numberOfDish > num) {
                    order.numberOfDish -= num;
                    order.setPrice();
                    System.out.println("Siparis iptal edildi: "+ order.dish.getName());
                } else if (order.numberOfDish == num) {
                    this.orderList.remove(order);
                    System.out.println("Siparis iptal edildi: "+ order.dish.getName());
                } else {
                    System.out.println("Hatali giris!!!");
                }
            isValid=true;
                break;
            } else {
// siparis kodu yoksa buraya mesaj yazarsak tum siparisleri dolanir ve defalarca mesaji yazdirir
                isValid=false;
            }
        }
if (!isValid){
    System.out.printf("Siparis kodu gecersiz!!!");
}
        System.out.println("         Mevcut Siparisler          ");
        listOrders();
    }

    //16- hesabi olusturma
public void printBill(){
      double total=0;
    System.out.println("            Lezzet Fisiniz         ");
    for (Order order:this.orderList){
        System.out.printf("Siparis Kodu:%-5s   Lezzet Kodu:%-4s   " +
                        "Lezzet Adi:%-5s   Adet:%-3s Tutar:%-7s Lira\n",
                order.orderCode, order.dish.getCode(), order.dish.getName(), order.numberOfDish, order.orderPrice);
        total+=order.orderPrice;
      }
    System.out.printf("Toplam Tutar: "+total);
    System.out.printf("Afiyet Olsun");
    this.orderList.clear();
}



}
