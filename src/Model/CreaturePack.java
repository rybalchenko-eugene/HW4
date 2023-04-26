package Model;

import java.util.GregorianCalendar;

public class CreaturePack extends Creature{
    private packAnimalsType subType;
    public CreaturePack(packAnimalsType subType, String name, GregorianCalendar date) {
        super(name, date);
        this.mainType = Model.mainType.PackAnimalType;
        this.subType = subType;
    }
}
