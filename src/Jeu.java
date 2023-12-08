public class Jeu {
    private String nom;
    private String console;
    private String version;
    private float prix;
    private String lien;

    public Jeu(String nom, String console, String version, float prix, String lien) {
        this.nom = nom;
        this.console = console;
        this.version = version;
        this.prix = prix;
        this.lien =  lien;
    }

    public String getNom() {
        return nom;
    }

    public String getConsole() {
        return console;
    }

    public String getVersion() {
        return version;
    }

    public float getPrix() {
        return prix;
    }

    public String getLien() {
        return lien;
    }

    @Override
    public String toString() {
        return nom + ", " + console + ", " + version + ", " + prix + ", " + lien;
    }
}
