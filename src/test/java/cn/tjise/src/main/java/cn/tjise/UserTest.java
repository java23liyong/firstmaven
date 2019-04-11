package cn.tjise.src.main.java.cn.tjise;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
通过反射操作类
 */
public class UserTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //之前是通过new创建对象
//        User user = new User();


        //1.获取类的类型
        Class<?> clas =  Class.forName("cn.tjise.src.main.java.cn.tjise.User");
        //2.操作类(实例化：构造方法；属性的读写，方法调用)
            //2.1调用缺省构造方法
             Object user1 = clas.newInstance();
             System.out.println(user1);

            //2.2调用带参构造方法(1.找到  2.调用)
            Constructor<?> constructor = clas.getDeclaredConstructor(String.class);
            Object user2 = constructor.newInstance("李勇");
            System.out.println(user2);

            //属性的读写



    }
}
