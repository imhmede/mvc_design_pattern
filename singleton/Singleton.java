class Singleton {
    // Static variable reference of type Singleton
    private static Singleton singleInstance = null;
 
    // Declaring a variable of type String
    public String text;
 
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private Singleton()
    {
        text = "Hello I am a string part of Singleton class";
    }

    // Static method to create instance of Singleton class
    public static synchronized Singleton getInstance()
    {
        if (singleInstance == null)
        singleInstance = new Singleton();
 
        return singleInstance;
    }
}