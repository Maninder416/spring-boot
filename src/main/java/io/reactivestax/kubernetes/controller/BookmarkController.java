package io.reactivestax.kubernetes.controller;

import io.reactivestax.kubernetes.domain.Bookmark;
import io.reactivestax.kubernetes.dto.BookmarkDto;
import io.reactivestax.kubernetes.dto.BookmarksDto;
import io.reactivestax.kubernetes.request.BookmarkRequest;
import io.reactivestax.kubernetes.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;
    @GetMapping
    public BookmarksDto getBookmarks(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                     @RequestParam(name = "query", defaultValue = "")String query) {
        if(query==null || query.trim().length() ==0){
            return bookmarkService.getBookmarks(page);
        }
        return bookmarkService.searchBookmarks(query,page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDto createBookmarks(@Valid @RequestBody BookmarkRequest request) {
        return bookmarkService.saveBookmark(request);
    }
}
