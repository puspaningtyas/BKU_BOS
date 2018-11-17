package com.project.bku.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2021;

public interface RepositoryBku2021 extends JpaRepository<Bku2021, Long> {

	@Query("SELECT b FROM Bku2021 b where b.sekolah.npsn =:npsn")
	List<Bku2021> findAllByNisn(@Param("npsn") Long npsn);

	@Query("SELECT b FROM Bku2021 b where b.sekolah.npsn =:npsn AND b.id =:id")
	Optional<Bku2021> findByIdNpsn(@Param("id") Long id, @Param("npsn")Long npsn);
}
