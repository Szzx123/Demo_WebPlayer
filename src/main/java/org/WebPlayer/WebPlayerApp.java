package org.WebPlayer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebPlayerApp implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(WebPlayerApp.class, args);
    }

    // 作用：把 url 路径和 磁盘路径做一个映射
    // http://localhost:8080/play/xxx => static/play
    // http://localhost:8080/play/xxx => d:/aaa
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //       url 路径                                    磁盘路径
        registry.addResourceHandler("/play/**").addResourceLocations("file:" + videoPath);
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + imgPath);
    }
    @Value("${video-path}")
    private String videoPath;

    @Value("${img-path}")
    private String imgPath;
}