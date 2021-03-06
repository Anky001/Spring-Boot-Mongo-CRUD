package com.springmongo.springmongo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "BookModel")
public class BookModel {
    @Id
    private String id;
    private String bookName;
    private String authorName;
}
