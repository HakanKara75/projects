package main.batch_129.projects.hospital;

import java.util.ArrayList;
import java.util.List;

public class PatientAndDoctor {

    private static boolean patDoc;

    private String titles;
    private String cases;
    private static boolean urgency;
    static Hospital hospital = new Hospital();
    static List<PatientAndDoctor> caseTitleUrgencyList = new ArrayList<>();
    public PatientAndDoctor(String cases, String titles, boolean urgency) {
        this.titles=titles;
        this.cases=cases;
        this.urgency=urgency;
    }

    public PatientAndDoctor() {

    }

    public static void main(String[] args) {
        PatDoc();

    }
    String a="Kardiolog";

    public static void PatDoc() {

        for (int i = 0; i < hospital.cases.length; i++) {
            PatientAndDoctor patDoc = new PatientAndDoctor(hospital.cases[i],hospital.titles[i],urgency);
            System.out.println(patDoc);
        }

    }

    public void PathDoc(){
        
    }

    public String getTitle() {
        return titles;
    }

    public void setTitle(String title) {
        this.titles = title;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public boolean isUrgency() {
        return urgency;
    }

    public void setUrgency(boolean urgency) {
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return "PatientAndDoctor{" +
                "title='" + titles + '\'' +
                ", cases='" + cases + '\'' +
                ", urgency=" + urgency +
                '}';
    }



}
