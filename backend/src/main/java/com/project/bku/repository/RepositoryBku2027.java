package com.project.bku.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2027;

public interface RepositoryBku2027 extends JpaRepository<Bku2027, Long> {
	
	@Query("SELECT b FROM Bku2027 b where b.sekolah.npsn =:npsn")
	List<Bku2027> findAllByNisn(@Param("npsn") Long npsn);
}
