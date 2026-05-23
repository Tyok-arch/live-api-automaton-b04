package body.auth;

import org.json.simple.JSONObject;
import utils.ConfigReader;

public class LoginBody {

    public JSONObject loginData(){

        JSONObject data = new JSONObject();

        data.put(
                "email",
                ConfigReader.getProperty("email")
        );

        data.put(
                "password",
                ConfigReader.getProperty("password")
        );

        return data;
    }
}