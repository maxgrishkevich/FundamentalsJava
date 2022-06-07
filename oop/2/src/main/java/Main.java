

public class Main {
    public static void main(String[] args) {
        double[][] arr = { {3,2,1,3}, {1,2,2,2}, {2,3,4,4}, {3,4,5,5} };
        double[] members = {4,3,5,1};

        EquationsSystem system = new EquationsSystem(arr, members);
        system.setMatrix(arr);
        system.setDeterminant();
        System.out.println("Визначник матриці: " + system.getDeterminant());

        system.setFreeMembers(members);
        system.kramerMethod();
        System.out.println("Розв'зок за методом Крамера: ");
        system.showResults();
        system.gaussMethod();
        System.out.println("Розв'зок за методом Гауса: ");
        system.showResults();

        System.out.println("\nInfo:\n");

        Class reflected = EquationsSystem.class;

        ClassInfo.printFields(reflected);
        ClassInfo.printInterfaces(reflected);
        ClassInfo.InvokeMethodsWithAnnotation(reflected);
    }
}
