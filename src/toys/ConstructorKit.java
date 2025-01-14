package toys;

import persons.Person;

public final class ConstructorKit extends Toy {
    private final String[] parts;

    public ConstructorKit(String name, String[] parts) {
        super(name, ToyType.CONSTRUCTOR_KIT);
        this.parts = (parts != null) ? parts : new String[0];
    }

    @Override
    public void use(Person user) {
        if (parts.length == 0) {
            System.out.println("В конструкторе \"" + name + "\" нет деталей! " + user.getName() + " расстроен.");
            user.stressLevel += 3;
        } else {
            System.out.println(user.getName() + " строит разные фигуры из конструктора \"" + name + "\". Детали:");
            for (String part : parts) {
                System.out.println("   - " + part);
            }
            user.funLevel += 5;
        }
    }
}