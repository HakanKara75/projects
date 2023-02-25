package projects.hospital;
/*doktor title ve hastalis cesitleri burada olsa

 */

public enum doktorPatient {
    Basagrisi("Norolog", true),
    Diabet("Genelcerrah", false),
    Sogukalginligi("Cocukdoktoru", false),
    Migren("Dahiliye", false),
    Allerji("Allergist", false),
    Kalphastaliklari("Kardiolog", true);
    private final String titles;
    private final boolean urgency;
    public boolean isUrgency() {
        return urgency;
    }
    public String getTitles() {
       return titles;
    }

    doktorPatient(String titles, boolean urgency) {
        this.titles = titles;
        this.urgency = urgency;
    }


}
