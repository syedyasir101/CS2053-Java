public class WrapperAutoboxingExample {
    public static void main(String[] args) {
        
        
        int primitiveInt = 10;
        Integer wrappedInt = primitiveInt; 
        System.out.println("Autoboxed Integer: " + wrappedInt); 

        Integer anotherWrappedInt = 20; 
        int anotherPrimitiveInt = anotherWrappedInt;  
        System.out.println("Auto-unboxed int: " + anotherPrimitiveInt); 
        
        Integer someInteger = 100;
        System.out.println("Integer as string: " + someInteger.toString()); 

        
        java.util.List<Integer> list = new java.util.ArrayList<>();
        list.add(50); 
        list.add(100);
        
        
        System.out.println("List of Integer: " + list); 
        
        
        int firstElement = list.get(0);  
        System.out.println("First element (auto-unboxed): " + firstElement); 
    }
}
