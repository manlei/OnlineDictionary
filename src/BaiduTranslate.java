/**
 * Created by Eric on 2016/11/23.
 */
public class BaiduTranslate extends Translator{
    public BaiduTranslate(int votes) {
        name="Baidu";
        this.votes=votes;
    }
    public WORD getTranslation(String text)throws Exception {
        // TODO: 2016/11/23
        // finish the function
        WORD wd=new WORD();
        wd.word=text;
        wd.ukPhonetic="";
        wd.usPhonetic="";
        return wd;
    }
}
