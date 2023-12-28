import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        ArrayList<Jeu> collection = new ArrayList<>();
        collection = ReadCollec.fileexistoorempty(collection);

        char start;

        try {
            System.out.print("Voulez vous saisir un nouveau jeu ? (Y/N/S) ");
            start = lecteur.next().charAt(0);
        } catch (InputMismatchException e) {
            lecteur.nextLine();
            System.out.println("Mauvais type !!!");
            start = 'N';
        }

        while (start != 'N') {
            if (start == 'Y') {
                Utilitaire.addtocollection(collection);
            } if (start == 'S') {
                Utilitaire.delete(collection);
            }
            try {
                System.out.print("Voulez vous saisir un nouveau jeu ? (Y/N/S) ");
                start = lecteur.next().charAt(0);
            } catch (InputMismatchException e) {
                lecteur.nextLine();
                System.out.println("Mauvais type !!!");
                start = 'N';
            }
        }

        Utilitaire.affichefin(collection);

        Utilitaire.triCollec(collection);

        WriteCollec.Writecollec(collection);
    }
}