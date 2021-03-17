package com.toy.yaho;

import com.toy.yaho.yaho2.Yaho2Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    private final Yaho2Client yaho2Client;
    private final YahoService yahoService;

    public ConfigController(Yaho2Client yaho2Client, YahoService yahoService) {
        this.yaho2Client = yaho2Client;
        this.yahoService = yahoService;
    }

    @GetMapping("/test")
    public String test() {
        return yahoService.getWho();
    }

    @GetMapping("/test2/{name}")
    public String test2(@PathVariable String name) {
        return yaho2Client.getYaho2(name);
    }

    @PostMapping("/save/{name}")
    public String test22(@PathVariable String name) {
        return yaho2Client.saveYaho2(name);
    }

}
