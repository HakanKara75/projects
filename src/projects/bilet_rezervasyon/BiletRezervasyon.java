package projects.bilet_rezervasyon;

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


start(bus,bilet);
    }
public static void start(Bus bus, Bilet bilet){ //Bus class tan obje olusturup kullanmak icin. ordaki verileri kullanacagiz.
        // Bilet class tan da bilet tutarini hesapladigimiz bilgileri aldik.
    Scanner scan=new Scanner(System.in);
    int select;
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

        boolean isReserved=!bus.seats.contains(String.valueOf(seat));
        if (isReserved){
            System.out.println("Lutfen listede aktif olan bir koltuk seciniz");
            select=0;
        }else {
            //7- secilen koltugu listeden kaldiralim
            bus.seats.remove(String.valueOf(seat));     //koltuk no string oldugu icin int seat i value of ile string yaptim.
        }
//8-kullanicidan alinan degerler gecerli mi
        boolean check=type==1|| type==2;
        if (distance>0 &&age>0 && check){
            //9- bilet fiyati hesaplayalim

            bilet.distance=distance;
            bilet.typeNo=type;
            bilet.seatNo=seat;
            bilet.price=getTotal(bilet, age); // bilet ucretini set etmek icin
            System.out.println("---------------------------------------");
            bilet.printBilet(bus); //bileti yazdirmak icin
        }else {
            System.out.println("Hatali giris yaptiniz !!!");
        }
        System.out.println("Yeni islem icin 1 cikis icin 0 giriniz");
        select= scan.nextInt();

    }while (select !=0);
    System.out.println("Iyi gunler dileriz");
}
    private static double getTotal(Bilet bilet, int age) {
        double dist = bilet.distance;
        int type = bilet.typeNo;
        int seat = bilet.seatNo;
        double total = 0;
        switch (type) {
            case 1:
                if (seat % 3 == 0) {
                    total = dist * 1.2;
                } else {
                    total = dist * 1;
                }
                break;
            case 2:
                if (seat % 3 == 0) {
                    total = dist * 2.4;
                } else {
                    total = dist * 2;
                }
                total = total * 0.8;
                break;
        }
        if (age <=12) {
            total = total * 0.5;
        } else if (age > 12 && age < 24) {
            total = total * 0.9;
        } else if (age > 65) {
            total = total * 0.7;

        }return total;
    }

}//class

/* alinan biletin tekrar alinmasi
koltuk sayisi koltuk satisina engel
 */