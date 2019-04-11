package cn.tjise;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import cn.tjise.User;
import java.lang.reflect.Method;
/*
通过反射操作类
 */
public class UserTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //之前是通过new创建对象
//        User user = new User();


        //1.获取类的类型
        Class<?> clas =  Class.forName("cn.tjise.User");
        //2.操作类(实例化：构造方法；属性的读写，方法调用)
            //2.1调用缺省构造方法
             Object user = clas.newInstance();
             System.out.println(user);

            //2.2调用带参构造方法(1.找到  2.调用)
            Constructor<?> constructor = clas.getDeclaredConstructor(String.class);
            Object user2 = constructor.newInstance("李勇");
            System.out.println(user2);

        // 属性的读写  user.name = "李勇"   username = user.name;
        // 获取指定的属性
        Field nameField = clas.getDeclaredField("name");
        nameField.setAccessible(true);  // 私有属性可以读写
        // 写属性
        nameField.set(user, "李飞");
        // 读属性
        Object username = nameField.get(user);
        System.out.println(username);

        // 方法的调用
        // 获取指定的方法

        // 获取 setName ： 方法名字、方法的参数类型
        Method setNameMethod = clas.getMethod("setName", String.class);


        // 获取私有方法getNameLength ： 方法名字，无参数
        Method getNameLengthMethod = clas.getDeclaredMethod("getNameLength");  // 私有方法

        // 调用指定的方法
        // 调用 setName 方法：方法、那个对象调用该方法、该方法所接受的参数值
        setNameMethod.invoke(user, "古力娜扎");
        System.out.println(user);


        // getNameLength 方法，私有，必须设置可访问行
        getNameLengthMethod.setAccessible(true);


        // 调用 getNameLength 方法：方法、那个对象调用该方法
        Object namelength = getNameLengthMethod.invoke(user);
        System.out.println(namelength);

    }
}
