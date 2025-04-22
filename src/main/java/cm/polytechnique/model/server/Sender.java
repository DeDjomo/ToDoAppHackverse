package cm.polytechnique.model.server;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Sender {
    //attributs
    protected static final String URL = "http://localhost:8080/api/";

    //methode de creation d'une connexion
    private static HttpURLConnection getConnection(String url) throws Exception{
        //creation d'une connexion
        URI uri = new URI(url);
        URL urlserver = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection)urlserver.openConnection();
        return connection;
    }

    //methode d'enregistrement
    public static int  post(String json, String url) throws Exception{
        //on utilise getconnection pour etablir la connexion
        HttpURLConnection connection = getConnection(url);

        //configuration de la connexion pour le post mapping
        connection.setRequestMethod("POST");
        connection.setRequestProperty("content-type", "application/json; utf-8");
        connection.setDoOutput(true);

        // Envoi des données JSON dans le corps de la requête
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = json.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Récupérer le code de réponse HTTP (optionnel)
        int code = connection.getResponseCode();        
        connection.disconnect();
        return code;
    }
}
