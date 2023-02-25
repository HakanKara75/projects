package projects.depo;

import java.util.*;

public class Depo {
    static Map<Integer, UrunBilgi> urunler = new HashMap<>();
    static Set<Map.Entry<Integer, UrunBilgi>> setUrunler = urunler.entrySet();
    static Scanner scan = new Scanner(System.in);
    Runner runner = new Runner();


    public static void urun() {

        urunler.put(1000, new UrunBilgi("Seker", "Hekimoğlu", 3, "Cuval", null));
        urunler.put(1001, new UrunBilgi("Tuz", "Hekimoglu", 0, "Cuval", "null"));
        urunler.put(1002, new UrunBilgi("Baharat", "Hekimoglu", 8, "Cuval", "null"));
        urunler.put(1003, new UrunBilgi("Gofret", "Hekim", 16, "Kutu", "null"));
        urunler.put(1004, new UrunBilgi("Biskuvi", "Hekim", 7, "Kutu", "null"));
        urunlerimiz();

    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t === MENU SEÇENEKLERİ ===\t\n" +
                "URUN EKLEMEK ICIN '1' SECINIZ\n" +
                "URUN MIKTARINI GUNCELLEMEK ICIN '2' SECINIZ\n" +
                "URUNU RAFA KOYMAK ICIN '3' SECINIZ\n" +
                "URUN CIKISI ICIN '4' SECINIZ\n" +
                "URUN LISTESI ICIN '5' SECINIZ \n" +
                "SISTEMDEN CIKIS ICIN '0' SECINIZ\n");
        try {
            int select = sc.nextInt();
            System.out.println("----------------------------------------------------");

            switch (select) {
                case 1:
                    yeniUrunEkle();
                    break;
                case 2:
                    miktarGuncelle();
                    break;
                case 3:
                    urunuRafaKoyma();
                    break;

                case 4:
                    urunCikisi();
                    break;
                case 5:
                    urunListesi();
                    break;
                case 0:
                    System.out.println("Iyi Gunler.. ");
                    System.out.println();
                    break;
                default:
                    System.out.println("Hatali Giris");
                    break;

            }
        } catch (InputMismatchException e) {
            System.out.println("Hatalı seçim yaptınız");
        }
    }
    public static void yeniUrunEkle() {

        int select = -1;
        do {

            System.out.println("ID : ");
            int yeniID = scan.nextInt();
            for (Map.Entry<Integer, UrunBilgi> each : setUrunler) {
                Integer eachKey = each.getKey();
                if (eachKey.equals(yeniID)) {
                    System.out.println("Girdiğiniz ID daha önce kullanıldı");
                    yeniUrunEkle();
                }
            }
            scan.nextLine();
            System.out.println("URUN ISIM : ");
            String yeniIsim = scan.nextLine();
            System.out.println("URETICI : ");
            String yeniUretici = scan.nextLine();
            System.out.println("MIKTAR : ");
            int yeniMiktar = scan.nextInt();
            scan.nextLine();
            System.out.println("BIRIMI : ");
            String yeniBirim = scan.nextLine();
            System.out.println("RAF : ");
            String yeniRaf = scan.nextLine();
            urunler.putIfAbsent(yeniID, new UrunBilgi(yeniIsim, yeniUretici, yeniMiktar, yeniBirim, yeniRaf));
            urunlerimiz();
            System.out.println("Urun Eklemeye Devam Etmek icin Herhangi Bir Tusa Basiniz");
            System.out.println("Cikis Icin '0' basiniz");
            select=scan.nextInt();


        } while (select != 0);

        menu();
    }
    public static void miktarGuncelle() {

        System.out.println("Miktar Guncellenecek ID : ");
        int id = scan.nextInt();
        System.out.println();
        if (urunler.keySet().contains(id)) {
            System.out.println("Eklenecek Miktarinizi Giriniz");
            int guncelMiktar = scan.nextInt();
            urunler.get(id).setMiktar(guncelMiktar + urunler.get(id).getMiktar());
            System.out.println("Miktar Guncellendi");
            System.out.println(urunler.get(id));
            System.out.println("--------------------------------------------");
            Runner.menu();
        } else System.out.println("Aradiginiz Urun Yok");
    }

    public static void urunCikisi() {
        System.out.println("Cikis Yapacak Urun ID : ");
        int exId = scan.nextInt();
        if (urunler.keySet().contains(exId)) {
            System.out.println("Cikacak Miktarinizi Giriniz");
            int guncelMiktar = scan.nextInt();
            if (guncelMiktar > urunler.get(exId).getMiktar()) {
                System.out.println("Stokta Olan " + urunler.get(exId).getMiktar() + " Miktardan  Daha Buyuk Cikis Yapamazsiniz..");
                urunCikisi();
            } else {
                urunler.get(exId).setMiktar(urunler.get(exId).getMiktar() - guncelMiktar);//deger sifirin altina dusmemeli
            }
            System.out.println("Miktar Guncellendi");
            System.out.println(urunler.get(exId));
            System.out.println("----------------------------------------------------");
            Runner.menu();
        } else System.out.println("Aradiginiz Urun Yok");
    }

    public static void urunListesi() {

        urunlerimiz();
        menu();
    }

    public static void urunuRafaKoyma() {


        System.out.println("Rafı Guncellenecek ID girin : ");
        int id = scan.nextInt();
        if (urunler.keySet().contains(id)) {
            System.out.println("Raf yerini Giriniz");
            System.out.println("\n\t === RAF SEÇENEKLERİ ===\t\n" +
                    "BAKLİYAT URUNLERİ(BA12)\n" +
                    "KURUYEMİŞ URUNLERİ(KU12)\n" +
                    "UNLU MAMULLER(UN12)\n" +
                    "BAHARAT URUNLERİ(BH12) \n" +
                    "TEMİZLİK URUNLERİ(TE12)\n" +
                    "ABUR CUBUR(AC12)\n");
            String raf = scan.next();
            urunler.get(id).setRaf(raf);
            System.out.println("RAF YERİ GÜNCELLENDİ");
            System.out.println(urunler.get(id));
            System.out.println("--------------------------------------------");
        } else System.out.println("Aradiginiz Urun Yok");
        urunListesi();
        urunuRafaKoyma();


    }



    public static void urunlerimiz() {
        System.out.println("\t                              ******* Urunlerimiz *******                    \n" +
                "  ID                     ISMI                 URETICISI            MIKTARI               BIRIMI              RAF ");

        for (Map.Entry<Integer, UrunBilgi> each : setUrunler) {
            Integer eachKey = each.getKey();
            String eachValue = String.valueOf(each.getValue());
            String[] eachValueArr = eachValue.split(", ");
            System.out.printf("%-4s %-10s          %-20s       %-5s        %-7s       %-7s \n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2],
                    eachValueArr[3], eachValueArr[4]);
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.println();

        }
    }
}

