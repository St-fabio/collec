import java.io.*;
import java.util.ArrayList;

public class ReadCollec {
    public static ArrayList<Jeu> creerCollec() {
        ArrayList<Jeu> result = new ArrayList<>();
        String ligne;
        Jeu saisie;
        try (BufferedReader br = new BufferedReader(new FileReader("./Collec"))) {
            while ((ligne = br.readLine()) != null) {
                saisie = Utilitaire.splicer(ligne);
                result.add(saisie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Jeu> fileexistoorempty(ArrayList<Jeu> collec) {
        try {
            File file = new File("./collec");

            if (!file.exists()) {
                file.createNewFile();
                if (file.length() == 0) {
                    Jeu firsgame = Utilitaire.saisie();
                    collec.add(firsgame);
                }
            } else {
                if (file.length() == 0) {
                    Jeu firstgame = Utilitaire.saisie();
                    collec.add(firstgame);
                } else if (file.length() != 0) {
                    collec = creerCollec();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collec;
    }
}
