package cn.tjise.src.test.java.cn.tjise.src.test.java.cn.tjise.src.main.java.cn.tjise;

import java.lang.reflect.Modifier;

public class GetArrayList  {
    public static void main(String[] args) throws ClassNotFoundException {
       //1.获取类的类型
        Class<?> clas =  Class.forName("java.util.ArrayList");
        //2.获取类所在的包名
        Package pachage = clas.getPackage();
        String pkg = pachage.getName();
        System.out.println(pkg);

        //获取类的访问修饰符
        int mod = clas.getModifiers();
        String modifier =  Modifier.toString(mod);
        if (Modifier.isInterface(mod)){
            System.out.print(modifier); //输出public interface
        }else{
            System.out.print(modifier+"  class");
        }


        //获取类名
        String className = clas.getSimpleName();
        System.out.print(className);

        //获取类的父类
        Class<?> sup = clas.getSuperclass();
        if(sup!= null){
            //获取父类
            System.out.print(",extends"+sup.toGenericString());
        }
        //若父类是多个接口
        Class<?>[] ifs = clas.getInterfaces();
        if(ifs != null && ifs.length != 0){
            System.out.print(" implements ");
            for (Class<?> ifName : ifs)
                System.out.print(" " + ifName.toGenericString() + " ");
        }
        //获取类中的属性
//        Field[] fields =  clas.getDeclaredFields();
//        for (Field filed:fields){
//            //属性的访问修饰符
//            int f = filed.getModifiers();
//            String fier =  Modifier.toString(f);
//            System.out.println(fier);
//        }
        //获取方法
//        Methods[] methods = clas.getDeclaredMethods();//获取所有的方法（包括私有的）
//        for(Methods method:methods){
//            //method.g
//        }
    }

}
