package GenericsAndCollections.Project.service;

public interface IStoreQueue {

    void addNewPerson(String personData, boolean isVip);

    void leavePerson(String personData);

    void processQueue();

    void printQueueState();
}
