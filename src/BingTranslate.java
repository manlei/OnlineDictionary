/**
 * Created by Eric on 2016/11/23.
 */
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
public class BingTranslate extends Translator{
    public BingTranslate(int votes) {
        name="Bing";
        this.votes=votes;
        Translate.setClientId("OnlineDictionary");
        Translate.setClientSecret("java_2rd_practice_dictionary");
    }
    public String getTranslation(String text) throws Exception{
        return Translate.execute(text,Language.ENGLISH,Language.CHINESE_SIMPLIFIED);
    }
}
