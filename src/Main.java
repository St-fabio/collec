import jdk.jshell.execution.Util;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        ArrayList<Jeu> collection = new ArrayList<>();
        collection = ReadCollec.fileexistoorempty(collection);

        System.out.print("Voulez vous saisir un nouveau jeu ? (Y/N/S) ");
        char start = lecteur.next().charAt(0);

        while (start != 'N') {
            if (start == 'Y') {
                Utilitaire.addtocollection(collection);
            } if (start == 'S') {
                Utilitaire.delete(collection);
            }
            System.out.print("Voulez vous saisir un nouveau jeu ? (Y/N/S) ");
            start = lecteur.next().charAt(0);
        }

        Utilitaire.prixCollec(collection);

        Utilitaire.JeuPlusCher(collection);

        Utilitaire.triCollec(collection);

        WriteCollec.Writecollec(collection);
    }
}