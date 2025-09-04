package Exe_04;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CreateAnnotation_04 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class<MyAnnotationExample> clazz = MyAnnotationExample.class;

        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();

        Subject annotation = clazz.getAnnotation(Subject.class);

        String[] categories = annotation.categories();
        //
        MyAnnotationExample myAnnotationExample=new MyAnnotationExample();

        Field field = clazz.getDeclaredField("dbEndPoint");
        field.setAccessible(true);
        FieldType fieldAnnotation = field.getAnnotation(FieldType.class);

        field.set(myAnnotationExample,fieldAnnotation.value());

        System.out.println();


    }
}
