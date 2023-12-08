import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PriceSearch {
    public static float priceSearching(String lien) {
        String html;

        try {
            // Créez une URL et ouvrez une connexion HTTP
            URL obj = new URL(lien);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Configurez la méthode de la requête (GET par défaut)
            con.setRequestMethod("GET");

            // Obtenez la réponse en utilisant un BufferedReader
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();

            // Analysez le contenu HTML pour extraire le prix
            html = content.toString();
            String price = Utilitaire.extractPrice(html).substring(1);
            float truprice = 0.0f;
            if (price.equals("rix non trouvé")) {
                return -1.0f;
            } else {
                truprice = Float.parseFloat(price);
            }


            // Fermez la connexion
            con.disconnect();

            return truprice;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1.0f;
    }
}
