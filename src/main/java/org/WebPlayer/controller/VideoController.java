package org.WebPlayer.controller;
import org.WebPlayer.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class VideoController {
    // 路径参数

    // 1. @RequestMapping("/video/{bv}")
    // 2. @PathVariable String bv, @PathVariable 表示该方法参数要从路径中获取

    @RequestMapping("/video/{bv}") // 1, 2, 3...
    @ResponseBody
    public org.WebPlayer.dto.Video t(@PathVariable String bv) {
        return VideoService.find(bv);
    }

    @Autowired
    private VideoService videoService;
}
