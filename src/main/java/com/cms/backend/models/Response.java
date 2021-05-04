package com.cms.backend.models;

import java.util.List;

public class Response {

    public boolean success;
    public List data;

    public Response(boolean status, Iterable<Question> data) {
        this.success = status;
        this.data = (List) data;
    }
}
