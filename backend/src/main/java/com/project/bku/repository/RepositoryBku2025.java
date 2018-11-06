package com.project.bku.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2025;

public interface RepositoryBku2025 extends JpaRepository<Bku2025, Long> {
	
	@Query("SELECT b FROM Bku2025 b where b.sekolah.npsn =:npsn")
	List<Bku2025> findAllByNisn(@Param("npsn") Long npsn);
}
