package cn.tjise;

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

    //输出姓名
    public void info(){
        System.out.println("I am"+name);
    }

    //姓名长度
    private int getNameLength(){
        return name.length();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
