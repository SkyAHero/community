package com.study.community.controller;

import com.study.community.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/data")
    public String getDataPage(){
        return "/site/admin/data";
    }

    @PostMapping("/data/uv")
    public String getUV(@DateTimeFormat(pattern="yyyy-MM-dd")Date start,
                        @DateTimeFormat(pattern="yyyy-MM-dd")Date end, Model model){
        long uv = dataService.calculateUV(start,end);
        model.addAttribute("uvResult",uv);
        model.addAttribute("uvStartDate",start);
        model.addAttribute("uvEndDate",end);
        return "site/admin/data";
    }

    @PostMapping("/data/dau")
    public String getDAU(@DateTimeFormat(pattern="yyyy-MM-dd")Date start,
                        @DateTimeFormat(pattern="yyyy-MM-dd")Date end, Model model){
        long dau = dataService.calculateDAU(start,end);
        model.addAttribute("dauResult",dau);
        model.addAttribute("dauStartDate",start);
        model.addAttribute("dauEndDate",end);
        return "site/admin/data";
    }

}
