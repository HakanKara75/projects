package projects.hospital;

import java.util.Scanner;

public class HospitalRunner extends Deneme{
    static Scanner scanner = new Scanner(System.in);

    public HospitalRunner(String girilen, int veri) {
        super(girilen, veri);
    }

    public static void main(String[] args) {

        start();

    }

    public static void start() {

        DoctorUnit doctorUnit = new DoctorUnit();
        PatientUnit patientUnit = new PatientUnit();
        doctorUnit.fillDoctorList();
        patientUnit.fillPatientList();
        getSelectionMenu(doctorUnit, patientUnit);

    }

    public static void exit() {
/*
NOT: sistemden cikmiyordu. bastan giris menusune donuyordu.
 System.exit(0); kapatmayi sagladi.

 */
        System.out.println("Sağlıklı Günler Dileriz.");
        System.exit(0);
    }

    public static void getSelectionMenu(DoctorUnit doctorUnit, PatientUnit patientUnit) {

        int select = -1;
        while (select != 0) {

            System.out.println("*********WELCOME TO HOSPITAL*******");
            System.out.println("----------------------------------------");
            System.out.println("Yapmak istediginiz islemi seciniz: " +
                    "\n==> Doktor Menusu icin '1' " +
                    "\n==> Hasta Menusu icin '2' " +
                    "\n==> Cikis icin '0' a basiniz");
            System.out.println("----------------------------------------");
            System.out.println("Seciminiz:");



            switch (   veriGirisi()) {
                case 1:
                    getSelectionDoctorMenu(doctorUnit, patientUnit);
                case 2:
                    getSelectionPatientMenu(doctorUnit, patientUnit);
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("Hatalı giris");
                    getSelectionMenu(doctorUnit, patientUnit);
            }


        }
    }

    private static void getSelectionPatientMenu(DoctorUnit doctorUnit, PatientUnit patientUnit) {
        int select = -1;

        while (select != 0) {

            System.out.println("\t=====HASTA MENUSU=====\n" +
                    "\t  1- Hasta Ekleme\t\n" +
                    "\t  2- Hasta Listesi Yazdir\n" +
                    "\t  3- Hasta Durumu \n" +
                    "\t  4- Hasta Silme\n" +
                    "\t  5- Hasta Bulma\n" +
                    "\t  6- ANA MENU\n" +
                    "\t  7-CIKIS");


            switch (veriGirisi()) {
                case 1:
                    patientUnit.addPatient();
                    getSelectionPatientMenu(doctorUnit, patientUnit);
                case 2:
                    patientUnit.showPatientList();
                    getSelectionPatientMenu(doctorUnit, patientUnit);
                case 3:
                    patientUnit.patientCase();
                    getSelectionPatientMenu(doctorUnit, patientUnit);
                case 4:
                    patientUnit.deletePatient();
                    getSelectionPatientMenu(doctorUnit, patientUnit);
                case 5:
                    patientUnit.findPatientById();
                    getSelectionPatientMenu(doctorUnit, patientUnit);
                case 6:
                    getSelectionMenu(doctorUnit, patientUnit);
                case 7:
                    exit();
                    break;
                default:
                    System.out.println("Lutfen menudeki rakamlardan birisini giriniz");
                    getSelectionPatientMenu(doctorUnit, patientUnit);
            }
        }

    }

    private static void getSelectionDoctorMenu(DoctorUnit doctorUnit, PatientUnit patientUnit) {

        int select = -1;

        while (select != 0) {

            System.out.println("============DOKTOR MENUSU===========\n" +

                    "\n" +
                    "\t  1-Doktor Ekle\t\n" +
                    "\t  2-Doktor Listesi Yazdir\n" +
                    "\t  3-Unvandan Doktor Bulma\n" +
                    "\t  4-Doktor Silme\n" +
                    "\t  5-ANA MENU\n" +
                    "\t  6-CIKIS");


            switch (veriGirisi()) {
                case 1:  // doctor ekle
                    doctorUnit.addDoctor();
                    getSelectionDoctorMenu(doctorUnit, patientUnit);
                case 2:  // doktor listesi yazdır
                    doctorUnit.showDoctorList();
                    getSelectionDoctorMenu(doctorUnit, patientUnit);
                case 3:  // Unvandan doktor bul
                    doctorUnit.findDoctorByTitle();
                    getSelectionDoctorMenu(doctorUnit, patientUnit);
                case 4:  // Doktor Silme
                    doctorUnit.deleteDoctor();
                    getSelectionDoctorMenu(doctorUnit, patientUnit);
                case 5:  // Ana Menü
                    getSelectionMenu(doctorUnit, patientUnit);
                case 6:  // cıkıs
                    exit();
                    break;
                default:
                    System.out.println("Lutfen menudeki rakamlardan birisini giriniz");
                    getSelectionDoctorMenu(doctorUnit, patientUnit);
            }
        }
    }


}