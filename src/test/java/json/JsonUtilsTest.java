package json;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
* JsonUtils Tester. 
* 
* @author <Authors name> 
*/ 
public class JsonUtilsTest { 
    @Test
    public void testDeserialize() throws IOException {
        String json = FileUtils.readFileToString(new File("src/test/resources/data1.json"));
        List<Item> list = JsonUtils.parseList(json, Item.class);
        System.out.println(list.size());
    }

    static class Item {
        private String type_id;
        private String property_value;
        private String type_name;

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getProperty_value() {
            return property_value;
        }

        public void setProperty_value(String property_value) {
            this.property_value = property_value;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }
    }
} 
