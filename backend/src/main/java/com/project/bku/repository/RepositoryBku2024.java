package com.project.bku.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2024;

public interface RepositoryBku2024 extends JpaRepository<Bku2024, Long> {

	@Query("SELECT b FROM Bku2024 b where b.sekolah.npsn =:npsn")
	List<Bku2024> findAllByNisn(@Param("npsn") Long npsn);
}
