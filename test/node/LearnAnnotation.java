package node;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/***
 * 学习注解java.lang.annotation包
 * */
public class LearnAnnotation {
    public static void main(String[] args) {
        HowReadInfo info = Test.class.getAnnotation(HowReadInfo.class);
        System.out.println(info.value()); // print "test"

        info = LearnAnnotation.class.getAnnotation(HowReadInfo.class);
        System.out.println(info.value()); // null

        // 不知道怎么测试新增的ElementType.TYPE_USE ElementType.TYPE_PARAMETER
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface HowReadInfo {
    String value() default "def";
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
@interface ToTypeUse {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER})
@interface ToTypeParameter {
}

@HowReadInfo("test")
class Test {

    public void typeUse(){
        @ToTypeUse  int  param = 0;
        List<@ToTypeUse Integer> list = new ArrayList<>();
    }

    public static <@ToTypeParameter() T> void  typeParam(T param){
    }
}
