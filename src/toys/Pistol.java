package toys;

import persons.Person;

public final class Pistol extends Toy {
    private boolean isLoaded;

    public Pistol(String name) {
        super(name, ToyType.PISTOL);
        this.isLoaded = true;
    }

    @Override
    public void use(Person user) {
        if (isLoaded) {
            System.out.println("Пистолет \"" + name + "\": БАХ! (Использует " + user.getName() + ")");
            user.funLevel += 5;
            user.stressLevel += 5;
            isLoaded = false;
        } else {
            System.out.println("Пистолет \"" + name + "\" не заряжен. " + user.getName() + " не может выстрелить.");
            user.stressLevel += 3;
        }
    }

    public void reload() {
        isLoaded = true;
        System.out.println("Пистолет \"" + name + "\" снова заряжен!");
    }
}