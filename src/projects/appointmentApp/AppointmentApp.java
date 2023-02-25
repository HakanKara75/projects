package projects.appointmentApp;

import java.util.Scanner;

/*
Proje: Randevu oluşturma uygulaması geliştiriniz.

       1-Ana menüde kullanıcıya randevu alma veya görüntülemek için iki seçenek sunulur.
       2-Randevu alma/oluşturma
            -Randevu için uygun tarihler gösterilir.
            -Randevu alınmak istenen tarihin seçilmesi istenir.
            -en yakın 7 günlük takvim dolmuşsa daha sonra denenmesi istenir.
            -Geçerli bir tarih seçilmişse randevu oluşturulur ve bu tarih tarihler listesinden silinir.
       3-Randevu görüntüleme:
            -Kullanıcıya randevu no sorulur,
             randevu listesinde girilen no ile eşleşen randevu bilgileri yazdırılır.
       4-Randevu iptal:
            -Kullanıcıya randevu no sorulur,
             randevu listesinde girilen no ile eşleşen randevu listeden silinir.
       5-Randevu:
            -id : otomatik üretilsin
            -isim,randevu tarihi
 */
public class AppointmentApp {
    public static void main(String[] args) {
        start();


    }

    public static void start(){
        //1- menu olusturduk
        //2-randevu olusturacagiz. appointment class
        Scanner inp=new Scanner(System.in);
        AppointmentService service=new AppointmentService();
        int select=-1;
        do {
            System.out.println("Randevu sistemine hosgeldiniz.");
            System.out.println("1- Randevu olustur.");
            System.out.println("2- Randevu goruntule.");
            System.out.println("3- Randevu iptali.");
            System.out.println("0- Cikis");
            System.out.println("Seciminiz: ");
            select=inp.nextInt();

            switch (select){
                case 1:
                    service.getAppointment();
                    break;
                case 2:
                    service.printAppointment();
                    break;
                case 3:
                    service.cancelAppointment();
                    break;
                case 0:
                    System.out.println("Iyı gunler dileriz");
                    break;
                default:
                    System.out.println("Hatali giris");
                    break;
            }
        }while (select!=0);

    }
}
