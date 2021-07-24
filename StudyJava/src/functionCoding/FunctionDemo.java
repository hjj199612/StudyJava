package functionCoding;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-14 16:19
 **/
public class FunctionDemo {
    public static void main(String[] args) {
        int x=(int)(1+Math.random()*100);
        int y=(int)(1+Math.random()*100);
        System.out.println(x+" "+y);
        System.out.println(operation(x,y,(a,b)->a+b));
        System.out.println(operation(x,y,(a,b)->a-b));
        System.out.println(operation(x,y,(a,b)->a*b));
        System.out.println(operation(x,y,(a,b)->a/b));

        Function<Integer,Integer> function = p->p*100;
        System.out.println(function.apply(x));

        BiFunction<Integer,Double,String> biFunction = (a,b)->a.toString()+b.toString();
        System.out.println(biFunction.apply(x,(double)y));

        String log = getLog("--------------",()->"发送错误"+getBoolean("发送错误",p->"发送错误".equals(p)));
        printLog(log,msg->{
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("["+now.format(dateFormat)+"] "+msg);
        });

        //forEach

        List<String> list = Arrays.asList("huangjj","121");
        
    }
    public static Integer operation(Integer x,Integer y,BiOperation<Integer> operation){
        return operation.operation(x,y);
    }

    public static void printLog(String message, Consumer<String> consumer){
        consumer.accept(message);
    }

    public static String getLog(String msg, Supplier<String> supplier){
        return msg+supplier.get();
    }
    public static boolean getBoolean(String msg, Predicate<String> predicate){
        return predicate.test(msg);
    }
}
