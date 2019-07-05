package json;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test2() throws IOException {
        String json = FileUtils.readFileToString(new File("e:/json.txt"));
        LoggerBody map = JsonUtils.parseObject(json, LoggerBody.class);
        System.out.println(JsonUtils.toJsonString(map));
    }

    public class QueryItem<T> {
        private Float score;
        private T doc;
        private Map<String, List<String>> highLights;

        public Float getScore() {
            return score;
        }

        public void setScore(Float score) {
            this.score = score;
        }

        public T getDoc() {
            return doc;
        }

        public void setDoc(T doc) {
            this.doc = doc;
        }

        public Map<String, List<String>> getHighLights() {
            return highLights;
        }

        public void setHighLights(Map<String, List<String>> highLights) {
            this.highLights = highLights;
        }

    }

    public interface QueryItemList<T> extends Iterable<QueryItem<T>> {
        String requestId();

        long count();

        int cost();

        long queryTime();

        List<QueryItem<T>> items();

        List<String> facetNames();

        Map<String, List<FacetItem>> facets();

        //更新requestId, 返回原有requestId
        String renew(String requestId);
    }

    public static class FacetItem {
        private String name;
        private long count;

        public FacetItem() {
        }

        public FacetItem(String name, long count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }
    }


    public static class LoggerBody<T> {
        private Long logTime;
        private String requestId;
        private int start;
        private int rows;
        private String collection;
        private String keywords;
        private QueryItemList<T> resultList;

        public LoggerBody() {
        }

        public LoggerBody(String collection, String requestId, String keywords, QueryItemList<T> itemList, int start, int rows) {
            this.collection = collection;
            this.requestId = requestId;
            this.keywords = keywords;
            this.resultList = itemList;
            this.start = start;
            this.rows = rows;
        }

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public QueryItemList<T> getResultList() {
            return resultList;
        }

        public void setResultList(QueryItemList<T> resultList) {
            this.resultList = resultList;
        }

        public Long getLogTime() {
            return logTime;
        }

        public void setLogTime(Long logTime) {
            this.logTime = logTime;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }
    }
} 
