package main.batch_129.projects.bilet_rezervasyon;

import java.util.Scanner;

/*
Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
         Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         koltuk no  bilgilerini alın.
         Mesafe başına ücret 1 Lira / km olarak alın.(Gidiş-Dönüş için *2)
         Tekli Koltuk ücreti:Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 daha fazladır(1.2 Lira).
         İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;
koltuk numaralari 1 den 32 ye kadar olsun.
        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

       1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
       2-Yaş indirimi:
        Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 13-24 yaşları arasında ise son bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */
public class BiletRezervasyon {
    public static void main(String[] args) {
        //1.adim bilet rezervasyonu icin otobus objesi olusturalim.
Bus bus=new Bus("34 ASD 78"); //obje cagirilinca koltuk numaralari da gelecek.

//4.adim. Bilet objesi olusturalim.
Bilet bilet=new Bilet();
    }
public static void start(Bus bus){ //Bus class tan obje olusturup kullanmak icin. ordaki verileri kullanacagiz.
    Scanner scan=new Scanner(System.in);
    do {
        //6.adimda kullanicidan bilgileri alacagiz
        System.out.println("Bilet Rezervasyon Uygulamasina Hosgeldiniz...");
        System.out.println("Lutfen gidilecek mesafe bilgisini km olarak giriniz");
        double distance=scan.nextDouble();

        System.out.println("Lutfen yolculuk tipini seciniz");
        System.out.println("1- Tek yon");
        System.out.println("2- Gidis-donus");
        int type=scan.nextInt();

        System.out.println("Lutfen yasinizi giriniz");
        int age=scan.nextInt();

        System.out.println("Koltuk no seciniz");
        System.out.println("(Tekli koltuk ucreti %20 daha fazladir)");
        System.out.println(bus.seats);  //Bus bus ile cagirdik
        int seat=scan.nextInt();

        //7- secilen koltugu listeden kaldiralim
        bus.seats.remove(String.valueOf(seat));     //koltuk no string oldugu icin int seat i value of ile string yaptim.

//8-kullanicidan alinan degerler gecerli mi
        boolean check=type==1|| type==2;
        if (distance>0 &&age>0 && check){
            //9- bilet fiyati hesaplayalim
        }else {
            System.out.println("Hatali giris yaptiniz !!!");
        }


    }while (1>0);

}



}//class
