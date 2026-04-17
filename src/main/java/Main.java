import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать на гонку 24 часа Ле-Мана!\n" +
                "Правила гонки такие: у всех 3 машин есть 24 часа, и кто проедет" +
                " за них большую дистанцию — тот и победил. Но победить сможет только один!");

        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            String name = scanName(i, scanner);
            int speed = scanSpeed(i, scanner);
            Car car = new Car(name, speed);
            race.calculateDistance(car);
        }
        System.out.println("Наш победитель гонки: " + race.raceLeader + "!\n" +
                "Он проехал " + race.winnerDistance + "км за сутки!");
    }
    static String scanName (int carNumber, Scanner scanner) {
        System.out.println("Введите название машины №" + carNumber);
        String name = scanner.nextLine();
        while (name.trim().isEmpty()) {
            System.out.println("Ошибка. Поле не может быть пустым. Введите название ещё раз:");
            name = scanner.nextLine();
        }
        return name;
    }

    static int scanSpeed(int carNumber, Scanner scanner) {
        System.out.println("Введите скорость машины №" + carNumber);
        int speed;
        while (true) {
            if (scanner.hasNextInt()) {
                speed = scanner.nextInt();

                if (speed > 0 && speed <= 250) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Скорость должна быть больше 0 и меньше 250. Попробуйте ещё раз:");
                }
            } else {
                System.out.println("Ошибка: введите целое число!");
                scanner.next();
            }
        }
        return speed;
    }
}

class Car {

    String name;
    int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}
class Race {
    String raceLeader = "";
    int winnerDistance = 0;

    void calculateDistance(Car car) {
        int distance = car.speed * 24;
        if (distance > winnerDistance) {
            winnerDistance = distance;
            raceLeader = car.name;
        }
    }
}