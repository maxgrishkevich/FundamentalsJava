

import com.sun.source.tree.ParenthesizedTree;

import java.lang.annotation.Annotation;
import java.lang.constant.Constable;
import java.lang.reflect.*;

public class ClassInfo {

    public static void printInterfaces(Class cls) {
        Class[] interfaces = cls.getInterfaces();
        System.out.println("\nInterfaces of class: " + cls.getName());
        int counter = 1;
        for (Class interface_ : interfaces) {
            System.out.println(counter + ". " + interface_.getName());
            counter++;
        }
    }

    public static void printFields(Class cls) {
        System.out.println("\nFields of: " + cls.getName());
        Field[] fields = cls.getDeclaredFields();
        int counter = 1;
        for (Field field : fields) {
            System.out.println(counter + ". " + field.getName());
            System.out.println("type: " + field.getType().getName());
            System.out.println("annotation: " + field.getAnnotation(MyAnnotation.class));
            counter++;
        }
    }

    public static void InvokeMethodsWithAnnotation(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(MyAnnotation.class);
            if (annotation != null && annotation.annotationType().equals(MyAnnotation.class)) {
                System.out.print("Method called: " + method.getName() + " with params: ");
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.print(parameter.getType() + " " + parameter.getName() + " ");
                }
                System.out.println();
                Class<?>[] paramsType = method.getParameterTypes();
                Object[] params = new Object[paramsType.length];
                for (int i = 0; i < paramsType.length; i++) {
                    if(paramsType[i].toString().equals("[D")){
                        double[][] arr = {{3, 2, 1, 3}, {1, 2, 2, 2}, {2, 3, 4, 4}, {3, 4, 5, 5}};
                        double[] members = {4, 3, 5, 1};
                        params[i] = new EquationsSystem(arr, members);
                    }
                }
                try {
                    method.invoke(cls, params);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
