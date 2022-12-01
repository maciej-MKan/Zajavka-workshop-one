package GenericsAndCollections.Project.model;

public interface IPerson extends Comparable<IPerson> {
    Integer getCount();

    String getName();

    String getSurname();

    Boolean getVIP();

    int getQueueIndex();

    IPerson withCount(int count);

    IPerson withQueueIndex(int queueIndex);
}
