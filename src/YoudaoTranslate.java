import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Eric on 2016/11/23.
 */
public class YoudaoTranslate extends Translator {
    public YoudaoTranslate(int votes) {
        name="Youdao";
        this.votes=votes;
    }
    public String getTranslation(String text) throws Exception{
        URL url=new URL("http://fanyi.youdao.com/openapi.do");
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.addRequestProperty("encoding","UTF-8");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        OutputStream os=connection.getOutputStream();
        OutputStreamWriter osw=new OutputStreamWriter(os);
        BufferedWriter bw=new BufferedWriter(osw);

        bw.write("keyfrom=SocialDic&key=1251033521&type=data&doctype=json&version=1.1&q="+text);
        bw.flush();

        InputStream is=connection.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"UTF-8");
        BufferedReader br=new BufferedReader(isr);

        String line;
        StringBuilder sb=new StringBuilder();
        while((line=br.readLine())!=null) {
            sb.append(line);
            sb.append('\n');
        }

        bw.close();
        osw.close();
        os.close();
        br.close();
        isr.close();
        is.close();

        String jsonStr=sb.toString();
        JSONObject jsonObj=(JSONObject)new JSONParser().parse(jsonStr);
        if("0".equals(jsonObj.get("errorCode").toString())) {
            jsonStr=jsonObj.get("translation").toString();
        }
        return jsonStr.substring(2,jsonStr.length()-2);
    }
}
