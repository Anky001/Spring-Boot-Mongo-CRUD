package com.springmongo.springmongo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "UserDetails")
public class UserDetails {
    @Id
    String userId;
    String name;
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    String password;
    String email;
}
