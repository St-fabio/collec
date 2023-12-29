import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Jeu> collection = new ArrayList<>();
        collection = ReadCollec.fileexistoorempty(collection);

        char start = Utilitaire.présaisie();

        while (start != 'N') {
            if (start == 'Y') {
                Utilitaire.addtocollection(collection);
            } if (start == 'S') {
                Utilitaire.delete(collection);
            }
            start = Utilitaire.présaisie();
        }

        Utilitaire.affichefin(collection);

        Utilitaire.triCollec(collection);

        WriteCollec.Writecollec(collection);
    }
}