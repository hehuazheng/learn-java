package anno;

import org.junit.Test;

import java.lang.reflect.Field;

/** 
* AnnoEntity Tester. 
* 
* @author <Authors name> 
*/ 
public class AnnoEntityTest {
    @Test
    public void testClassAnno() {
        ClassLevelAnno anno = AnnoEntity.class.getAnnotation(ClassLevelAnno.class);
        System.out.println(anno.name());
    }

    @Test
    public void testFieldAnno() {
        Field[] fields = AnnoEntity.class.getDeclaredFields();
        for(Field f : fields) {
            FieldLevelAnno anno = f.getAnnotation(FieldLevelAnno.class);
            System.out.println(anno.name());
        }
    }
} 
