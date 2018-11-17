package com.project.bku.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2028;

public interface RepositoryBku2028 extends JpaRepository<Bku2028, Long> {
	
	@Query("SELECT b FROM Bku2028 b where b.sekolah.npsn =:npsn")
	List<Bku2028> findAllByNisn(@Param("npsn") Long npsn);

	@Query("SELECT b FROM Bku2028 b where b.sekolah.npsn =:npsn AND b.id =:id")
	Optional<Bku2028> findByIdNpsn(@Param("id") Long id, @Param("npsn")Long npsn);
}
