package com.cms.backend.data;

import com.cms.backend.models.Inquiry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface InquiryRepository extends MongoRepository<Inquiry, String> {
    Optional<Inquiry> findById(String id);
}


