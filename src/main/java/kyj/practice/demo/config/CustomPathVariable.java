package kyj.practice.demo.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 이 어노테이션은 파라미터에 붙인다
@Retention(RetentionPolicy.RUNTIME) // 이 어노테이션은 런타임시 까지만 유지한다
public @interface CustomPathVariable {

    String value() default "";

    boolean required() default true;
}
