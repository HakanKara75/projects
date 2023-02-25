package projects.restaurant_bill_generator;

import java.util.ArrayList;
import java.util.List;

public class DishService {
    //5- yiyecekleri listeye ekleyecegim
   private List<Dish> dishList=new ArrayList<>();

   public DishService(){
       Dish dish1=new Dish(100, "Adana Kebabi", 220.99);
       Dish dish2=new Dish(101,"Urfa Kebabi",200.0);
       Dish dish3=new Dish(102,"Cokertme Kebabi",200.0);
       Dish dish4=new Dish(200,"Baklava",100.0);
       Dish dish5=new Dish(201,"Kadayif",85.0);
       Dish dish6=new Dish(202,"Kunefe",75.0);
       Dish dish7=new Dish(300,"Yayik Ayrani",30.0);
       Dish dish8=new Dish(301,"Kola",35.0);
       Dish dish9=new Dish(302,"Cay",15.0);
       Dish dish10=new Dish(303,"Su",7.5);

       this.dishList.add(dish1);
       this.dishList.add(dish2);
       this.dishList.add(dish3);
       this.dishList.add(dish4);
       this.dishList.add(dish5);
       this.dishList.add(dish6);
       this.dishList.add(dish7);
       this.dishList.add(dish8);
       this.dishList.add(dish9);
       this.dishList.add(dish10);
   }

   //6- yemek menusunu gostermek icin metot olusturacagim
public void showMenu(){
    System.out.println("     ***       Lezzetlerimiz    ***        ");
    // % variable gelecek demek , 3 character, s String, - sola dayali demek, f double demek
    System.out.printf("%-3s     %-20s     %-6s      \n", "Kod", "Adi", "Fiyat");
    System.out.printf("%-3s     %-20s     %-6s      \n", "------", "---------", "--------");
    for (Dish dish:this.dishList) { //this olmasa da olurdu. baska dishlist (parametre) olsaydi gerekirdi. isim karisabilir
        System.out.printf("%-3s     %-20s     %-6s     Lira\n", dish.getCode(), dish.getName(), dish.getPrice());
    }
}
//12- girilen code ile yemegi bulma
public Dish findByDishCode(int code){
       if (code==0){
           System.out.println("Ana menuye yonlendiriliyorsunuz");
       }else {
           for (Dish dish:this.dishList) {
               if (dish.getCode()==code){
                   return dish;
               }
           }
           System.out.println("Aradiginiz urun bulunamadi");
       }
       return null; // for icinde dish dondurecek. if icinse birsey kalmiyor. onun icin null
}


}
