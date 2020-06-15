package parsing.jackson.annotations;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonAnnotationsExample {

    private static void parseJSONToMap() throws JsonProcessingException {

        ExtendableBean bean = new ExtendableBean("My bean");
        bean.getProperties().put("attr1", "val1");
        bean.getProperties().put("attr2", "val2");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        parseJSONToMap();
        setCustomGetterName();
    }

    private static void setCustomGetterName()
         throws JsonProcessingException {
        MyBean bean = new MyBean(1, "My bean");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

}

  class ExtendableBean {
    public String name;
    private Map<String, String> properties;

     public ExtendableBean(String my_bean) {
         this.name = my_bean;
         this.properties = new HashMap<>();
     }

     @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
//@JsonPropertyOrder({ "name", "id", "what is the type", "num"})
@JsonPropertyOrder(alphabetic=true)
class MyBean {
     public int id;
     private String name;
     @JsonProperty("what is the type")
     private String type;

     @JsonProperty
     private int num = 9;

    @JsonRawValue
     public String json;

     @JsonIgnore
     public boolean hidden = true;

     public MyBean(int id, String name) {
         this.id = id;
         this.name = name;
         this.type = "Awesome";
     }

     @JsonGetter("name")
     public String getTheName() {
         return name;
     }


 }
