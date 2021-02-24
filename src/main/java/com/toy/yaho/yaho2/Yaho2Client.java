package com.toy.yaho.yaho2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("yaho2")
public interface Yaho2Client {

    @GetMapping(value = "/api/v1/hello/{name}")
    String getYaho2(@PathVariable String name);

    @PatchMapping(value = "/api/v1/hello/{name}")
    String saveYaho2(@PathVariable String name);
}
