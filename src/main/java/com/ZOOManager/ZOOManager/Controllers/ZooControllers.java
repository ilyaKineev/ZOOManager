package com.ZOOManager.ZOOManager.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooControllers {
    @GetMapping(value = "/zoo")
    public String zoo() {
        return "Zoo Info";
    }
}
