package com.project.bku.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2020;

public interface RepositoryBku2020 extends JpaRepository<Bku2020, Long> {

	@Query("SELECT b FROM Bku2020 b where b.sekolah.npsn =:npsn")
	List<Bku2020> findAllByNisn(@Param("npsn") Long npsn);
	
}
