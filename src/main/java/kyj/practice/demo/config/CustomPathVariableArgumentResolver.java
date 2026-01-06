package kyj.practice.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

public class CustomPathVariableArgumentResolver implements HandlerMethodArgumentResolver {

    // supportsParameter -> 이 Resolver를 언제 사용할 지 판단
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CustomPathVariable.class); // 파라미터에 CustomPathVariable 이 있는지 확인
    }

    // 실제로 파라미터에 전달할 값 생성
    @Override @SuppressWarnings("all")
    public Object resolveArgument(
            @NonNull MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            @NonNull NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) {


        CustomPathVariable annotation = parameter.getParameterAnnotation(CustomPathVariable.class); // 파라미터를 가져옴
        String variableName = annotation.value().isEmpty() ? parameter.getParameterName() : annotation.value(); // 빈 값이 아니면 이름과 값으로

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class); // 요청 서블릿을 가져옴
        Map<String, String> uriTemplateVars =
                (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE); // 요청 서블릿 안의 값 필드를 key:value 구조로 가져옴

        String value = uriTemplateVars.get(variableName);
        return value == null ? null : new SimpleTypeConverter().convertIfNecessary(value, parameter.getParameterType()); // 값 컨버팅
    }
}
