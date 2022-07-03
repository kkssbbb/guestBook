package com.crud.guestbook.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/guestbook")
public class GuestBookController {

    @GetMapping({"/","/list"})
    public String list(){
        log.info("리스트메서드 호출..");
        return "/guestbook/list";
    }
}
