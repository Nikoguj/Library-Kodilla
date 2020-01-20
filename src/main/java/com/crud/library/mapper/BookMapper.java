package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getYearOfPublication());
    }
    
    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getTitle(), book.getAuthor(), book.getYearOfPublication());
    }
}
