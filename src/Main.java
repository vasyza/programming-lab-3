import exceptions.NoToySelectedException;
import exceptions.ToyNotFoundException;
import persons.Baby;
import persons.Carlson;
import persons.Gunilla;
import toys.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Baby baby = new Baby("Малыш");
        Carlson carlson = new Carlson("Карлсон");
        Gunilla gunilla = new Gunilla("Гунилла");

        Pistol pistol = new Pistol("Самый маленький в мире пистолет");
        Car car = new Car("Маленькая машинка");
        Puzzle puzzle = new Puzzle("Игра-головоломка");
        BagOfStones bagOfStones = new BagOfStones("Мешочек с камушками", List.of(new Stone("красный", 10), new Stone("зелёный", 5)));
        ConstructorKit constructorKit = new ConstructorKit("Конструктор", new String[]{"Блок A", "Блок B", "Винтик", "Гайка"});

        baby.addToy(car);
        baby.addToy(puzzle);
        baby.addToy(constructorKit);
        baby.addToy(bagOfStones);
        baby.addToy(pistol);

        System.out.println("\n--- Исходное состояние персонажей ---");
        System.out.println(baby);
        System.out.println(carlson);
        System.out.println(gunilla);

        System.out.println("\n--- Персонажи совершают свои действия (doAction) ---");
        try {
            baby.doAction();
        } catch (NoToySelectedException e) {
            System.err.println("[Исключение] " + e.getMessage());
        }
        carlson.doAction();
        gunilla.doAction();

        gunilla.checkIfItemIsPresent(baby, pistol);

        System.out.println("\n--- Карлсон пытается стащить игрушку у Малыша ---");
        carlson.rummageIn(baby);

        gunilla.checkIfItemIsPresent(carlson, pistol);

        System.out.println("\n--- Карлсон ищет у себя \"Самый маленький в мире пистолет\" ---");
        try {
            Toy foundToy = carlson.findToyByName("Самый маленький в мире пистолет");
            System.out.println("Карлсон говорит: \"У меня теперь есть пистолет!\" -> " + foundToy);
            foundToy.use(carlson);

            foundToy.use(carlson);

            if (foundToy instanceof Pistol pistolToy) {
                pistolToy.reload();
                pistolToy.use(carlson);
            }
        } catch (ToyNotFoundException e) {
            System.err.println("[Исключение] " + e.getMessage());
        }

        System.out.println("\n--- Итоговое состояние персонажей ---");
        System.out.println(baby);
        System.out.println(carlson);
        System.out.println(gunilla);

        System.out.println("\n--- Сценарий завершён ---");
    }
}