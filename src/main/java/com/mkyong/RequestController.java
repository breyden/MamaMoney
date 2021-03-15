package com.mkyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

@RestController
public class RequestController {

Menu menu = new Menu();

@RequestMapping(value = "/ussd", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
@ResponseBody
public String getMenu(@RequestBody Request req) {
    return menu.processRequest(req).toString();
}
}
