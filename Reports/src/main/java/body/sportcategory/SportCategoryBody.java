package body.sportcategory;

import org.json.simple.JSONObject;

public class SportCategoryBody {

    public JSONObject createSportCategoryData(String name){

        JSONObject data = new JSONObject();

        data.put("name", name);

        return data;
    }
}