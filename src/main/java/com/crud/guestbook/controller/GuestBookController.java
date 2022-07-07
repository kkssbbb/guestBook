package com.crud.guestbook.controller;


import com.crud.guestbook.dto.GuestBookDto;
import com.crud.guestbook.dto.PageRequestDto;
import com.crud.guestbook.service.GuestBookService;
import com.crud.guestbook.service.GuestBookServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor //자동주입을위한 어노테이션
@Log4j2
@RequestMapping("/guestbook")
public class GuestBookController {

    private final GuestBookService guestBookService;

    @GetMapping("/")
    public String index(){
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")//글 목록
    public void list(PageRequestDto pageRequestDto, Model model){

        log.info("list............." + pageRequestDto);
model.addAttribute("result", guestBookService.getList(pageRequestDto));

    }

    //글등록 화면 요청
    @GetMapping("/register")
    public void register(){
        log.info("register get 요청");

    }
    //글등록 수정폼 전전달
    @PostMapping("/register")
    public String registerPost(GuestBookDto guestBookDto, RedirectAttributes redirectAttributes){

        log.info("register Post 요청");

        //새로 추가된 엔티티의 번호
        Long gno = guestBookService.register(guestBookDto);

        redirectAttributes.addFlashAttribute("msg", gno);
        //addFlashAttribute() = 단 한번만 데이터를 전달하는 용도로 쓰인다.
        return "redirect:/guestbook/list";

    }


///////////////
    @GetMapping("/test")
    public String test(){
        return "/guestbook/test";
    }
}
