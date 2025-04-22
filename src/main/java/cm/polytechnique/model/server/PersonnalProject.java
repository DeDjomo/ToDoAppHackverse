package cm.polytechnique.model.server;

import java.time.LocalDate;

public class PersonnalProject {
    private String name;
    private String description;
    private LocalDate start;
    private LocalDate end;

    public PersonnalProject(String name, String description, LocalDate start, LocalDate end){
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    //getters et setters
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public LocalDate getStart(){return this.start;}
    public LocalDate getEnd(){return this.end;}
    public void setName(String name){this.name = name;}
    public void setDescription(String description){this.description = description;}
    public void setStart(LocalDate start){this.start = start;}
    public void setEnd(LocalDate end){this.end = end;}
}
