/**
 * Created by Eric on 2016/11/23.
 */
public abstract class Translator implements Comparable {
    String name;
    int votes;
    public int compareTo(Object t) {
        if(votes>((Translator)t).votes)
            return 1;
        else if(votes<((Translator)t).votes)
            return -1;
        else
            return 0;
    }
    public boolean textChecker(String text) {
        for(int i=0;i<text.length();++i) {
            if(!Character.isLetter(text.charAt(i)))
                return false;
        }
        return true;
    }
    public abstract String getTranslation(String text)throws Exception;
}
