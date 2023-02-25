package projects.hospital;

import java.util.*;

import static projects.hospital.Deneme.integerGirisiHataEngelleme;
import static projects.hospital.DoctorUnit.doctorList;

public class PatientUnit extends PatientAndDoctor{
    List<Patient> patientList = new ArrayList<>();
    Hospital hospital = new Hospital();
    Doctor doctor = new Doctor();
    int id = -1;
    PatientAndDoctor p=new PatientAndDoctor();



    public void addPatient() {
        Patient patient = new Patient();
        System.out.println("Hasta Adı: ");
        //   HospitalRunner.scanner.nextLine();
        patient.setName(HospitalRunner.scanner.nextLine());
        System.out.println("Hasta Soyad: ");
        patient.setSurname(HospitalRunner.scanner.next());
        HospitalRunner.scanner.nextLine();
        System.out.println("Hasta Case: ");
        patient.setPatientCase(HospitalRunner.scanner.nextLine());
        patient.setPatientID(idCreate());
        this.patientList.add(patient);
        System.out.println(this.patientList);
    }

    public Patient deletePatient() {

        System.out.println("            PATIENTS  ID's       ");
        System.out.printf("%-15s   %-10s   %-10s \n", "ID", "Name", "Surname", "Case");
        System.out.printf("%-15s   %-10s   %-10s \n", "-----", "----", "------");
        for (Patient patient : patientList) {
            System.out.printf("%-15s   %-10s   %-10s   %-10s \n", patient.getPatientID(), patient.getName(), patient.getSurname(), patient.getPatientCase());
        }
        System.out.println("Silmek istediğiniz hasta ID giriniz: ");

        id = integerGirisiHataEngelleme();

        for (Patient w : this.patientList) {
            if (w.getPatientID() == id) {
                this.patientList.remove(w);
                System.out.println(w + " silindi.");
                return w;
            }
        }
        System.out.println("Hatalı giriş yaptınız.");
        return deletePatient();
    }

    public int idCreate() {
        Patient patient = new Patient();
        int lastIdx = 0;
        lastIdx = patientList.stream().sorted(Comparator.comparing(Patient::getPatientID).reversed()).
                findFirst().
                get().getPatientID();
        patient.setPatientID(lastIdx + 111);
        System.out.println(lastIdx);
        return patient.getPatientID();
    }

    public void fillPatientList() {
        for (int i = 0; i < hospital.patientNames.length; i++) {
            Patient patient = new Patient(hospital.patientNames[i], hospital.patientSurnames[i], hospital.cases[i], hospital.patientsID[i]);
            this.patientList.add(patient);
        }
    }

    public void showPatientList() {
        System.out.println("            PATIENTS         ");
        System.out.printf("%-3s   %-10s   %-10s \n", "ID ", "Name", "Surname");
        System.out.printf("%-3s   %-10s   %-10s \n", "---", "----", "------");
        for (Patient patient : patientList) {
            System.out.printf("%-3s   %-10s   %-10s \n", patient.getPatientID(), patient.getName(), patient.getSurname());
        }
    }

    public Patient findPatientById() {

        System.out.println("Enter ID:");
        id = integerGirisiHataEngelleme();
        for (Patient patient : patientList) {
            if (patient.getPatientID() == id) {
                System.out.println(patient);
                return patient;
            }
        }
        System.out.println("Not found patient!");
        return new Patient("", "", "", 0);
    }

    public Case findPatientsCase(String actualCase) {
        Case patientCase = new Case();
        switch (actualCase.toLowerCase()) {
            case "allerji":
                patientCase.setUrgency(false);
                patientCase.setActualCase(actualCase);
                break;
            case "bas agrisi":
                patientCase.setUrgency(false);
                patientCase.setActualCase(actualCase);
                break;
            case "diabet":
                patientCase.setUrgency(false);
                patientCase.setActualCase(actualCase);
                break;
            case "soguk alginligi":
                patientCase.setUrgency(false);
                patientCase.setActualCase(actualCase);
                break;
            case "migren":
                patientCase.setUrgency(true);
                patientCase.setActualCase(actualCase);
                break;
            case "kalp hastaliklari":
                patientCase.setUrgency(true);
                patientCase.setActualCase(actualCase);
                break;
            default:
                System.out.println("Gecerli bir durum degil");
                patientCase();
        }
        return patientCase;
    }

