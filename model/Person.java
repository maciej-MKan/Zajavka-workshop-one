package GenericsAndCollections.Project.model;

import java.util.Comparator;
import java.util.Objects;

public class Person implements IPerson {

    private final String name;
    private final String surname;
    private final Boolean VIP;
    private Integer count;
    private int queueIndex;

    public Person(String name, String surname, Boolean VIP) {
        this.name = name;
        this.surname = surname;
        this.VIP = VIP;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public Boolean getVIP() {
        return VIP;
    }

    @Override
    public int getQueueIndex() {
        return queueIndex;
    }

    @Override
    public IPerson withCount(int count) {
        this.count = count;
        return this;
    }

    @Override
    public IPerson withQueueIndex(int queueIndex) {
        this.queueIndex = queueIndex;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) && surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        System.out.println("hash");
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        String stringCounter = (this.count <= 1) ? "" : "_" + this.count;
        String stringIsVip = this.VIP ? " VIP" : "";
        return name + "_" + surname + stringCounter + stringIsVip;
    }

    @Override
    public int compareTo(IPerson iPerson) {
        Comparator<IPerson> comparator = Comparator
                .<IPerson, Boolean>comparing(o -> o.getVIP(), Comparator.reverseOrder())
                .thenComparingInt(o -> o.getQueueIndex());
        return comparator.compare(this, iPerson);
    }
}
