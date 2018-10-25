package com.project.bku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bku.model.Sekolah;

@Repository
public interface SekolahRepository extends JpaRepository<Sekolah, Long>{

}
