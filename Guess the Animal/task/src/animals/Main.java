package animals;

import java.time.LocalTime;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static animals.Constants.*;
import static animals.Messages.*;

public class Main {
    static Fact fact;
    public static void main(String[] args) {

        LocalTime time = LocalTime.now();
        Scanner sc = new Scanner(System.in);

        greet(time);

        askFirstAnimal();
        Animal animalOne = new Animal(sc.nextLine().split(" "));

        askSecondAnimal();
        Animal animalTwo = new Animal(sc.nextLine().split(" "));

        askingFacts(animalOne, animalTwo);
        String facts = sc.nextLine();
        boolean validFact = checkFact(facts);
        while (!validFact){
            showExamples();
            askingFacts(animalOne, animalTwo);
            facts = sc.nextLine();
            validFact = checkFact(facts);
        }

        askingFactForAnimal(animalTwo);
        String s = sc.nextLine().toUpperCase();
        while (!(s.equals("YES") || s.equals("NO"))){
            System.out.println("yes or no");
            askingFactForAnimal(animalTwo);
            s = sc.nextLine().toUpperCase();
        }
        boolean isAttribute = s.equals("YES");
        if(isAttribute){
            animalTwo.setAttribute(fact);
            fact.negateVerb();
            animalOne.setAttribute(fact);
        }else{
            animalOne.setAttribute(fact);
            fact.negateVerb();
            animalTwo.setAttribute(fact);
        }

        printFacts(animalOne, animalTwo);
        showSkills(fact);
        printSortedItemList(new ArrayList<>(List.of(FAREWELL_LIST)));

    }

    private static boolean checkFact(String f) {
        Pattern pattern = Pattern.compile("(It can|It has|It is)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(f);
        boolean m = matcher.find();
        if(m){
            fact = new Fact(f.substring(matcher.start() + 3).trim());
        }
        return m;
    }

    private static void printSortedItemList(ArrayList<String> list) {
        Collections.shuffle(list);
        System.out.println(list.stream().findAny().get());
    }


}

