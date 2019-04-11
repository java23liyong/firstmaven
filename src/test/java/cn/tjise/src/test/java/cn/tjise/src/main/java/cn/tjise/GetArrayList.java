package cn.tjise.src.test.java.cn.tjise.src.main.java.cn.tjise;



import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetArrayList  {
    public static void main(String[] args) throws ClassNotFoundException {
        // 0. 获取 类 类型  ===  获取一个具体的类《LinkedList》
        // Class<LinkedList> x = LinkedList.class;
        // LinkedList list = null;
        //Class<? extends LinkedList> x = list.getClass();
        //1.获取类的类型
        Class<?> clas =  Class.forName("java.util.ArrayList");
        //2.获取类所在的包名
        Package pachage = clas.getPackage();
        String pkg = pachage.getName();
        System.out.println("类包："+pkg);

        //获取类的访问修饰符
        int mod = clas.getModifiers();
        String modifier =  Modifier.toString(mod);
        if (Modifier.isInterface(mod)){
            System.out.println(modifier); //输出public interface
        }else{
            System.out.println("类的修饰符："+modifier);
        }


        //获取类名
        String className = clas.getSimpleName();
        System.out.println("类名称："+className);

        //获取类的父类
        Class<?> sup = clas.getSuperclass();
        if(sup!= null){
            //获取父类
            System.out.println("类的父类为："+sup.toGenericString());
        }
        //若父类是多个接口
        Class<?>[] ifs = clas.getInterfaces();
        if(ifs != null && ifs.length != 0){
            System.out.print("类的接口：");
            for (Class<?> ifName : ifs)
                System.out.print(" " + ifName.toGenericString() + " ");
        }

        System.out.println();

        //获取类的属性
        Field[] fields = clas.getDeclaredFields();
        System.out.println("属性的访问修饰符：");
        for (Field field : fields){
            //属性的访问修饰符
            int f = field.getModifiers();
            String fie =  Modifier.toString(f);
            System.out.println("\t"+fie);
        }
        System.out.println("属性的数据类型：");
        for (Field field : fields){
            //属性的数据类型：
            Class<?> fieldType = field.getType();
            System.out.println("\t"+fieldType);
        }
        System.out.println("属性名称：");
        for (Field field : fields){
            //属性名称：
            String fieldName = field.getName();
            System.out.println("\t"+fieldName);
        }


        //获取方法
        Method[] methods = clas.getDeclaredMethods();
        System.out.println("方法的访问修饰符：");
        for (Method method : methods){
            //方法的访问修饰符
            int fmethod = method.getModifiers();
            String fie =  Modifier.toString(fmethod);
            System.out.println("\t"+fie);
        }
        System.out.println("方法的返回值类型：");
        for (Method method : methods){
            //方法的返回值类型：
            Class<?> methodType = method.getReturnType();
            System.out.println("\t"+methodType);
        }
        System.out.println("方法名称：");
        for (Method method : methods){
            //方法名称：
            String methodName = method.getName();
            System.out.println("\t"+methodName);
        }

        System.out.println("方法参数类型：");
        for (Method method : methods){
            Class<?>[] pts = method.getParameterTypes();
            for (Class<?> p : pts) {
                System.out.println("\t" + p);
            }
        }

        System.out.println("方法抛出的异常：");
        for (Method method : methods){
            Class<?>[] ets = method.getExceptionTypes();
            for (Class<?> e : ets) {
                System.out.println("\t" +e);
            }
        }

        // 获取构造方法
        Constructor<?>[] constructors = clas.getDeclaredConstructors();
        System.out.println("构造方法的访问修饰符：");
        for (Constructor constructor : constructors){
            //构造方法的访问修饰符
            int fconstructor = constructor.getModifiers();
            String fie =  Modifier.toString(fconstructor);
            System.out.println("\t"+fie);
        }

        System.out.println("构造方法的名称：");
        for (Constructor constructor : constructors){
            //构造方法的名称：
            String constructorName = constructor.getName();
            System.out.println("\t"+constructorName);
        }


        System.out.println("构造方法的参数类型：");
        for (Constructor constructor : constructors){
            //构造方法的参数类型：
            Class<?>[] pts = constructor.getParameterTypes();
            for (Class<?> p : pts) {
                System.out.println("\t" + p);
            }
        }
        //外部类
        System.out.println("外部类:");
        Class<?> outClz = clas.getDeclaringClass();
        System.out.println("\t"+outClz);

        //内部类
        System.out.println("内部类:");
        Class<?>[] innerClz = clas.getDeclaredClasses();
        for (Class<?> c:innerClz){
            System.out.println("\t"+c);
        }
    }

}
