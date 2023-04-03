package io.reactivestax.kubernetes.mapper;

import io.reactivestax.kubernetes.domain.Bookmark;
import io.reactivestax.kubernetes.dto.BookmarkDto;
import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {

    public BookmarkDto toDto(Bookmark bookmark){
        BookmarkDto bookmarkDto= new BookmarkDto(bookmark.getId(),bookmark.getUrl(),bookmark.getTitle(),
                bookmark.getCreatedAt());
//        bookmarkDto.setId(bookmark.getId());
//        bookmarkDto.setUrl(bookmark.getUrl());
//        bookmarkDto.setTitle(bookmark.getTitle());
//        bookmarkDto.setCreatedAt(bookmark.getCreatedAt());
        return bookmarkDto;
    }
}