    static String a="";
    public static Patient findPatient(String actualCase) {
        Patient patient = new Patient();
        return patient;
    }

    public Doctor patientCase() {
        DataBank c= new DataBank();
        System.out.println("Hasta Durumları: ");
        for (int i = 0; i < hospital.cases.length; i++) {
            System.out.printf("-%-7s ", hospital.cases[i] + " ");
        }
        System.out.println("\n**************************************************************************");
        System.out.println("Hasta Durumunu Giriniz");
        // HospitalRunner.scanner.nextLine(); // dummy
        Case patientCase = findPatientsCase(HospitalRunner.scanner.nextLine().toLowerCase());
        String title1=patientCase.getActualCase();

        PatDoc();

        HashMap<String, String> caseAndDoctor = new HashMap<>();
        Set<Map.Entry<String, String>> myEntries = caseAndDoctor.entrySet();

        PatientAndDoctor p=new PatientAndDoctor();


        caseAndDoctor.put("Allerji", "Allergist");
        caseAndDoctor.put("Bas agrisi", "Norolog");
        caseAndDoctor.put("Diabet", "Genel cerrah");
        caseAndDoctor.put("Soguk alginligi", "Cocukdoktoru");
        caseAndDoctor.put("Migren", "Dahiliye");
        caseAndDoctor.put("Kalp hastaliklari", "Kardiolog");


        for(Map.Entry<String,String> w : myEntries){

            if(w.getKey().equalsIgnoreCase(title1)) {
                a=w.getValue();
                System.out.println(a);
            }
        }
        for (Doctor doctor : doctorList) {
            if (doctor.getTitle().toLowerCase().equalsIgnoreCase(a)) {
                System.out.println(doctor);
            }
        }

//                switch (title1) {
//            case "allerji":
//                System.out.println("Hastanın durumu acil değil.");
//               String title = "Allergist";
//                for (Doctor doctor : doctorList) {
//                    if (doctor.getTitle().toLowerCase().equalsIgnoreCase(title)) {
//
//                        System.out.println(doctor);
//                    }
//                }
//                break;
//            case "diabet":
//                System.out.println("Hastanın durumu acil değil.");
//                title = "Genel cerrah";
//                for (Doctor doctor : doctorList) {
//                    if (doctor.getTitle().toLowerCase().equalsIgnoreCase(title)) {
//
//                        System.out.println(doctor);
//                    }
//                }
//                break;
//            case "soguk alginligi":
//                System.out.println("Hastanın durumu acil değil.");
//                title = "Cocukdoktoru";
//                for (Doctor doctor : doctorList) {
//                    if (doctor.getTitle().toLowerCase().equalsIgnoreCase(title)) {
//
//                        System.out.println(doctor);
//                    }
//                }
//                break;
//            case "migren":
//                System.out.println("Hastanın durumu acil değil.");
//                title = "Dahiliye";
//                for (Doctor doctor : doctorList) {
//                    if (doctor.getTitle().toLowerCase().equalsIgnoreCase(title)) {
//
//                        System.out.println(doctor);
//                    }
//                }
//                break;
//            case "bas agrisi":
//                System.out.println("Hastanın Durumu Acil!");
//                title = "Norolog";
//                for (Doctor doctor : doctorList) {
//                    if (doctor.getTitle().toLowerCase().equalsIgnoreCase(title)) {
//
//                        System.out.println(doctor);
//                    }
//                }
//                break;
//            case "kalp hastaliklari":
//                System.out.println("Hastanın Durumu Acil!");
//                title = "Kardiolog";
//                for (Doctor doctor : doctorList) {
//                    if (doctor.getTitle().toLowerCase().equalsIgnoreCase(title)) {
//
//                        System.out.println(doctor);
//                    }
//                }
//                break;
//            default:
//                System.out.println("Not found doctor!");
//        }
        return doctor;

    }


    public void assignmentDoctor(String actualCase) {
        Doctor doctor = new Doctor();
        if (actualCase.equalsIgnoreCase("Migren")) {
        }
    }

    public void caseAndTitle(){

    }
}