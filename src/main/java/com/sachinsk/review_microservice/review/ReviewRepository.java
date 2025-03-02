package com.sachinsk.review_microservice.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);

    //So we don't need to provide the implementation of the above method,
    // Spring data JPA breaks down the method name and provide it's implementation on it's own
}
