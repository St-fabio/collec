import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
    public static Jeu saisie() {
        Scanner lecteur = new Scanner(System.in);

        String nom, console, version, lien;
        float prix;

        System.out.print("Nom du jeu : ");
        nom = lecteur.nextLine();

        System.out.print("Console : ");
        console = lecteur.nextLine();

        System.out.print("Version (Pal, Jap, US) : ");
        version = lecteur.nextLine();

        lien = link(nom, console, version);

        prix = PriceSearch.priceSearching(lien);

        Jeu saisie = new Jeu(nom, console, version, prix, lien);

        return saisie;
    }

    public static void addtocollection(ArrayList<Jeu> collec) {
        Jeu saisie = saisie();

        if (alreadyincollec(saisie, collec)) {
            System.out.println("Jeu déja dans la collection !!!");
        } else if (saisie.getPrix() == -1.0f) {
            System.out.println("Jeu inéxistant !!!");
        } else {
            collec.add(saisie);
        }
    }

    public static String console(String nomConsole) {
        String truConsole = "";
        if (nomConsole.equalsIgnoreCase("GBA")) {
            truConsole = "gameboy-advance";
        }
        if (nomConsole.equalsIgnoreCase("GBC")) {
            truConsole = "gameboy-color";
        }
        if (nomConsole.equalsIgnoreCase("GB")) {
            truConsole = "gameboy";
        }
        if (nomConsole.equalsIgnoreCase("GC")) {
            truConsole = "gamecube";
        }
        if (nomConsole.equalsIgnoreCase("NDS")) {
            truConsole = "nintendo-ds";
        }
        if (nomConsole.equalsIgnoreCase("3DS")) {
            truConsole = "nintendo-3ds";
        }
        if (nomConsole.equalsIgnoreCase("WII")) {
            truConsole = "wii";
        }
        if (nomConsole.equalsIgnoreCase("NES")) {
            truConsole = "nes";
        }
        if (nomConsole.equalsIgnoreCase("SNES")) {
            truConsole = "super-nintendo";
        }
        if (nomConsole.equalsIgnoreCase("N64")) {
            truConsole = "nintendo-64";
        }
        return truConsole;
    }

    public static String link(String nom, String console, String version) {
        String trunom = nom.replace(' ', '-');

        String truconsole = console(console);

        String truversion = version.toLowerCase();

        return "https://www.pricecharting.com/fr/game/" + truversion + "-" + truconsole + "/" + trunom;
    }

    public static String extractPrice(String html) {
        String priceStart = "<span class=\"price js-price\">";
        String priceEnd = "</span>";

        int startIndex = html.indexOf(priceStart);
        if (startIndex != -1) {
            startIndex += priceStart.length();
            int endIndex = html.indexOf(priceEnd, startIndex);
            if (endIndex != -1) {
                return html.substring(startIndex, endIndex).trim();
            }
        }

        return "Prix non trouvé";
    }
    public static Jeu splicer(String unJeu) {
        String nom, console, version, lien;
        float prix;

        int i = 0;
        while (unJeu.charAt(i) != ',') {
            i++;
        }
        nom = unJeu.substring(0, i);
        unJeu = unJeu.substring(i + 1);

        i = 0;
        while (unJeu.charAt(i) != ',') {
            i++;
        }
        console = unJeu.substring(1, i);
        unJeu = unJeu.substring(i + 1);

        i = 0;
        while (unJeu.charAt(i) != ',') {
            i++;
        }
        version = unJeu.substring(1, i);

        lien = link(nom, console, version);

        prix = PriceSearch.priceSearching(lien);

        return new Jeu(nom, console, version, prix, lien);
    }

    public static float prixCollec(ArrayList<Jeu> collec) {
        float prixtotal = 0.0f;
        for (int i = 0; i < collec.size(); i++) {
            prixtotal =  prixtotal + collec.get(i).getPrix();
        }
        return prixtotal;
    }

    public static boolean alreadyincollec(Jeu unJeu, ArrayList<Jeu> collec) {
        boolean existincollec = false;
        for (int i = 0; i < collec.size(); i++) {
            if (unJeu.getLien().equals(collec.get(i).getLien())) {
                existincollec = true;
            }
        }
        return existincollec;
    }

    public static void delete( ArrayList<Jeu> collec) {
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Nom du jeu a supprimer : ");
        String nomJeu = lecteur.nextLine();

        System.out.print("console : ");
        String console = lecteur.nextLine();

        System.out.print("version : ");
        String version = lecteur.nextLine();

        String liensuppr = link(nomJeu, console, version);

        for (int i = 0; i < collec.size(); i++) {
            if (liensuppr.equals(collec.get(i).getLien())) {
                collec.remove(i);
                System.out.println("Jeu supprimé de la collection !!!");
            }
        }
    }

    public static void triCollec(ArrayList<Jeu> collec) {
        if (collec.size() > 1) {
            boolean permut = true;
            int j = 0;

            while (permut) {
                permut = false;
                int i = collec.size() - 1;
                while (i > j) {
                    if (collec.get(i-1).getConsole().compareTo(collec.get(i).getConsole()) > 0) {
                        Jeu temp = collec.get(i-1);
                        collec.set(i - 1, collec.get(i));
                        collec.set(i, temp);
                        permut = true;
                    }
                    i--;
                }
                j++;
            }
        }
    }

}
