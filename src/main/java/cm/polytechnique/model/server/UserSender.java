package cm.polytechnique.model.server;

public class UserSender extends Sender{
    //attribut
    private static final String USER_URL = Sender.URL + "user";

    // envoi d'un user
    public static int postUser(String json) throws Exception{
        return post(json, USER_URL);
    }
}
