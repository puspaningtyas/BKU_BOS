package com.project.bku.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import com.project.generic.model.GenericUserDateAudit;

//namaFileUniqe

@MappedSuperclass
public abstract class BkuMappedSuperclass extends GenericUserDateAudit implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private Date tanggal;

	private String noKode;

	private String noBukti;

	@NotBlank
	private String uraian;

	private Integer penerimaan;

	private Integer pengeluaran;

	private Date tanggalPelunasan;
//
	private String kodeAkreditasi;

	private String kodeKementrian;

	private String kodeBkd;

	private String kodeLaporanBos;
//
	private String statusPemeriksa;

	private String fileBukti;//tanggalupload_tanggalkegiatan_idsekolah

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sekolah_id", nullable = false)
	private Sekolah sekolah;

	public BkuMappedSuperclass() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getNoKode() {
		return noKode;
	}

	public void setNoKode(String noKode) {
		this.noKode = noKode;
	}

	public String getNoBukti() {
		return noBukti;
	}

	public void setNoBukti(String noBukti) {
		this.noBukti = noBukti;
	}

	public String getUraian() {
		return uraian;
	}

	public void setUraian(String uraian) {
		this.uraian = uraian;
	}

	public Integer getPenerimaan() {
		return penerimaan;
	}

	public void setPenerimaan(Integer penerimaan) {
		this.penerimaan = penerimaan;
	}

	public Integer getPengeluaran() {
		return pengeluaran;
	}

	public void setPengeluaran(Integer pengeluaran) {
		this.pengeluaran = pengeluaran;
	}

	public Date getTanggalPelunasan() {
		return tanggalPelunasan;
	}

	public void setTanggalPelunasan(Date tanggalPelunasan) {
		this.tanggalPelunasan = tanggalPelunasan;
	}

	public String getKodeAkreditasi() {
		return kodeAkreditasi;
	}

	public void setKodeAkreditasi(String kodeAkreditasi) {
		this.kodeAkreditasi = kodeAkreditasi;
	}

	public String getKodeKementrian() {
		return kodeKementrian;
	}

	public void setKodeKementrian(String kodeKementrian) {
		this.kodeKementrian = kodeKementrian;
	}

	public String getKodeBkd() {
		return kodeBkd;
	}

	public void setKodeBkd(String kodeBkd) {
		this.kodeBkd = kodeBkd;
	}

	public Sekolah getSekolah() {
		return sekolah;
	}

	public void setSekolah(Sekolah sekolah) {
		this.sekolah = sekolah;
	}

	public String getKodeLaporanBos() {
		return kodeLaporanBos;
	}

	public void setKodeLaporanBos(String kodeLaporanBos) {
		this.kodeLaporanBos = kodeLaporanBos;
	}

	public String getStatusPemeriksa() {
		return statusPemeriksa;
	}

	public void setStatusPemeriksa(String statusPemeriksa) {
		this.statusPemeriksa = statusPemeriksa;
	}

	public String getFileBukti() {
		return fileBukti;
	}

	public void setFileBukti(String fileBukti) {
		this.fileBukti = fileBukti;
	}
	
}