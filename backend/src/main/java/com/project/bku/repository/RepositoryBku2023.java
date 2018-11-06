package com.project.bku.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2023;

public interface RepositoryBku2023 extends JpaRepository<Bku2023, Long> {
	
	@Query("SELECT b FROM Bku2023 b where b.sekolah.npsn =:npsn")
	List<Bku2023> findAllByNisn(@Param("npsn") Long npsn);
}
