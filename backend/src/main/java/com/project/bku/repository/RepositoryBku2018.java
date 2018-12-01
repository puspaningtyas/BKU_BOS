package com.project.bku.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.project.bku.model.Sekolah;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.bku.model.Bku2018;

import javax.transaction.Transactional;

public interface RepositoryBku2018 extends JpaRepository<Bku2018, Long> {
	
	@Query("SELECT b FROM Bku2018 b where b.sekolah.npsn =:npsn")
	List<Bku2018> findAllByNpsn(@Param("npsn") Long npsn);

	@Query("SELECT b FROM Bku2018 b where b.sekolah.npsn =:npsn AND b.id =:id")
    Optional<Bku2018> findByIdNpsn(@Param("id") Long id, @Param("npsn")Long npsn);

    Page<Bku2018> findAllBySekolahNpsn(Long npsn, Pageable pageable);

	//Please fix using get by month & npsn
	List<Bku2018> findAllBySekolahNpsnAndTanggalBetween(Long npsn, Date start, Date end);

    //Please fix using delete by month & npsn
	@Transactional
	void deleteBySekolahNpsnAndTanggalBetween(Long npsn, Date start, Date end);

    @Transactional
	void deleteByUraian(String uraian);
}
