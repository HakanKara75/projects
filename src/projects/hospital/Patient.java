package main.batch_129.projects.hospital;

public class Patient extends DataBank{
    private String name;
    private String surname;
    private int patientID;
    private String patientCase;

    public Patient() {
    }

    public Patient(String name, String surname, String patientCase,  int patientID) {
        this.name = name;
        this.surname = surname;
        this.patientCase= patientCase;
        this.patientID = patientID;
    }

    public Patient(String patientCase,  int patientID) {

        this.patientCase = patientCase;
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatientCase() {
        return patientCase;
    }

    public void setPatientCase(String patientCase) {
        this.patientCase = patientCase;

    }public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
               ", patientCase='" + patientCase + '\'' +
                ", patientID=" + patientID +
                '}';
    }
}
