package projects.MiniiBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a : bookla ilgili islemler
public class BookService implements ProductService {
    Scanner inp = new Scanner(System.in);

    //3 bookları saklamak icin list olustururum
    List<Book> books = new ArrayList<>(); //book class tan bir liste olusturduk

    //4 : baslangicta sistemde mevcut kitaplar hazir olsun: test etmek amaciyla
    public BookService() {
        Book book1 = new Book("Fareler ve Insanlar", "120 Lira", 15, "J.Steinbeck", "Penguin", "G54321");
        Book book2 = new Book("Sefiller", "150 Lira", 5, "V.Hugo", "Penguin", "A4645");
        Book book3 = new Book("Suc ve Ceza", "120 Lira", 15, "Dostoyevski", "Dream", "A333");
        this.books.add(book1);
        this.books.add(book2);
        this.books.add(book3);

    }

    //5- islem menusu
    @Override
    public void processMenu() {
        int choice;
        do {
            System.out.println("--------------------------");
            System.out.println("1- Kitaplari Listeleme");
            System.out.println("2- Kitap Ekleme");
            System.out.println("3- Kitap Silme");
            System.out.println("4- Yayinevine Gore Filtreleme");
            System.out.println("0- Geri Don");
            System.out.println("Seciminizi giriniz: ");
            choice = inp.nextInt();
            inp.nextLine(); //nextInt ardindan nextLine gelince okuma hatasi veriyor. o nedenle dummy attik
            switch (choice) {
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.printf("Yayinevi bilgisini giriniz:");
                    String publisher = inp.nextLine();
                    filterProducts(publisher);
                    break;
                case 0:
                    System.out.println("Ana menuye yonlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("Hatali giris!!!");
                    break;
            }
        } while (choice != 0);
    }

    //6- kitaplari formatla yazdiralim
    @Override
    public void listProduct() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("%-2s  |  %-20s  |  %-15s  |  %-10s  |  %-10s  |  %-15s  |  %-3s\n",
                "ID", "Kitap Adi", "Yazar Adi", "Yayinevi", "ISBN", "Birim Fiyati", "Stok");
        System.out.println("--------------------------------------------------------------------------------------------------");
        this.books.forEach(book -> System.out.printf("%-2s  |  %-20s  |  %-15s  |  %-10s  |  %-10s  |  %-15s  |  %-3s\n",
                book.getId(), book.getName(), book.getAuthorname(), book.getPublisher(),
                book.getIsbn(), book.getPrice(), book.getStock()));
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println();

    }
//7- yeni kitap ekle

    @Override
    public void addProduct() {
        System.out.println("ISBN: ");
        String isbn = inp.nextLine();
        boolean isExists = false;
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("Bu kitap sistemde zaten kayitli. Lutfen urun guncelleme yapiniz");
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            System.out.println("Kitap adi: ");
            String name = inp.nextLine();
            System.out.println("Kitabin yazari: ");
            String author = inp.nextLine();
            System.out.println("Yayinevi: ");
            String publisher = inp.nextLine();
            System.out.println("Birim fiyati: ");
            String price = inp.nextLine();
            System.out.println("Stok: ");
            int stock = inp.nextInt();
            inp.nextLine(); //dummy attik nextint ten sonra nextline olacaksa
            Book newBook = new Book(name, price, stock, author, publisher, isbn);
            this.books.add(newBook);
        }
        listProduct();
    }
//updateProduct: stok artırma/azaltma, birim fiyat isleri bu metoda kaldi. sonra yapilabilir.

    //8- kullanicidan id bilgisi alinip urun bulunup ve listeden kaldirilacak
    @Override
    public void deleteProduct() {
        boolean isExists = true;
        System.out.println("Kitap id: ");
        int id = inp.nextInt();
        for (Book book : this.books) {
            if (book.getId() == id) {
                isExists = true;
                this.books.remove(id);
                System.out.println("Urun silindi.");
            } else {
                isExists = false;
            }
        }
        if (!isExists) {
            System.out.println("Urun bulunamadi.");
        }
    }

    //9- kitaplari yayinevine gore filtreleyecegim
    @Override
    public void filterProducts(String filter) {
//this.books.stream().
//        filter(book -> book.getPublisher().equalsIgnoreCase(filter)).
//        forEach(book -> System.out.printf("%-2s  |  %-20s  |  %-15s  |  %-10s  |  %-4s  |  %-10s  |  %-3s\n",
//                book.getId(), book.getName(), book.getAuthorname(), book.getPublisher(),
//                book.getIsbn(), book.getPrice(), book.getStock() ));
//
        int counter = 0;
        for (Book book : this.books) {
            if (book.getPublisher().equalsIgnoreCase(filter)) {
                System.out.printf("%-2s  |  %-20s  |  %-15s  |  %-10s  |  %-10s  |  %-15s  |  %-3s\n",
                        book.getId(), book.getName(), book.getAuthorname(), book.getPublisher(),
                        book.getIsbn(), book.getPrice(), book.getStock());
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Urun bulunamadi.");
        }


    }
}
