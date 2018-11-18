package com.project.bku.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2025;

public interface RepositoryBku2025 extends JpaRepository<Bku2025, Long> {
	
	@Query("SELECT b FROM Bku2025 b where b.sekolah.npsn =:npsn")
	List<Bku2025> findAllByNpsn(@Param("npsn") Long npsn);

	@Query("SELECT b FROM Bku2025 b where b.sekolah.npsn =:npsn AND b.id =:id")
	Optional<Bku2025> findByIdNpsn(@Param("id") Long id, @Param("npsn")Long npsn);

	Page<Bku2025> findAllBySekolahNpsn(Long npsn, Pageable pageable);
}
