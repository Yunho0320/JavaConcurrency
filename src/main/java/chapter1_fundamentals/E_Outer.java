package chapter1_fundamentals;

/*
This is to show how inner class can access private fields and methods of outer class
 */
public class E_Outer {
    private String outerName;

    public E_Outer(String name) {
        this.outerName = name;
    }

    public void sayHello() {
        System.out.println("Hello from Outer: " + outerName);
    }

    // Non-static inner class
    public class Inner {
        private String innerName;

        public Inner(String name) {
            this.innerName = name;
        }

        public void print() {
            System.out.println("Inner name: " + innerName);
            System.out.println("Accessing outerName from Inner: " + outerName);
            E_Outer.this.sayHello();  // Implicit reference to outer object!
        }
    }

    public Inner createInner(String innerName) {
        return new Inner(innerName);
    }

    public static void main(String[] args) {
        E_Outer outer = new E_Outer("OuterOne");
        E_Outer.Inner inner = outer.createInner("InnerOne");
        inner.print();
    }
}

/*
Output:
Inner name: InnerOne
Accessing outerName from Inner: OuterOne
Hello from Outer: OuterOne
 */