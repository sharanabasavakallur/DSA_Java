🔹 Q5. What is the difference between == and .equals()?
```
Operator	Used For	                            Comparison Type
==	        Primitive types & object references	    Compares memory addresses (reference comparison)
.equals()	Objects (like Strings)	                Compares actual values
```
String s1 = new String("Hello");
String s2 = new String("Hello");
System.out.println(s1 == s2);       // false (Different objects in memory)
System.out.println(s1.equals(s2));  // true  (Same content)

🔹 Q6. Can we overload the main method?
✅ Yes, Java allows multiple main methods with different parameters, but only the standard main(String[] args) method is called by JVM.

✅ Example
```
public class Test {
public static void main(String[] args) {
System.out.println("Main method with String[] args");
}

    public static void main(int a) {
        System.out.println("Overloaded main with int: " + a);
    }
}
```
o/p:Main method with String[] args
The main(int a) method won’t be called unless manually invoked.

Q7. Can a constructor be final, static, or abstract?
❌ No, a constructor cannot be final, static, or abstract.
```
Modifier	Allowed?	Reason
final	    ❌ No	    Constructors cannot be inherited/overridden
static	    ❌ No	    Constructors belong to objects, not class itself
abstract	❌ No	    Constructors must be defined, but abstract means incomplete
```

🔹 Q8. Can an interface have a constructor?
❌ No, interfaces cannot have constructors because they cannot be instantiated.
```
interface MyInterface {
MyInterface() { }  // ❌ Error! Interfaces cannot have constructors.
}
```

🔹 Q10. What is the difference between final, finally, and finalize?
Keyword	Usage	Purpose
final	Variable, Method, Class	Prevents modification (constant, no override, no inheritance)
finally	Try-Catch Block	Runs always, even if exception occurs
finalize	Method	Called by garbage collector before deleting an object
```
class Test {
    final int x = 10;  // Constant
    final void show() { System.out.println("Can't override me!"); }

    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
        } finally {
            System.out.println("Finally block always runs!");
        }
    }

    protected void finalize() { System.out.println("Object is garbage collected"); }
}
```


