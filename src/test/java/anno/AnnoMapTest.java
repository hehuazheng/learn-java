package anno;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AnnoMapTest {
    @Test
    public void testMap() throws NoSuchFieldException, IllegalAccessException {
        AnnoMap annoMap = new AnnoMap();
        Map<String, Long> map = new HashMap<>();
        map.put("a", 1L);
        annoMap.setMap(map);

        Field f = AnnoMap.class.getDeclaredField("map");
        f.setAccessible(true);
        Map<String, ?> val = (Map) f.get(annoMap);
        for(Map.Entry<String, ?> entry : val.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            System.out.println(k + " " + v);
        }
    }
} 
