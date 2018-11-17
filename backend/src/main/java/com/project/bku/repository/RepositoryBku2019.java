package com.project.bku.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2019;

public interface RepositoryBku2019 extends JpaRepository<Bku2019, Long> {

	@Query("SELECT b FROM Bku2019 b where b.sekolah.npsn =:npsn")
	List<Bku2019> findAllByNisn(@Param("npsn") Long npsn);

	@Query("SELECT b FROM Bku2019 b where b.sekolah.npsn =:npsn AND b.id =:id")
	Optional<Bku2019> findByIdNpsn(@Param("id") Long id, @Param("npsn")Long npsn);
}
