package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class TokenManager {

    public static String getToken() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode jsonNode = mapper.readTree(
                    new File("src/main/resources/json/token.json")
            );

            return jsonNode.get("token").asText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}