package Presenter;
import Model.Creature;
import Model.Logic;
import View.Menu;
import java.util.LinkedList;
import java.util.zip.DataFormatException;
public class Presenter {
    Logic model = new Logic();
    LinkedList<Creature> zoo = new LinkedList<>();
    private Menu menu = new Menu();
    public void start() throws DataFormatException {
        int choice = 0;
        while (true){
            choice = menu.mainMenu();
            if (choice == 1) {
                Creature creature = model.newAnimal();
                if (creature != null) zoo.add(creature);
            }
            if (choice == 2) model.addCommand(zoo);
            if (choice ==3) menu.showCreature(zoo);
            if (choice ==4) {
                System.out.println("Exit");
                break;
            }
        }

    }
}