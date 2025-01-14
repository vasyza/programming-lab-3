package toys;

import persons.Person;

public final class Puzzle extends Toy {
    private boolean isSolved;

    public Puzzle(String name) {
        super(name, ToyType.PUZZLE);
        this.isSolved = false;
    }

    @Override
    public void use(Person user) {
        if (!isSolved) {
            System.out.println(user.getName() + " решает игру-головоломку \"" + name + "\" и добивается успеха!");
            isSolved = true;
            user.funLevel += 10;
            user.stressLevel -= 5;
        } else {
            System.out.println("Игра-головоломка \"" + name + "\" уже решена. " + user.getName() + " теряет интерес.");
            user.funLevel -= 1;
        }
    }
}