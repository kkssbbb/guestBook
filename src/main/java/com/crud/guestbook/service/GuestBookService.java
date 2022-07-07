package com.crud.guestbook.service;

import com.crud.guestbook.dto.GuestBookDto;
import com.crud.guestbook.dto.PageRequestDto;
import com.crud.guestbook.dto.PageResultDto;
import com.crud.guestbook.entity.GuestBook;

public interface GuestBookService {
    Long register(GuestBookDto dto);

    PageResultDto<GuestBookDto, GuestBook> getList(PageRequestDto requestDto);




    // dto -> entity 변환 메서드
    default GuestBook dtoEntity(GuestBookDto guestBookDto){


        GuestBook guestBookEntity = GuestBook.builder()
                .gno(guestBookDto.getGno())
                .title(guestBookDto.getTitle())
                .content(guestBookDto.getContent())
                .writer(guestBookDto.getContent())
                .build();

        return guestBookEntity;
    }

    // entity -> dto 변환 메서드
    default GuestBookDto entityToDto(GuestBook entity) {

        GuestBookDto dto = GuestBookDto.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regData(entity.getRegDate())
                .modData(entity.getModDate())
                .build();

        return  dto;
    }
}
