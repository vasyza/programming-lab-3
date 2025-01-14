package persons;

import exceptions.NoToySelectedException;
import toys.Toy;
import toys.ToyType;

import java.util.Random;

public final class Baby extends Person {
    public Baby(String name) {
        super(name);
    }

    @Override
    public void doAction() {
        if (inventory.isEmpty()) {
            throw new NoToySelectedException("У Малыша нет игрушек, чтобы что-то показать!");
        }

        boolean hasPistol = inventory.stream().anyMatch(t -> t.getToyType() == ToyType.PISTOL);
        if (hasPistol) {
            stressLevel += 10;
            System.out.println(getName() + " беспокоится из-за пистолета в ящике. Стресс теперь = " + stressLevel);
        }

        Random random = new Random();
        if (random.nextBoolean()) {
            Toy randomToy = inventory.get(random.nextInt(inventory.size()));
            System.out.println(getName() + " решил показать игрушку: " + randomToy.getName());
            randomToy.use(this);
        } else {
            System.out.println(getName() + " сегодня не хочет ничего показывать... Уровень веселья: " + funLevel);
        }
    }
}
