package com.sanity.nil.repository;

import com.sanity.nil.model.Analysis;
import com.sanity.nil.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

    List<Diagnosis> findAllByPetId(long petId);
}
