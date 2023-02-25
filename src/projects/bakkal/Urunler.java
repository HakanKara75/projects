package projects.bakkal;

public class Urunler {

   private static int count=100;
   private String isim;
   private double fiyati;
   private int urunId;



    public Urunler(String isim, double fiyati) {

        count++;
        this.isim = isim;
        this.fiyati = fiyati;
        this.urunId=count;
    }

    public String getIsim() {
        return isim;
    }

    public double getFiyati() {
        return fiyati;
    }

    public int getUrunId() {
        return urunId;
    }
}
