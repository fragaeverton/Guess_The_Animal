package animals;

import java.util.stream.IntStream;

public class Animal {
    public static final String VOWEL = "^[aeyio]+$";
    private String article;
    private String name;
    private Status status;
    private String attribute;

    public Animal(String[] answer) {
        this.name = setName(answer);
        this.article = setArticle(answer);
        this.status = Status.UNCLEAR;
    }

    public String setArticle(String[] answer) {
        String article;
        if ("a".equalsIgnoreCase(answer[0])) {
            article = "a";
        } else
        if ("an".equalsIgnoreCase(answer[0])) {
            article = "an";
        } else
        if(String.valueOf(name.charAt(0)).matches(VOWEL)){
            article = "an";
        } else {
            if(String.valueOf(name.charAt(0)).matches("h")
                    && String.valueOf(name.charAt(0)).matches(VOWEL)){
                article = "an";
            }else{
                article = "a";
            }
        }
        return article;
    }

    public String getName() {
        return name;
    }

    public String setName(String[] answer) {
        StringBuilder sb = new StringBuilder();
        if ("an".equalsIgnoreCase(answer[0])
                || "a".equalsIgnoreCase(answer[0])
                || "the".equalsIgnoreCase(answer[0])) {
            IntStream.rangeClosed(1, answer.length - 1)
                    .forEach(s -> sb.append(" ").append(answer[s]));
        } else{
            IntStream.rangeClosed(0, answer.length - 1)
                    .forEach(s -> sb.append(" ").append(answer[s]));
        }
        return sb.toString().toLowerCase().trim();
    }

    public String getArticleName() {
        return article + " " + name;
    }

    public void setAttribute(Fact facts) {
        this.attribute = facts.getFullAttributes();
    }

    @Override
    public String toString() {
        return " - The " + name + " " + attribute;
    }


    public enum Status{
        YES, NO, UNCLEAR
    }
}

