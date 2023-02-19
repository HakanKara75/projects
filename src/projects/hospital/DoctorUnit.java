package main.batch_129.projects.hospital;

import java.util.ArrayList;
import java.util.List;

public class DoctorUnit {

    public static List<Doctor> doctorList = new ArrayList<>();
    Hospital hospital = new Hospital();


    public void fillDoctorList() {

        for (int i = 0; i < hospital.titles.length; i++) {
            Doctor doctor = new Doctor(hospital.doctorNames[i],hospital.doctorSurnames[i],hospital.titles[i]);
            doctorList.add(doctor);
        }
    }


    public static void showDoctorList() {
        System.out.println("            DOCTORS          ");
        System.out.printf("%-15s   %-10s   %-10s \n", "Title", "Name", "Surname");
        System.out.printf("%-15s   %-10s   %-10s \n", "-----", "----", "------");
        for (Doctor doctor : doctorList) {
            System.out.printf("%-15s   %-10s   %-10s \n", doctor.getTitle(), doctor.getName(), doctor.getSurname());
        }

    }


    public static Doctor findDoctorByTitle() {
        boolean a=false;

        do {
            System.out.println("Enter Title:");

            String title = HospitalRunner.scanner.nextLine().toLowerCase();
            for (Doctor doctor : doctorList) {
                if (doctor.getTitle().toLowerCase().equalsIgnoreCase(title)) {
                                     a=true;
                    System.out.println(doctor);
                }

                }if(a==false){
                    System.out.println("Not found doctor!");
            }

            return new Doctor("", "", "");
        } while (a=true);


    }

    public void addDoctor() {
        Doctor doctor = new Doctor();
        System.out.println("Doktor ismi :");
     //   HospitalRunner.scanner.nextLine(); // dummy
        doctor.setName(HospitalRunner.scanner.nextLine());
        System.out.println("Soyisim:");
        doctor.setSurname(HospitalRunner.scanner.nextLine());
        System.out.println("Unvan");
        doctor.setTitle(HospitalRunner.scanner.nextLine());

        doctorList.add(doctor);
        System.out.println(doctorList);

    }

    public Doctor deleteDoctor() {
        showDoctorList();
      //  HospitalRunner.scanner.nextLine(); // dummy
        System.out.println("Silmek istediğiniz doktorun unvanını giriniz:");

        String title = HospitalRunner.scanner.nextLine();
        System.out.println(title);
        for (Doctor doctor : this.doctorList) {
            if (doctor.getTitle().equalsIgnoreCase(title)) {
                this.doctorList.remove(doctor);
                System.out.println(doctor + " silindi.");
                return doctor;
            }
        }
        System.out.println("Hatalı giriş yaptınız.");
        return deleteDoctor();
    }



}