package GenericsAndCollections.Project.model;

import java.util.List;

public class DataContainer {

    public final static List<String> demoData = List.of(
            "ADD PERSON(Tomasz_Romański)",
            "ADD PERSON(Rafał_Adamczuk)",
            "ADD PERSON(Tomasz_Romański)",
            "ADD PERSON(Mariusz_Wilczek,VIP)",
            "ADD PERSON(Zbigniew_Ratownik)",
            "ADD PERSON(Roman_Tomaszewski,VIP)",
            "PROCESS",
            "LEAVE PERSON(Zbigniew_Ratownik)",
            "LEAVE PERSON(Tomasz_Romański_2)",
            "PROCESS",
            "PROCESS",
            "PROCESS"
    );
    public final static String help = "Command list: \n" +
            "- ADD PERSON(Example_Person) - added new person to queue\n" +
            "- ADD PERSON(Example_Person, VIP) - added person to queue with priority\n" +
            "- PROCESS - processing queue, 1st person arrive to store\n" +
            "- LEAVE PERSON(Example_Person) - the person leaving queue\n" +
            "- EXIT - quite the program\n" +
            "- DEMO - shown demo\n" +
            "\n" +
            "* - (Example_Person) is a (\"name\"_\"surname\") off person \n\n ";
    public final static String welcomeMessage = "Hello \nPlease type command or HELP to see command list\n";

    private DataContainer() {
    }
}
