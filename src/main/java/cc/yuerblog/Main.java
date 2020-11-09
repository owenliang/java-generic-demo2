package cc.yuerblog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static <T> void func1(T val) {
        // 错误：java泛型和c++很不一样，运行时java完全不知道T是啥，所以这个代码根本不让编译
        // T copy = new T();
    }

    private static <T> List<T> func2(T ...vals) {
        List<T> ret = new ArrayList<T>();
        // 正确：只是把T类型的对象挪来挪去，毫无问题
        for (T v : vals) {
            ret.add(v);
        }
        return ret;
    }

    private static <T extends List<? extends Number>> void func3(T l) {
        // 正确：T是List<? extends Number>的子类，所以一定有List的方法
        System.out.println("长度=" + l.size());

        // 正确：列表元素一定是Number的子类，所以一定有Number的方法
        Number elem1 = l.get(0);
        System.out.println("第一个元素=" + elem1.doubleValue());
    }

    public static void main(String[] args) {
        Main.func1(1);
        List<Integer> l = Main.func2(7,8,9);
        Main.func3(l);
    }
}
