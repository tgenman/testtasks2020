package com.example.incrementator.controller;

import com.example.incrementator.service.IIncrementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private IIncrementService incrementService;

    @PostMapping("/increment")
    @ResponseBody
    public Map<String, String> increment(@RequestBody Map<String, String> param) {
        final Map<String, String> resp = new HashMap<>();

        String value = incrementService.incrementValue(param.get("request"));

        resp.put("response", value);
        return resp;
    }


}
