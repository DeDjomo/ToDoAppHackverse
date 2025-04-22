package cm.polytechnique.model.server;

public class SingleTaskSender extends Sender{
    //attribut
    private static final String USER_URL = Sender.URL + "singletask";
    public static int postTask(String json) throws Exception{
        return post(json, USER_URL);
    }
}
