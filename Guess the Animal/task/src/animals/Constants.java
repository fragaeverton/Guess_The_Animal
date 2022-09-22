package animals;

public class Constants {

    public static final String PERIOD_REGEX = "(?i)[^.!][.!a-z]$|[yn]$";

    public static final String[] YES = {"y", "yes", "yeah", "yep", "sure", "right",
            "affirmative", "correct", "indeed", "you bet", "exactly", "you said it"};

    public static final String[] NO = {"n", "no", "no way", "nah", "nope",
            "negative", "I don't think so", "yeah no"};

    public static final String[] FAREWELL_LIST = {"Goodbye", "So long", "ta ta", "Bye bye", "bye",
            "See ya", "Take care", "See you later", "Peace", "Take easy"};

    static String[] QUESTIONS_LIST= {
            "I'm not sure I caught you: was it yes or no?",
            "Funny, I still don't understand, is it yes or no?",
            "Oh, it's too complicated for me: just tell me yes or no.",
            "Could you please simply say yes or no?",
            "Oh, no, don't try to confuse me: say yes or no."};


}
