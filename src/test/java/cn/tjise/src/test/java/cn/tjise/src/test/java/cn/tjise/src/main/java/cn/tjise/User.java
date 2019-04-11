package cn.tjise.src.test.java.cn.tjise.src.test.java.cn.tjise.src.main.java.cn.tjise;

public class User {
    private String name;

    public User() {
        System.out.println("无名氏.....");
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info(){
        System.out.println("I am"+name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
