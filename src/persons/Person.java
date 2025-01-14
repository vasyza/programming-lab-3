package persons;

import exceptions.ToyNotFoundException;
import toys.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Person {
    protected String name;
    protected List<Toy> inventory;


    public int funLevel;
    public int stressLevel;

    public Person(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();

        this.funLevel = 50;
        this.stressLevel = 10;
    }

    public String getName() {
        return name;
    }

    public int getFunLevel() {
        return funLevel;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    public void addToy(Toy toy) {
        inventory.add(toy);
    }

    public void removeToy(Toy toy) {
        inventory.remove(toy);
    }


    public Toy findToyByName(String toyName) throws ToyNotFoundException {
        for (Toy toy : inventory) {
            if (toy.getName().equalsIgnoreCase(toyName)) {
                return toy;
            }
        }
        throw new ToyNotFoundException("Игрушка с именем \"" + toyName + "\" не найдена у " + this.name);
    }

    public abstract void doAction();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(name, person.name) && Objects.equals(inventory, person.inventory) && funLevel == person.funLevel && stressLevel == person.stressLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inventory, funLevel, stressLevel);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", funLevel=" + funLevel + ", stressLevel=" + stressLevel + ", inventory=" + inventory + '}';
    }
}