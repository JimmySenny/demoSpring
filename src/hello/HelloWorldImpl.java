package hello;

public class HelloWorldImpl implements HelloWorldApi {
    private String word;
    public HelloWorldImpl(){
        System.out.println("HelloImp class constructor0");
    }

    public HelloWorldImpl(String word) {
        System.out.println("HelloImp class constructor with arg");
        this.word = word;
    }

    public void setWord(String word) {
        System.out.println("this is arg word evaluation");
        this.word = word;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello "+this.word);
    }
}
