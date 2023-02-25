package projects.MiniiBookStore;

import java.util.Scanner;

/*Proje: Mini Book Store
       Online bir kitap market için ürün yönetim uygulaması yapınız.
       Kitap markette kitap ve defter satışı olacak, ancak ileride yeni ürün çeşidi eklenebilir olmalı.

       Kitap özellikleri: id, isim, birim fiyat, stok, yazar adı, yayınevi,isbn no
       Defter özellikleri: id, isim, birim fiyat, stok, marka, yaprak sayısı,ürün kodu

       Kullanıcı ilgili kategorideki ürünleri listeleyebilmeli
       Kullanıcı kategoriye göre ürün ekleyebilmeli,ürün mevcutsa uyarı verilmeli
       Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli.
       Kullanıcı ürünleri marka (defter) veya yayınevine (kitap) göre filtreleyip listeleyebilmeli.
*/
public class MiniBookStore {
    public static void main(String[] args) {
        enter();
    }
    //1-uygulama calismaya baslamadan once kitap ve defter veritabani hazir olmali
    //urunleri ortak ozelliklerine gore ortak bir class ta toplayacagim
    public static void enter(){
   int select;
        Scanner inp=new Scanner(System.in);
        System.out.println("---- Mini Book Store ----");
do {
    System.out.println("Urun Yonetim Paneli");
    System.out.println("1-Kitaplar");
    System.out.println("2-Defterler");
    System.out.println("0-Cikis");
    System.out.println("Seciminiz:");
    select= inp.nextInt();
    inp.nextLine(); //dummy
    ProductService service; // burada BookSrvice veya NoteBookService ile obje olusturmadik. boylece asagidaki menu bu urunler
    //kaldirilip baska urune donusturulmesine musaade eder. kitap yerine kelime refactor edip baska bir urun satilabilir.
    //ikincisi select yapilmadan obje olusturulmuyor. fazladan obje calismiyor. burada yapsaydik 2 objeyi hazir edecektik.
    //oysa kullanici sadece 1 rakam girecek yani bir obje olusturulacak. 2 obje yapsaydik biri bos yere hazir edilecekti.
    switch (select){
        case 1:
            service=new BookService();
            service.processMenu();
            break;
        case 2:
            service=new NoteBookService();
            service.processMenu();
            break;
        case 0:
            System.out.println("Iyi gunler");
            break;
        default:
            System.out.println("Hatali giris");
            break;

    }

}while (select!=0);
    }
}
