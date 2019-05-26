package hello;

public class HelloImpl implements HelloApi{
    private String word;
    public HelloImpl(){
        System.out.println("HelloImp class constructor0");
    }

    public HelloImpl(String word) {
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
