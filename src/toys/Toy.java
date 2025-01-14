package toys;

import persons.Person;

import java.util.Objects;

public abstract class Toy implements Interactable {
    protected String name;
    protected ToyType toyType;

    public Toy(String name, ToyType toyType) {
        this.name = name;
        this.toyType = toyType;
    }

    public String getName() {
        return name;
    }

    public ToyType getToyType() {
        return toyType;
    }

    @Override
    public abstract void use(Person user);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy toy)) return false;
        return Objects.equals(name, toy.name) &&
                toyType == toy.toyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, toyType);
    }

    @Override
    public String toString() {
        return "Toy{name='" + name + "', type=" + toyType + "}";
    }
}