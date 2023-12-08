import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteCollec {
        public static void Writecollec(ArrayList<Jeu> listJeu) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Collec"))) {
                for (int i = 0; i < listJeu.size(); i++) {
                    writer.write(listJeu.get(i).toString());
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
