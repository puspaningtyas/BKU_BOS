package com.project.bku.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2023;

public interface RepositoryBku2023 extends JpaRepository<Bku2023, Long> {
	
	@Query("SELECT b FROM Bku2023 b where b.sekolah.npsn =:npsn")
	List<Bku2023> findAllByNpsn(@Param("npsn") Long npsn);

	@Query("SELECT b FROM Bku2023 b where b.sekolah.npsn =:npsn AND b.id =:id")
	Optional<Bku2023> findByIdNpsn(@Param("id") Long id, @Param("npsn")Long npsn);

	Page<Bku2023> findAllBySekolahNpsn(Long npsn, Pageable pageable);
}
