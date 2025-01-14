package toys;

import persons.Person;

public final class Car extends Toy {
    private int fuelLevel;

    public Car(String name) {
        super(name, ToyType.CAR);
        this.fuelLevel = 100;
    }

    @Override
    public void use(Person user) {
        if (fuelLevel > 0) {
            System.out.println(user.getName() + " катается на машинке \"" + name + "\": Вж-ж-ж!");
            fuelLevel -= 10;

            user.funLevel += 5;
        } else {
            System.out.println("Машинка \"" + name + "\" не может ехать — закончился бензин. " + user.getName() + " расстраивается.");
            user.stressLevel += 2;
        }
    }

    public void refuel() {
        fuelLevel = 100;
        System.out.println("Машинка \"" + name + "\" снова заправлена.");
    }
}
