package parsing.jackson.annotations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JacksonAnnotationsExample {

    private static void parseJSONToMap() throws IOException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map
                = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
        for(String key : map.keySet()){
            System.out.println("" + map.get(key));
        }
    }

    public static void main(String[] args) throws IOException {
        parseJSONToMap();
    }
}
