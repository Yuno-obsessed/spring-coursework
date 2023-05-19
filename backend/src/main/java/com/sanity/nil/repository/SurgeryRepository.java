package com.sanity.nil.repository;

import com.sanity.nil.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Long> {

    List<Surgery> findAllByPetId(long petId);

    List<Surgery> findAllByUserId(long userId);
}
