package cm.polytechnique.model.server;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private int state;

    public Task(String title, String description, LocalDate start, LocalDate end, int state){
        this.title = title;
        this.description =  description;
        this.start = start;
        this.end = end;
        this.state = state;
    }

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}
    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}
    public LocalDate getStart(){return this.start;}
    public void setStart(LocalDate start){this.start = start;}
    public LocalDate getEnd(){return this.end;}
    public void setEnd(LocalDate end){this.end = end;}
    public int getState(){return this.state;}
    public void setState(int state){this.state = state;}
}
