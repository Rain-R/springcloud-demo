package com.imooc.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wz
 * @version v1.0
 * @description
 * @datetime 2019/9/3 14:20
 * @since JDK 1.8
 */
@FeignClient("product")
public interface ProductClient {

    @GetMapping("/msg")
    String getProductMsg();
}
