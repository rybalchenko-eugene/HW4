package Model;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.zip.DataFormatException;
public class Logic {
    public String userInput(){
        Scanner in = new Scanner(System.in);
        String user_input = in.nextLine();
        return user_input;
    }
    public Creature newAnimal() throws DataFormatException {
        GregorianCalendar date = new GregorianCalendar();
        mainType type;
        domesticType subtype1 = null;
        packAnimalsType subtype2 = null;
        StringBuilder commands;

        //set name
        System.out.println("Create new animal. Input a name: ");
        String name = userInput();
        //set birthday
        System.out.println("Input a year of birthday (not less 2000)");
        try (Counter ch = new Counter()){
            int year = Integer.parseInt(userInput());
            System.out.println("Input a month of birthday (not more 12)");
            int month = Integer.parseInt(userInput());
            if (month > 12 || month <1) throw  new DataFormatException();
            System.out.println("Input a day of month (not more 31)");
            int day = Integer.parseInt(userInput());
            if(checkdate(year, month, day)) {
                date.set(year, month-1, day);
                System.out.printf("%d-%d-%s%n", date.get(date.YEAR), date.get(date.MONTH), date.get(date.DAY_OF_MONTH));
                ch.add();
            }

            else throw new DataFormatException();
        } catch (NumberFormatException var6) {
            System.out.println("Wrong symbols, try again");
            return null;
        } catch (DataFormatException var6){
            System.out.println("Wrong calendar, try again");
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        //set classification
        System.out.println("Choose main type:" +
                "\n1. Domestic pet" +
                "\n2. Pack animal");

        String user_input = userInput();
        if(user_input.equals("1")) {
            type = mainType.DomesticType;
            int num = 0;
            for (Model.domesticType exmp : Model.domesticType.values()
            ) {
                System.out.println((num++ + 1) + "." + exmp);
            }
            user_input = userInput();
            if (user_input.equals("1")) subtype1 = domesticType.Dogs;
            if (user_input.equals("2")) subtype1 = domesticType.Cats;
            if (user_input.equals("3")) subtype1 = domesticType.Hamsters;

            CreatureDom res = new CreatureDom(subtype1, name, date);

            return res;
        }
        if(user_input.equals("2")) {
            type = mainType.PackAnimalType;
            int num = 0;
            for (Model.packAnimalsType exmp : Model.packAnimalsType.values()
            ) {
                System.out.println((num++ + 1) + "." + exmp);
            }
            user_input = userInput();
            if (user_input.equals("1")) subtype2 = packAnimalsType.Camels;
            if (user_input.equals("2")) subtype2 = packAnimalsType.Horses;
            if (user_input.equals("3")) subtype2 = packAnimalsType.Donkeys;

            CreaturePack res = new CreaturePack(subtype2, name, date);
            return res;
        }
        System.out.println("No such class, nothing added");
        return null;
    }
    public void addCommand(LinkedList<Creature> zoo) {
        int length = zoo.size();
        int count = 0;
        if (length != 0) {
            System.out.println("Input number of creature from 1 to "+length);
            try {
                int number = Integer.parseInt(userInput()) - 1;
                for (Creature exmp : zoo
                ) {
                    if (count++ == number) {
                        System.out.println("Input new command to learn..");
                        String command = userInput() + " ";
                        exmp.setCommands(new StringBuilder(command));
                    }
                }
            } catch (NumberFormatException v1) {
                System.out.println("Wrong input");
                return;
            } catch (NullPointerException v2) {
                System.out.println("NullPointerException");
                return;
            } catch (IndexOutOfBoundsException v3){
                System.out.println("IndexOutOfBounds");
                return;
            }
        } else {
            System.out.println("List is empty");
            return;
        }
    }
    public boolean checkdate(int year, int month, int day){
        GregorianCalendar now = new GregorianCalendar();
        GregorianCalendar date = new GregorianCalendar(year, month-1, day);
        boolean check = true;
        if (year < 2000){
            System.out.println("Date in future");
            check = false;
        }
        if (date.after(now)) {
            System.out.println("Date in future");
            check = false;
        }
        if (month <1 || month > 12) {
            System.out.println("Wrong month");
            check = false;
        }

        //check february
        if (month == 2){
            if (date.isLeapYear(year)){
                if (day > 29) {
                    System.out.println("February day incorrect");
                    check = false;
                }
            }
            else if (day>28){
                System.out.println("February day incorrect");
                check = false;
            }
        }
        if (day < 1){
            System.out.println("Day too small");
            check = false;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            if (day >31) {
                System.out.println("Day too big");
                check = false;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11){
            if (day >30) {
                System.out.println("Day too big");
                check = false;
            }
        }
        return check;
    }
}
