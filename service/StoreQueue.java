package GenericsAndCollections.Project.service;

import GenericsAndCollections.Project.model.IPerson;
import GenericsAndCollections.Project.model.Person;

import java.util.PriorityQueue;
import java.util.Queue;

public class StoreQueue implements IStoreQueue {
    private final Queue<IPerson> queue = new PriorityQueue<>();
    private int queueIndex;

    public StoreQueue() {
        this.queueIndex = 0;
    }

    @Override
    public void addNewPerson(String personData, boolean isVip) {
        String[] splitPersonData = getSplitPersonData(personData);
        String name = splitPersonData[0];
        String surname = splitPersonData[1];
        Person newPerson = new Person(name, surname, isVip);
        int personCounter = getMaxCountSimulaPerson(newPerson);
        if (!queue.add(newPerson.withCount(personCounter).withQueueIndex(queueIndex))) {
            throw new RuntimeException(personData + " can't came to queue");
        }
        queueIndex++;
        System.out.println(newPerson + " came to the queue: true");
    }

    @Override
    public void leavePerson(String personData) {
        String[] splitPersonData = getSplitPersonData(personData);
        String name = splitPersonData[0];
        String surname = splitPersonData[1];
        try {
            Integer count = splitPersonData.length == 3 ? Integer.parseInt(splitPersonData[2]) : 1;
            if (!queue.removeIf(person -> person.getName().equals(name) && person.getSurname().equals(surname) && person.getCount().equals(count))) {
                throw new RuntimeException("Something wrong " + personData + " can't leave queue");
            }
        } catch (NumberFormatException ex){
            throw new RuntimeException("Wrong person data " + personData);
        }
        System.out.println("Leaving queue: " + personData);
    }

    private static String[] getSplitPersonData(String personData) {
        String[] splitPersonData = personData.split("[ _]");
        if (splitPersonData.length < 2 || splitPersonData.length > 3){
            throw new RuntimeException("Wrong person data " + personData);
        }
        return splitPersonData;
    }

    @Override
    public void processQueue() {
        IPerson person = queue.poll();
        if (person == null) {
            throw new RuntimeException("Queue is empty");
        }
        System.out.println("Processing queue: " + person + " arrived at the store");
    }

    @Override
    public void printQueueState() {
        System.out.println("Queue: " + queue + "\n");
    }

    private int getMaxCountSimulaPerson(Person newPerson) {
        int personCounter = 1;
        for (IPerson person : queue) {
            if (person.equals(newPerson)) {
                if (person.getCount() >= personCounter) {
                    personCounter = person.getCount() + 1;
                }
            }
        }
        return personCounter;
    }
}
