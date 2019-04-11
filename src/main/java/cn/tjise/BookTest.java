package cn.tjise;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BookTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1.获取类的类型
        Class<?> clas = Class.forName("cn.tjise.Book");
        //2.操作类(实例化：构造方法；属性的读写，方法调用)
        //2.1调用缺省构造方法
        Object book = clas.newInstance();
        System.out.println(book);

        //2.2调用带参构造方法(1.找到  2.调用)
        Constructor<?> constructor = clas.getDeclaredConstructor(int.class,String.class,double.class,String.class);
        Object book1 = constructor.newInstance(1000,"《spring boot开发》",30.5,"大神");
        System.out.println(book1);

        // 属性的读写
        // 获取指定的属性
        Field nameField = clas.getDeclaredField("name");
        nameField.setAccessible(true);  // 私有属性可以读写
        // 写属性
        nameField.set(book, "《java高级开发》");
        // 读属性
        Object bookname = nameField.get(book);
        System.out.println("设置书名为："+bookname);

        // 方法的调用
        // 获取指定的方法

        // 获取 setName ： 方法名字、方法的参数类型
        Method setNameMethod = clas.getMethod("setName", String.class);
        //获取 info方法
        Method infoMethod = clas.getMethod("info", String.class);

        // 调用指定的方法
        // 调用 setName 方法：方法、那个对象调用该方法、该方法所接受的参数值
        setNameMethod.invoke(book, "《spring》");
        System.out.println(book);

        //调用info方法
        infoMethod.invoke(book,"《坏蛋是怎样炼成的》");
        System.out.println(book);


        // 获取私有方法getBookNameLength： 方法名字，无参数
        Method getNameLengthMethod = clas.getDeclaredMethod("getBookNameLength");  // 私有方法
        // getBookNameLength 方法，私有，必须设置可访问行
        getNameLengthMethod.setAccessible(true);

        // 调用 getBookNameLength 方法：方法、那个对象调用该方法
        Object namelength = getNameLengthMethod.invoke(book);
        System.out.println("书名长度为："+namelength);



    }
}
