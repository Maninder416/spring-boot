package io.reactivestax.kubernetes.mapper;

import io.reactivestax.kubernetes.domain.Bookmark;
import io.reactivestax.kubernetes.dto.BookmarkDto;
import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {

    public BookmarkDto toDto(Bookmark bookmark){
        BookmarkDto bookmarkDto= new BookmarkDto(bookmark.getId(),bookmark.getTitle(),bookmark.getUrl(),
                bookmark.getCreatedAt());
        return bookmarkDto;
    }
}
