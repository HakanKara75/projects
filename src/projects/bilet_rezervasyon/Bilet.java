package main.batch_129.projects.bilet_rezervasyon;

public class Bilet {
    //mesafe, yolculuk tipi, bilet fiyati, koltuk no

    public double distance;
    public int typeNo;
    public double price;
    public int seatNo;

    //5-bileti yazdiralim
    public void printBilet(Bus bus){ //yeni bir constructor olusturmayip var olani parametre olarak yazdik.
        System.out.println("Toplam tutar: "+this.price);
        System.out.println("------Bilet Detayi -----");
        System.out.println("Otobus plakasi: "+bus.numberPlate);
        System.out.println("Mesafe : "+this.distance);
        System.out.println("Yolculuk tipi : "+(this.typeNo==1 ? "Tek Yon": "Gidis-donus"));
        System.out.println("Koltuk no : " +this.seatNo);
        System.out.println("Keyifli yolculuklar dileriz...");
    }
}
