package cm.polytechnique.model.server;

public class PersonnalProjectSender extends Sender{
    //attribut
    private static final String USER_URL = Sender.URL + "personnalproject";

    // envoi d'une team
    public static int postTeam(String json) throws Exception{
        return post(json, USER_URL);
    }   
}
