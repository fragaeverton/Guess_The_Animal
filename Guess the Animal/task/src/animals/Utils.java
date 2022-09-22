package animals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static animals.Constants.PERIOD_REGEX;

public class Utils {

    public static boolean findInRegex(String s){
        Pattern p = Pattern.compile(PERIOD_REGEX);
        Matcher m = p.matcher(s.trim());
        return m.find();
    }
}
