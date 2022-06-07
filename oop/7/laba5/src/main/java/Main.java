import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        matrix.print();
        System.out.println();
        SLAE slae = new SLAE();
        slae.print();
        System.out.println();
        Class reflected = SLAE.class;
        System.out.println("\tName of extend class: " + reflected.getName());
        Class [] interfacess = reflected.getInterfaces();
        System.out.println("\tOutput names of interfaces of extend class:");
        for(Class interface_: interfacess){
            System.out.println(interface_.getName());
        }
        System.out.println("\tList of field of extend class: ");

        Field[] fs = reflected.getDeclaredFields();
        for(int i = 0; i < fs.length; i++){
            System.out.println(fs[i].getName());
            Annotation annotation = fs[i].getAnnotation(Annotation.class);
        }
        System.out.println("\tCall annotation methods of extend class:");
        Method [] methods;
        methods = reflected.getDeclaredMethods();
        for(Method method: methods){
            Annotation annotatio = method.getAnnotation(Annotation.class);
            if (annotatio != null && annotatio.annotationType() == Annotation.class){
                Class<?>[] pType  = method.getParameterTypes();
                Object[] params = new Object[pType.length];
                try {
                    method.invoke(slae, params);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
        Class reflectedSuperclass = reflected.getSuperclass();
        System.out.println("\tName of base class: " + reflectedSuperclass.getName());
        Class [] interfaces = reflectedSuperclass.getInterfaces();
        System.out.println("\tName of interfaces of base class:");
        for(Class interface_: interfaces){
            System.out.println(interface_.getName());
        }
        System.out.println("\tList of fields of base class:");
        Field[] fss = reflectedSuperclass.getDeclaredFields();
        for(int i = 0; i < fss.length; i++) {
            System.out.println(fss[i].getName());
            Annotation annotation = fss[i].getAnnotation(Annotation.class);
        }

        System.out.println("\tCall annotation methods of base class:");
        methods = reflectedSuperclass.getDeclaredMethods();
        for(Method method: methods){
            Annotation annotatio = method.getAnnotation(Annotation.class);
            if (annotatio != null && annotatio.annotationType() == Annotation.class){
                Class<?>[] pType  = method.getParameterTypes();
                Object[] params = new Object[pType.length];
                try {
                    method.invoke(matrix, params);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
