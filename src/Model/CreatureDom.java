package Model;

import java.util.GregorianCalendar;

public class CreatureDom extends Creature {

    private domesticType subType;

    public CreatureDom(domesticType subType, String name, GregorianCalendar date) {
        super(name, date);
        this.mainType = Model.mainType.DomesticType;
        this.subType = subType;
    }
}
