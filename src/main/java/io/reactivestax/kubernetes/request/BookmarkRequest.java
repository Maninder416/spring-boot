package io.reactivestax.kubernetes.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BookmarkRequest {
    @NotEmpty(message = "Title should not be empty")
    private String title;
    @NotEmpty(message = "URL should not be empty")
    private String url;
}
