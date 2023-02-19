package main.batch_129.projects.hospital;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deneme {
    private String girilen;

    private int veri;

    public String getGirilen() {
        return girilen;
    }

    public int getVeri() {
        return veri;
    }

    public void setGirilen(String girilen) {
        this.girilen = girilen;
    }

    public void setVeri(int veri) {
        this.veri = veri;
    }

    public Deneme(String girilen, int veri) {
        this.girilen = girilen;
        this.veri = veri;
    }

    static Deneme veriGirisi=new Deneme("fizik", -1);

    public static int veriGirisi(){
        boolean c=false;
        Integer menuSec=-1;
        do{

        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        try {
            veriGirisi.setVeri(Integer.parseInt(brr.readLine()));
            c = true;
        }catch (NumberFormatException e){
            System.out.println("Yanlis karakter girdiniz");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
menuSec= veriGirisi.getVeri();
    }while (!c);
        return menuSec;
    }

    public static int integerGirisiHataEngelleme(){
        boolean c=false;
        Integer id=-1;
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        do{
         brr = new BufferedReader(new InputStreamReader(System.in));
            try {

                id=Integer.parseInt(brr.readLine());
                c = true;
            }catch (NumberFormatException e){
                System.out.println("Yanlis karakter girdiniz");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }while (!c);
return id;
    }

}

