package com.crud.library.mapper;

import com.crud.library.domain.CopyOfBook;
import com.crud.library.dto.CopyOfBookDto;
import org.springframework.stereotype.Component;

@Component
public class CopyOfBookMapper {

    public CopyOfBook mapToCopyOfBook(final CopyOfBookDto copyOfBookDto) {
        return new CopyOfBook( copyOfBookDto.getStatus());
    }

    public CopyOfBookDto mopToCopyOfBookDto(final CopyOfBook copyOfBook) {
        return new CopyOfBookDto(copyOfBook.getStatus());
    }
}
