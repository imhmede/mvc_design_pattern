class Tester {
    // Main driver method
    public static void main(String args[])
    {
        // Instantiating Singleton class with variable x
        Singleton SingletonInstance1 = Singleton.getInstance();
 
        // Instantiating Singleton class with variable y
        Singleton SingletonInstance2 = Singleton.getInstance();
 
        // Instantiating Singleton class with variable z
        Singleton SingletonInstance3 = Singleton.getInstance();
 
        // Printing the hash code for above variable as
        // declared
        System.out.println("Hashcode of SingletonInstance1 is "
                           + SingletonInstance1.hashCode());
        System.out.println("Hashcode of SingletonInstance2 is "
                           + SingletonInstance1.hashCode());
        System.out.println("Hashcode of SingletonInstance3 is "
                           + SingletonInstance1.hashCode());
 
        // Condition check
        if (SingletonInstance1 == SingletonInstance2 && SingletonInstance2 == SingletonInstance3) {
 
            // Print statement
            System.out.println(
                "Three objects point to the same memory location on the heap i.e, to the same object");
        }
 
        else {
            // Print statement
            System.out.println(
                "Three objects DO NOT point to the same memory location on the heap");
        }
    }
}