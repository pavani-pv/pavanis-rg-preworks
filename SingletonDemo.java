class Singleton {
    // create the instance
    private static Singleton instance = new Singleton();

    // Private constructor to prevent instantiation
    private Singleton() { }

    // Method to provide access to the single instance
    public static Singleton getInstance() {
        return instance;
    }
    
    void printMessage(){
        System.out.println("in singleton class");
    }
}

public class SingletonDemo{
    public static void main (String args[]){
        Singleton obj = Singleton.getInstance();
        obj.printMessage();
    }
}
