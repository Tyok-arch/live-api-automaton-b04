package utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class TokenHelper {

    public static String getToken(){

        try {

            JSONParser parser = new JSONParser();

            Object object = parser.parse(
                    new FileReader(
                            "src/main/resources/json/token.json"
                    )
            );

            JSONObject jsonObject =
                    (JSONObject) object;

            return jsonObject.get("token").toString();

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
