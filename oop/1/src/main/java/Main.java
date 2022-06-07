
import java.lang.annotation.Annotation;
import java.lang.reflect.*;


public class Main {
    public static void main(String[] args){
        Class reflected = SubClass.class;
        // Отримуємо ім'я класу
        System.out.println("Reflected class name: " + reflected.getName());
        // Отримуємо модифікатори класу
        int classModifiers = reflected.getModifiers();
        System.out.println(Modifier.isPublic(classModifiers));
        // Отримуємо відкриті методи класу, параметри, повертаємий тип
        Method [] methods = reflected.getMethods();
        System.out.println("\nSubClass methods:");
        for(Method method: methods){
            System.out.print("Method " + method.getName());
            System.out.print(" Return Type: " + method.getReturnType());
            Class[] parameterType = method.getParameterTypes();
            System.out.print(" Parameters: ");
            for(Class parameter : parameterType){
                System.out.print(parameter.getName()+ " ");
            }
            System.out.println();
        }
        // Отримуємо суперклас
        Class reflectedSuperclass = reflected.getSuperclass();
        System.out.println("\nSubclass superclass: " + reflectedSuperclass.getName());

        // Отримуємо інтерфейси
        Class [] interfaces = reflectedSuperclass.getInterfaces();
        System.out.println("\nBaseClass interfaces:");
        for(Class interface_: interfaces){
            System.out.println(interface_.getName());
        }

        // Отримуємо конструктори і їх параметри
        Constructor [] constructors = reflectedSuperclass.getConstructors();
        for(Constructor constructor: constructors){
            Class[] parameterType = constructor.getParameterTypes();
            System.out.println("BaseClass Constructors Parameters: ");
            for(Class parameter : parameterType){
                System.out.print(parameter.getName() + " ");
            }
        }
        System.out.println();

        // Ініціалізуємо і викликаємо конструктор
        Constructor baseConstructor = null;
        try {
            baseConstructor = reflectedSuperclass.getConstructor(int.class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        BaseClass baseClassObject = null;
        try {
            baseClassObject = (BaseClass) baseConstructor.newInstance(0, 0);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // Можна користуватися створеним об'єктом, так само, якщо б ми просто створили його за допомогою команди new
        baseClassObject.setI(1);
        baseClassObject.setJ(1);

        // Працюємо з приватними полями
        Field privateIntI = null;
        Field privateIntJ = null;

        try {
            privateIntI = BaseClass.class.getDeclaredField("i");
            privateIntI.setAccessible(true);
            privateIntJ = BaseClass.class.getDeclaredField("j");
            privateIntJ.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("\nPrivate i field : " + (int)privateIntI.get(baseClassObject) +
                    " Private j field : " + (int)privateIntJ.get(baseClassObject));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println();

        // Працюємо з приватним методом
        String privateMethodName = "somePrivateMethod";
        Method privateMethod = null;
        try {
            privateMethod = BaseClass.class.getDeclaredMethod(privateMethodName, null);
            privateMethod.setAccessible(true);
            privateMethod.invoke(baseClassObject, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // Працюємо з усіма методами і анотацією
        methods = reflectedSuperclass.getDeclaredMethods();
        for(Method method: methods){
            Annotation annotation = method.getAnnotation(AnnotationExample.class);
            if (annotation != null && annotation.annotationType() == AnnotationExample.class){
                Class<?>[] pType  = method.getParameterTypes();
                Object[] params = new Object[pType.length];
                for (int i = 0; i < pType.length; i++) {
                    if(pType[i].toString().equals("int")){
                        params[i] = 0;
                    }
                }
                try {
                    method.invoke(baseClassObject, params);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}