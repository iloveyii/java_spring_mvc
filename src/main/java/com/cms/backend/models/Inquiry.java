package com.cms.backend.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@ToString

@Document(collection = "inquiries")
public class Inquiry {
    @Id
    private String _id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String language_from;
    private String language_to;
    private String notes;
    private Integer status;
}
