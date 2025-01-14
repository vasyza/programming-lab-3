package persons;

import toys.Toy;

import java.util.Objects;

public final class Gunilla extends Person {
    private int jealousyLevel;

    public Gunilla(String name) {
        super(name);
        this.jealousyLevel = 0;
    }

    public void checkIfItemIsPresent(Person personToCheck, Toy toy) {
        if (personToCheck.inventory.contains(toy)) {
            jealousyLevel += 10;
            System.out.println(getName() + " увидела, что у " + personToCheck.getName() +
                    " есть игрушка \"" + toy.getName() + "\", и теперь завидует! " +
                    "Зависть = " + jealousyLevel);
            this.funLevel -= 5;
        } else {
            System.out.println(getName() + " говорит: \"Да нет там ничего интересного...\"");
        }
    }

    @Override
    public void doAction() {
        System.out.println(getName() + " размышляет о том, у кого бы что подглядеть... Зависть = " + jealousyLevel);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Gunilla g)) return false;
        return jealousyLevel == g.jealousyLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jealousyLevel);
    }

    @Override
    public String toString() {
        return "Gunilla{" +
                "name='" + name + '\'' +
                ", funLevel=" + funLevel +
                ", stressLevel=" + stressLevel +
                ", jealousyLevel=" + jealousyLevel +
                ", inventory=" + inventory +
                '}';
    }
}
