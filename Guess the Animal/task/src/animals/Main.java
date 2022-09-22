package animals;

import java.time.LocalTime;
import java.util.*;
import java.util.List;

import static animals.Constants.*;
import static animals.Utils.findInRegex;

public class Main {

    public static void main(String[] args) {

        LocalTime time = LocalTime.now();
        Scanner sc = new Scanner(System.in);
        System.out.println(greet(time));

        System.out.println("Enter an animal:");
        Animal animal = new Animal(sc.nextLine().split(" "));

        System.out.printf("Is it %s?\n", animal);
        checkAnimalStatus(sc.nextLine(), animal, true);

        while (animal.getStatus().equals(Animal.Status.UNCLEAR)){
            printSortedItemList(new ArrayList<>(List.of(QUESTIONS_LIST)));
            checkAnimalStatus(sc.nextLine(), animal, false);
        }
        System.out.println("You answered: " + (animal.getStatus().equals(Animal.Status.YES) ? "Yes" : "No") );
        printSortedItemList(new ArrayList<>(List.of(FAREWELL_LIST)));

    }

    private static void printSortedItemList(ArrayList<String> list) {
        Collections.shuffle(list);
        System.out.println(list.stream().findAny().get());
    }

    private static void checkAnimalStatus(String answer, Animal animal, boolean isFirstTime) {
        if(isFirstTime){
            if (existsOnCol(YES, answer) && findInRegex(answer)){
                animal.setStatus(Animal.Status.YES);
            } else if (existsOnCol(NO, answer) && findInRegex(answer)){
                animal.setStatus(Animal.Status.NO);
            }
        } else {
            try {
                animal.setStatus(Animal.Status.valueOf(answer.toUpperCase()));
            } catch (IllegalArgumentException e){
            }
        }

    }

    private static boolean existsOnCol(String[] array, String answer){
        String s = answer.replaceAll("[!.]","").toUpperCase().trim();
        return Arrays.stream(array)
                .map(String::toUpperCase)
                .anyMatch(s::equals);
    }

    private static String greet(LocalTime time) {
        String greeting;
        if (time.isAfter(LocalTime.of(5,0))
                && time.isBefore(LocalTime.of(12,0))){
            greeting = "Good morning";
        } else if (time.isAfter(LocalTime.of(12,0))
                && time.isBefore(LocalTime.of(18,0))){
            greeting = "Good afternoon";
        } else{
            greeting = "Good evening";
        }
        return greeting + "\n";
    }



}

