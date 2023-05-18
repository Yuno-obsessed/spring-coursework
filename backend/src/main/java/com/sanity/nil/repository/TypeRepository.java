package com.sanity.nil.repository;

import com.sanity.nil.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    boolean existsByNameIgnoreCase(String name);
}
