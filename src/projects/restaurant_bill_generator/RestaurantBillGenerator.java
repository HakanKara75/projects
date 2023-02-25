package projects.restaurant_bill_generator;

import java.util.Scanner;

/*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

       3-Yiyecek menüsü, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         5-Sipariş iptal:Sipariş kodu girilerek sipariş silinsin

         6-Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/
public class RestaurantBillGenerator {
    public static void main(String[] args) {
        getSelectionMenu();

    }

//1- islem secimi icin menu gosterecegim
public static void getSelectionMenu(){
    Scanner inp=new Scanner(System.in);
DishService dishService=new DishService();//bu classin metotlarini kullanmak icin yaptim. yemek listesini run etti.
    OrderService orderService=new OrderService();
//2-menu tekrar tekrar gosterilsin
    //3- yiyecekler listesi icin class olusturalim
    // 7- siparis icin class olusturalim
    int select=-1;
while (select!=0){
    System.out.println("---------------------------------------------------");
    System.out.println("***** Lezzet Restaturant Siparis Uygulamasi *****");
    System.out.println("1-Menu");
    System.out.println("2-Siparis Gir");
    System.out.println("3-Siparis Iptal");
    System.out.println("4-Hesap Olustur");
    System.out.println("0-Cikis");
    System.out.println("Seciminizi giriniz");
    System.out.println("---------------------------------------------------");

    select= inp.nextInt();

    switch (select){
        case 1:
            //menu goster
            dishService.showMenu();
            break;
        case 2:
            //siparis olustur
orderService.createOrder(dishService);
            break;
        case 3:
            //siparis iptal
            orderService.deleOrder();
            break;
        case 4:
            //hesap
            orderService.printBill();
            break;
        case 0:
            System.out.println("Iyi gunler dileriz");
            break;
        default:
            System.out.println("Hatali giris yaptiniz");
            break;
    }
}
}


}//class
