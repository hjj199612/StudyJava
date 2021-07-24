package designpattern.annotaionProxy;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author huangjj24
 * @date 2021-5-19 16:44
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={METHOD,CONSTRUCTOR, TYPE})
//@Inherited
public @interface Transaction {

}
