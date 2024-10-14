public class Par {
    private String name;
    private String surname;
    private int age;

    public Par(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void foo() {
        System.out.printf("Hi I'm par %s %s", name, surname);
    }
}