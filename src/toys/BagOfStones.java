package toys;

import persons.Person;

import java.util.ArrayList;
import java.util.List;

public final class BagOfStones extends Toy {
    private final List<Stone> stones;

    public BagOfStones(String name, List<Stone> stones) {
        super(name, ToyType.BAG_OF_STONES);
        this.stones = (stones != null) ? stones : new ArrayList<>();
    }

    @Override
    public void use(Person user) {
        if (stones.isEmpty()) {
            System.out.println("Мешочек \"" + name + "\" пуст. " + user.getName() + " ничего не находит...");
            user.stressLevel += 1;
        } else {
            System.out.println(user.getName() + " рассматривает разноцветные камушки в \"" + name + "\":");
            for (Stone s : stones) {
                System.out.println(" - " + s.color() + " камушек, вес " + s.weight());
            }

            user.funLevel += 2;
            user.stressLevel -= 2;
        }
    }

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public void removeStone(Stone stone) {
        stones.remove(stone);
    }
}