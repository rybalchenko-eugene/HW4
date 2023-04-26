package View;
import Model.*;
import java.util.*;
public class Menu {
    Logic model = new Logic();
    public int mainMenu(){
        /*
        14.1 Завести новое животное
14.2 определять животное в правильный класс
14.3 увидеть список команд, которое выполняет животное ЗАЧЕРКНУТО
14.4 обучить животное новым командам
14.5 Реализовать навигацию по меню
         */
        System.out.println("\n\nMAIN MENU" +
                         "\n1. Add a new animal.." +
                         "\n2. Operations with particular creature(teach new command).." +
                         "\n3. Show all animals and their characteristics in the zoo" +
                         "\nOther input - exit");
        String user_input = model.userInput();
        if (user_input.equals("1")) return 1;
        if (user_input.equals("2")) return 2;
        if (user_input.equals("3")) return 3;
        return 4;
    }
    public void showCreature(LinkedList<Creature> zoo){
        if (zoo.size() == 0) {
            System.out.println("List is empty now");
            return;
        }
        int count = 0;
        for (Creature exmp: zoo
             ) {
            GregorianCalendar date = exmp.getBirthday();
            String year = String.valueOf(date.get(date.YEAR));
            String month = String.valueOf(date.get(date.MONTH));
            String day = String.valueOf(date.get(date.DAY_OF_MONTH));
            System.out.printf("\n#%d. Class %s. Name %s. Birthday:%s-%s-%s, Trained commands - %s",
                    ++count, exmp.getMainType().toString(), exmp.getName().toString(),
                    year, month, day,
                    exmp.getCommands().toString());
        }
    }
}
