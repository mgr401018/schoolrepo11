import org.elsys.oop.intro.Foo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main { //psvm
//    public static void main(String[] args) {
////        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
////        // to see how IntelliJ IDEA suggests fixing it.
////        System.out.printf("Hello and welcome!");
////
////        for (int i = 1; i <= 5; i++) {
////            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
////            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
////            System.out.println("i = " + i);
////        }
//    }

    public static void main(String[] args) {
        System.out.println("Hello World"); //sout
        //args.length
        Foo b = new Baz();
        System.out.println( b.toString() );
    }
}

/*
    c/c++ ->
        source: .c/pp/
        compile: .o
        linked: .out/exe
    java ->
        source: .java
        compile: .class
        linked: .jar -> (using JVM run) ``java -jar <f_name>.jar``

 */