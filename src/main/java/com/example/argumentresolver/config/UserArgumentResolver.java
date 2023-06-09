package com.example.argumentresolver.config;

import com.example.argumentresolver.anotation.User;
import com.example.argumentresolver.dto.UserDTO;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserDTO.class) &&
                parameter.hasParameterAnnotation(User.class);
        // parameter 타입이 UserDTO 타입인 경우,
        // @User 어노테이션을 적용하면 resolveArgument 호출
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);

        return UserDTO.builder()
                .userId(httpServletRequest.getSession().getId())
                .userLocale(httpServletRequest.getLocale().toString())
                .ipAddress(httpServletRequest.getLocalAddr()).build();
    }
}
