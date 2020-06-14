package parsing.jackson;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class JacksonExample {

    static void parse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        objectMapper.writeValue(new File("target/car.json"), car);

    }

    static void parse1() throws IOException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(json, Car.class);
        System.out.println(""+ car.getColor() + " " + car.getType());
    }

    static void parseLocalResource() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(new File("src/main/resources/json/car.json"), Car.class);
        System.out.println(""+ car.getColor() + " " + car.getType());
    }

    static void parseUrlResource() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = objectMapper.readValue(new URL("file:src/main/resources/json/car.json"), Car.class);
        System.out.println(""+ car.getColor() + " " + car.getType());
    }

    private static void parseWithJsonNode() throws IOException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        String color = jsonNode.get("color").asText();
        String type = jsonNode.get("type").asText();
        System.out.println(""+ color + " " + type);
    }

    private static void parseJSONToList() throws IOException {
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
       ObjectMapper objectMapper = new ObjectMapper();
        List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
        for (Car car: listCar) {
            System.out.println(""+ car.getColor() + " " + car.getType());
        }
    }

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
        parse();
        parse1();
        parseLocalResource();
        parseUrlResource();
        parseWithJsonNode();
        parseJSONToList();
        parseJSONToMap();
        parseJSONExtraValues();
        parseCustomCarSerializer();
        parseCustomCarDeserializer();
    }

    private static void parseCustomCarDeserializer() throws IOException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper.registerModule(module);
        Car car = mapper.readValue(json, Car.class);
        System.out.println(""+ car.getColor() + " " + car.getType());

    }

    private static void parseCustomCarSerializer() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("CustomCarSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Car.class, new CustomCarSerializer());
        mapper.registerModule(module);
        Car car = new Car("yellow", "renault");
        String carJson = mapper.writeValueAsString(car);
        System.out.println(carJson);
    }

    private static void parseJSONExtraValues() throws IOException {
        String jsonString
                = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car car = objectMapper.readValue(jsonString, Car.class);

        JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);
        JsonNode jsonNodeYear = jsonNodeRoot.get("year");
        String year = jsonNodeYear.asText();
        System.out.println(""+ car.getColor() + " " + car.getType()+" " + year);


    }


}

 class Car {

     private String color;
     private String type;

     public Car(){

     }

     public Car(String color, String type){
         this.color = color;
         this.type = type;
     }

     public void setColor(String color) {
         this.color = color;
     }

     public void setType(String type) {
         this.type = type;
     }

     public String getColor() {
         return color;
     }

     public String getType() {
         return type;
     }

}

class CustomCarSerializer extends StdSerializer<Car> {

    public CustomCarSerializer() {
        this(null);
    }

    public CustomCarSerializer(Class<Car> t) {
        super(t);
    }

    @Override
    public void serialize(
            Car car, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("car_brand", car.getType());
        jsonGenerator.writeEndObject();
    }
}

 class CustomCarDeserializer extends StdDeserializer<Car> {

    public CustomCarDeserializer() {
        this(null);
    }

    public CustomCarDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Car deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
        Car car = new Car();
        ObjectCodec codec = parser.getCodec();
        JsonNode node = codec.readTree(parser);

        // try catch block
        JsonNode colorNode = node.get("color");
        String type = node.get("type").asText();
        String color = colorNode.asText();
        car.setColor(color);
        car.setType(type);
        return car;
    }
}