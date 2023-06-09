package com.example.argumentresolver.config;

import com.example.argumentresolver.param.ResultParams;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;

@Component
public class ResultReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return ResultParams.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public void handleReturnValue(Object returnValue,
                                  MethodParameter returnType,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        ResultParams params = (ResultParams) returnValue;
        mavContainer.setRequestHandled(true);

        if (params.getMessage().equals("test")) {
            params.setStatusCode("code");
            params.setMessage("message");
            String str = "code: " + params.getStatusCode() + ", message: " + params.getMessage();
            HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
            response.getOutputStream().write(str.getBytes());
        }
    }
}
