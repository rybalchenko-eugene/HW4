package Model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Creature {
    mainType mainType;
    String name;
    GregorianCalendar birthday;
    StringBuilder commands ;
    // Getters & Setters:
    public Model.mainType getMainType() {
        return mainType;
    }
    public String getName() {
        return name;
    }
    public GregorianCalendar getBirthday() {
        return birthday;
    }
    public StringBuilder getCommands() {
        return commands;
    }
    public void setCommands(StringBuilder command) {
        this.commands = this.commands.append(command);
    }
    Creature(String name, GregorianCalendar date) {
        this.name = name;
        this.birthday = date;
        this.commands = new StringBuilder("");
    }
}
