package cm.polytechnique.model.server;

public class TeamSender extends Sender{
    //attribut
    private static final String USER_URL = Sender.URL + "team";

    // envoi d'une team
    public static int postTeam(String json) throws Exception{
        return post(json, USER_URL);
    }
}
