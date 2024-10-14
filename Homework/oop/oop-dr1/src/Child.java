public class Child extends Par{
    private int sthElse;

    public Child(String name, String surname, int age, int sthElse) {
        
        super(name, surname, age);
        this.sthElse = sthElse;
    }

    public int getSthElse() {
        return sthElse;
    }

    @Override
    public void foo(){
        System.out.printf("Hi I'm child %s %s and i have %d other things", getName(), getSurName(), sthElse);
    }
}

