package GenericsAndCollections.Project;

import GenericsAndCollections.Project.model.DataContainer;
import GenericsAndCollections.Project.service.StoreQueue;
import GenericsAndCollections.Project.service.CommandDecoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QueueSimulator {

    public static void main(String[] args) {

        StoreQueue storeQueue = new StoreQueue();
        Scanner scanner = new Scanner(System.in);
        CommandDecoder commandDecoder = new CommandDecoder();
        List<String> commandsList = new LinkedList<>();

        System.out.println(DataContainer.welcomeMessage);
        while (!commandDecoder.exitCommand()) {
            commandDecoder.decode(commandsList.isEmpty() ? scanner.nextLine() : getDemoCommand(commandsList));
            String command = commandDecoder.getCommand();

            try {
                switch (command) {
                    case "ADD PERSON": {
                        storeQueue.addNewPerson(commandDecoder.getPersonData(), commandDecoder.checkVip());
                        break;
                    }
                    case "LEAVE PERSON": {
                        storeQueue.leavePerson(commandDecoder.getPersonData());
                        break;
                    }
                    case "PROCESS": {
                        storeQueue.processQueue();
                        break;
                    }
                    case "DEMO": {
                        commandsList.addAll(DataContainer.demoData);
                        break;
                    }
                    case "HELP": {
                        System.out.println(DataContainer.help);
                        break;
                    }
                    case "EXIT": {
                        throw new RuntimeException("BYE");
                    }
                    default: {
                        throw new RuntimeException("O co ci chodzi? " + command);
                    }
                }
                storeQueue.printQueueState();
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage() + "\n");
            }

        }
    }

    private static String getDemoCommand(List<String> commandsList) {
        String command = commandsList.remove(0);
        try {
            TimeUnit.MILLISECONDS.sleep(500L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(command);
        return command;
    }
}
