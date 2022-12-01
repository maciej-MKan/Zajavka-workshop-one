package GenericsAndCollections.Project.service;

public interface ICommandDecoder {
    ICommandDecoder decode(String input);

    String getCommand();

    String getPersonData();

    boolean checkVip();

    boolean exitCommand();

}
