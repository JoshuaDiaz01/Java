// // class has to be the same name as file
// public class Test{
//     public static void main(String[] args){ //do the same as function keyword in js
//         System.out.println("My name is Coding Dojo");
//         System.out.println("I am 100 Years Old");
//         System.out.println("My hometown is Burbank CA");
//     }
// }

// declaring a variable in java

public class Variables {
    public static void main(String[] args){
        int ourInt; // we can declare a variable without setting its value
        ourInt = 400; // we can assign a value to the variable later in our code
        double pi = 3.14159265; // we can also declare and assign on the same line
        boolean bool = true;
        char singleCharacter = 'A';
        
        String multipleCharacters = "ABC";
    }
}

boolean isRaining = true;
    
if(isRaining) {
    System.out.println("Bring an umbrella.");
}

boolean isRaining = true;
    
if(isRaining) {
    System.out.println("Bring an umbrella.");
}
else {
    System.out.println("Have fun!");
}

//ternary operators have the condition, if true, then if false
System.out.println(isRaining ? "Bring an umbrealla" : "Have fun!");

//concatinating
// String string1 = "My name is ";
// String string2 = "Michael";
// String string3 = string1.concat(string2);
// System.out.println(string3);
// // will output My name is Michael


//length
// public class StringDemo {
//      public static void main(String[] args) {
//         String ninja = "Coding Dojo is Awesome!";
//         int length = ninja.length();
//         System.out.println( "String Length is : " + length );
//      }
// }

// String ninja = "Welcome to Coding Dojo!";
// int a = ninja.indexOf("Coding"); // a is 11
// int b = ninja.indexOf("co"); // b is 3
// int c = ninja.indexOf("pizza"); // c is -1, "pizza" is not found

// String a = "HELLO";
// String b = "world";
// System.out.println(a.toLowerCase()); // hello
// System.out.println(b.toUpperCase()); // WORLD


// equality
// // Normal string assignment
// String a = "same string";
// String b = "same string";
// System.out.println(a == b); // true
// // Creating new strings as separate objects (another way to create a String)
// a = new String("same letters");
// b = new String("same letters");
// System.out.println(a == b); // false. Not the same object in memory.
// System.out.println(a.equals(b)); // true. same exact characters.

// String a = new String( "Dojo" );
// System.out.println( a.equals("Dojo") );
// // this actually will print out `true`
// String a = new String( "Dojo" );
// System.out.println( a == "Dojo" );
// // surprisingly this will print out `false`