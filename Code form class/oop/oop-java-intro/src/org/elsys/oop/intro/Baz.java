package org.elsys.oop.intro;

public class Baz extends Foo{
    //@Override will break if overriding method not present in parent
    //no access modifier -> scope is in the package
    //
    void func(){
        Foo f = new Foo();
     //   f.a;
    }

    @Override
    int pow2(){
        return (int) Math.pow(a, 2);
    }

}
