package cm.polytechnique.model.server;

public class Formatter {
    public static String formatUser(User user){
        String json = String.format("{\"name\":\"%s\", \"email\":\"%s\", \"password\":\"%s\"}", escapeJson(user.getName()),
        escapeJson(user.getEmail()),
        escapeJson(user.getPassword()));

        return json;
    }

    //formattage d'une tache
    public static String formatTask(Task task){
        User user = new User("nom", "mail", "passe");
        String userjson = formatUser(user);
        String json = String.format("{\"title\":\"%s\", \"description\":\"%s\", \"start\":\"%s\", \"end\":\"%s\", \"user\":%s}", 
        escapeJson(task.getTitle()),
        escapeJson(task.getDescription()),
        escapeJson(task.getStart().toString()),
        escapeJson(task.getEnd().toString()),
        userjson);

        return json;
    }

    //formattage d'une team
    public static String formatTeam(Team team){
        User user = new User("nom", "mail", "passe");
        String userjson = formatUser(user);
        String json = String.format("{\"name\":\"%s\", \"description\":\"%s\", \"user\":%s}", escapeJson(team.getName()),
        escapeJson(team.getDescription()), userjson);
        return json;    
    }

    //formattage d'un projet personnel
    public static String formatPersonnalProject(PersonnalProject project){
        User user = new User("nom", "mail", "passe");
        String userjson = formatUser(user);
        String json = String.format("{\"name\":\"%s\", \"description\":\"%s\", \"start\":\"%s\", \"end\":\"%s\", \"user\":%s}", escapeJson(project.getName()),
        escapeJson(project.getDescription()),
        escapeJson(project.getStart().toString()),
        escapeJson(project.getEnd().toString()),
        userjson);

        return json;
    }
    // Méthode simple pour échapper les guillemets dans JSON (basique)
    private static String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }

}
