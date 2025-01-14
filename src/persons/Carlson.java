package persons;

import toys.Toy;

import java.util.Objects;
import java.util.Random;

public final class Carlson extends Person {
    private int braggingLevel;

    public Carlson(String name) {
        super(name);
        this.braggingLevel = 20;
    }

    public boolean rummageIn(Person other) {
        if (other.inventory.isEmpty()) {
            System.out.println(getName() + ": у " + other.getName() + " нет игрушек, нечего брать.");
            return false;
        }

        Toy stolenToy = other.inventory.get(new Random().nextInt(other.inventory.size()));
        other.removeToy(stolenToy);
        this.addToy(stolenToy);
        System.out.println(getName() + " стащил игрушку \"" + stolenToy.getName() + "\" у " + other.getName());

        this.funLevel += 5;

        other.stressLevel += 10;
        return true;
    }

    @Override
    public void doAction() {
        if (!inventory.isEmpty()) {
            braggingLevel += 5;
            System.out.println(getName() + " хвастается своими игрушками. Уровень хвастовства: " + braggingLevel);
            System.out.println("Инвентарь: " + inventory);
        } else {
            System.out.println(getName() + " грустит, у него нет игрушек, чтобы хвастаться...");

            stressLevel += 5;
            funLevel -= 5;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Carlson k)) return false;
        return braggingLevel == k.braggingLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), braggingLevel);
    }

    @Override
    public String toString() {
        return "Karlson{" +
                "name='" + name + '\'' +
                ", funLevel=" + funLevel +
                ", stressLevel=" + stressLevel +
                ", braggingLevel=" + braggingLevel +
                ", inventory=" + inventory +
                '}';
    }
}


