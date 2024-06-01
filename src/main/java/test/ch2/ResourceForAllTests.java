package test.ch2;

public class ResourceForAllTests {

    private String resourceName;

    public ResourceForAllTests(String resourceName) {
        this.resourceName = resourceName;
        System.out.println(resourceName + " из класса " + getClass().getSimpleName() + " инициализируется.");
    }

    public void close() {
        System.out.println(resourceName + " из класса " + getClass().getSimpleName() + " закрывается.");
    }

}
