package main.batch_129.projects.aracsigorta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AracSigortaApp {
    public static void main(String[] args) {
        /*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
       Tarife dönemi:Aralık 2023,Haziran 2023
       1.dönemi  Haziran 2023                 2.dönem   Aralık 2023
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750
        Hatalı girişte hesaplama başarısız uyarsı verip tekrar menü gösterilsin.
 */
        start();
    }
    public static void start(){
        Scanner scan=new Scanner(System.in);
        boolean isFail; //kullanicinin veri girislerinin dogrulugunu kontrol etmek icin
//hatali giriste veya yeni islem icin menu tekrari gosterilsin: do while/while
        do{
            isFail=false;//program tekrar basa donunca calisma sartini yeniden olusturuyoruz.
            //olmazsa hep true da kalacagindan program sonsuz donguye girer.
            System.out.println(" --------Zorunlu Sigorta Primi Hesaplama----------");

        System.out.println("Tarife donemi seciniz:");
        System.out.println("1.Donem Haziran 2023");
        System.out.println("2.Donem Aralik 2023");
        int term=0;

        try {
            term = scan.nextInt();
        }catch (InputMismatchException e){
        System.out.println("Gecersiz giris yaptiniz. Lutfen sayi giriniz");
            }
scan.nextLine(); // hafizaya aldigi gecersiz girisi bosa cikarmak icin yazdik.
//girilen deger gecerli mi? yani 1 ve 2 disinda bir rakam da girmis olabilir.
            if (term==1||term==2){
                Arac arac=new Arac();
                String termName=term==1 ?"Haziran 2023" : "Aralik 2023";
                                        System.out.println("Arac tipini giriniz");
                System.out.println("otomobil, kamyon, otobus, motosiklet");
               String select= scan.next();
               arac.type=select;  //arac tipini kullanici giriyor. onun icin select
               arac.countPrim(term);        //primi metot hesapladigi icin arac objesi ile metodu cagirdik.
                if (arac.prim>0){
                System.out.println("Hesaplama islemi basariyla tamamlandi");
                System.out.println("Arac tipi: "+arac.type);
                System.out.println("Arac tarife donemi: "+termName);
                System.out.println("Aracin ilgili donem sigorta primi :" + arac.prim);
                    isFail = isAgain(scan);
//Kullanici fiyat begenmeyip yeni doneme gore fiyat almak isteyebilir veya programdan cikmak isteyebilir
                //bunun icin asagiyi yaziyoruz.
                    System.out.println("Hesaplama basarisiz.");

                } else{
                        System.out.println("Hesaplama basarisiz lutfen tekrar deneyin.");
                    isFail = isAgain(scan);
                    }
            }else {
                System.out.println("Hatali giris!!!");
                isFail=true;
            }

        }while ( isFail);

    }

    private static boolean isAgain(Scanner scan) { //star metot altinda scanner objesi oldugundan burada parametre olarak girdik
        //yeniden scanner olusturmadik. yukaridaki var olan objeyi kullandik.
        boolean isFail;
        System.out.println("Yeni islem icin 1, cikis icin herhangi bir sayi giriniz");
        int choice= scan.nextInt();
        if (choice==1)
            isFail=true;
            else
                isFail=false;
        return isFail;
    }
}
