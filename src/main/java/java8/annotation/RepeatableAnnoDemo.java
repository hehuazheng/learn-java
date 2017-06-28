package java8.annotation;

import java.lang.annotation.*;

/**
 * Created by hejf on 2017/6/28.
 */
public class RepeatableAnnoDemo {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    }

    @Filter("f1")
    @Filter("f2")
    interface Fitlerable {
    }

    public static void main(String[] args) {
        Filter[] filters = Fitlerable.class.getAnnotationsByType(Filter.class);
        for (Filter f : filters) {
            System.out.println(f.value());
        }
    }
}
