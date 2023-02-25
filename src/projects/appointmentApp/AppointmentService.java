package projects.appointmentApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3 randevu islemleri, metotlar
public class AppointmentService {
    Scanner inp = new Scanner(System.in);
    List<Appointment> appointments = new ArrayList<>();

    //5-tarih listesi
    List<LocalDate> dates = new ArrayList<>();

    //6-uygulama basladiginda ertesi gunden itibaren 7 gunluk bir takvim hazir olacak.

    public AppointmentService() {
        LocalDate day = LocalDate.now();
        for (int i = 0; i < 7; i++) {
            day = day.plusDays(1);
            dates.add(day);
        }
    }

//7 randevu olustur

    public void getAppointment() {
        //8- randevu takvimi dolu mu
        if (this.dates.isEmpty()) {
            System.out.println("Bu hafta tum randevular dolmustur. Daha sonra tekrar deneyin.");
        } else {
            System.out.println("Isminiz: ");
            String name = inp.nextLine();
            System.out.println("Sayin " + name + ", randevu alabileceginiz tarihler: ");
            for (int i = 0; i < this.dates.size(); i++) {
                System.out.println((i + 1) + " - " + this.dates.get(i));
            }
            System.out.println("Randevu almak istediginiz tarihin numarasini giriniz");
            int numberOfDate = inp.nextInt();
            inp.nextLine(); //dummy
            //9- secilen tarih gecerli mi
            if (numberOfDate > 0 && numberOfDate <= this.dates.size()) {
                Appointment appointment = new Appointment(name, this.dates.get(numberOfDate - 1));
                this.appointments.add(appointment);
                System.out.println("---------------------------------------------------------------------------------");
                System.out.println("Sayin " + name + ", Randevu tarihiniz: " + appointment.getDate());
                System.out.println("Randevu no : " + appointment.getId() + " ile randevunuzu goruntuleyebilirsiniz.");
                System.out.println("---------------------------------------------------------------------------------");
                this.dates.remove(numberOfDate - 1);
            } else {
                System.out.println("Hatali giris!!!");
            }
        }
    }

    //10- randevu goruntuleme
    public void printAppointment() {
        System.out.println("Randevu no giriniz: ");
        boolean isExists = true;
        int appNo = inp.nextInt();
        inp.nextLine();//dummy
        for (Appointment app : this.appointments) {
            if (app.getId() == appNo) {
                System.out.println("------------------------------------------------------------------");
                System.out.println(appNo + " numarali randevu bilgileri :");
                System.out.println("Isim: " + app.getName());
                System.out.println("Randevu tarihi: " + app.getDate());
                System.out.println("------------------------------------------------------------------");
                isExists = true;
                break;
            } else {
                isExists = false;

            }
        }
        if (!isExists) {
            System.out.println("Randevu bulunamadi.");
        }
    }

//11- randevu iptal etme

    public void cancelAppointment() {
        boolean isExist = true;
        System.out.println("Randevu no giriniz: ");
        int appNo = inp.nextInt();
        inp.nextLine();//dummy
        for (Appointment app : this.appointments) {
            if (app.getId() == appNo) {
                isExist = true;
                this.dates.add(app.getDate());
                this.appointments.remove(app);

                System.out.println(app.getDate() + " tarihli randevunuz iptal edildi.");
                break;
            } else {
                isExist = false;

            }
        }
        if (!isExist) {
            System.out.println("Randevu bulunamadi");
        }


    }


}
