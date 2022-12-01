package GenericsAndCollections.Project.service;

public class CommandDecoder implements ICommandDecoder {

    private String command;
    private String personData;
    private Boolean isVip;
    private boolean exit;

    @Override
    public ICommandDecoder decode(String input) {
        if (input.toUpperCase().startsWith("ADD PERSON(") || input.toUpperCase().startsWith("LEAVE PERSON(")) {
            decodePersonProcess(input);
        } else if ("PROCESS".equalsIgnoreCase(input)) {
            decodeQueueProcess();
        } else if ("EXIT".equalsIgnoreCase(input)) {
            decodeExitCommand();
        } else if ("DEMO".equalsIgnoreCase(input)) {
            decodeDemoCommand();
        } else if ("HELP".equalsIgnoreCase(input)) {
            decodeHelpCommand();
        } else {
            decodeError(input);
        }
        return this;
    }

    private void decodePersonProcess(String input) {
        try{
            command = input.substring(0, input.indexOf("(")).toUpperCase();
            personData = input.substring(
                    input.indexOf("(") + 1,
                    input.contains(",") ? input.indexOf(",") : input.indexOf(")")
            );
            isVip = input.contains("VIP");
        } catch (RuntimeException ex){
            decodeError(input);
        }

    }

    private void decodeQueueProcess() {
        command = "PROCESS";
        personData = null;
        isVip = null;
    }

    private void decodeExitCommand() {
        exit = true;
        command = "EXIT";
        personData = null;
        isVip = null;
    }

    private void decodeHelpCommand() {
        command = "HELP";
        personData = null;
        isVip = null;
    }

    private void decodeDemoCommand() {
        command = "DEMO";
        personData = null;
        isVip = null;
    }

    private void decodeError(String input) {
        command = input;
        personData = null;
        isVip = null;
    }

    @Override
    public String getCommand() {
        return command;
    }

    @Override
    public String getPersonData() {
        return personData;
    }

    @Override
    public boolean checkVip() {
        return isVip;
    }

    @Override
    public boolean exitCommand() {
        return exit;
    }
}
