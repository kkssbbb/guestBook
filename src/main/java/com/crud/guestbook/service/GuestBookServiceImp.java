package com.crud.guestbook.service;

import com.crud.guestbook.dto.GuestBookDto;
import com.crud.guestbook.dto.PageRequestDto;
import com.crud.guestbook.dto.PageResultDto;
import com.crud.guestbook.entity.GuestBook;
import com.crud.guestbook.repository.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor // 의존성자동 주입
public class GuestBookServiceImp  implements GuestBookService{

    private final GuestBookRepository repository;

    @Override
    public Long register(GuestBookDto dto) {
        log.info("=============dto=============");
        log.info(String.valueOf(dto));

        GuestBook entity = dtoEntity(dto);

        log.info(String.valueOf(entity));

        repository.save(entity);

        return entity.getGno();
    }

    @Override
    public PageResultDto<GuestBookDto, GuestBook> getList(PageRequestDto requestDto) {

        Pageable pageable = requestDto.getPageable(Sort.by("gno").descending());

        Page<GuestBook> result = repository.findAll(pageable);

        Function<GuestBook, GuestBookDto> fn = (entity -> entityToDto(entity));

        return new PageResultDto<>(result, fn);
    }


}
