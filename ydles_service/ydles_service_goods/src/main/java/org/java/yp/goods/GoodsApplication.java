package org.java.yp.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 杨鹏
 * @version 1.0
 * Create by 2022/9/2 17:25
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "org.java.yp.goods.dao")
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
