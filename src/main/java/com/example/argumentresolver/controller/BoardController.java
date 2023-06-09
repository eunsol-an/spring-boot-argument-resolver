package com.example.argumentresolver.controller;

import com.example.argumentresolver.param.ResultParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class BoardController {

    @RequestMapping(value = "/search")
    public ResultParams getBoardList(ResultParams params) {
        params.setMessage("test");
        return params;
    }
}
