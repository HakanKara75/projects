package projects.MiniiBookStore;
//interface her urun icin ortak kullanilacak metotlari kullanmaya mecbur birakmak icin
//urunlerle ilgili islemlerin standartlarini bu interface belirler
public interface ProductService {
//2- product islemleri

void processMenu();

void listProduct();
void addProduct();
void deleteProduct();
void filterProducts(String filter);

}
