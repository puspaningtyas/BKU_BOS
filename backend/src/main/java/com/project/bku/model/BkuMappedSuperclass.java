package com.project.bku.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.bku.model.audit.UserDateAudit;

@MappedSuperclass
public class BkuMappedSuperclass extends UserDateAudit implements Serializable{

	private static final long serialVersionUID = 6058751200888924794L;

	private static final String TIMEZONE = "Asia/Jakarta";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone=TIMEZONE)
	@NotNull
	private Date tanggal;

	private String noKode;

	private String noBukti;

	@NotBlank
	private String uraian;

	private Integer penerimaan;

	private Integer pengeluaran;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone=TIMEZONE)
	private Date tanggalPelunasan;

	private String kodeAkreditasi;

	private String kodeKementrian;

	private String kodeBkd;

	private String kodeLaporanBos;

	private String statusPemeriksa;

	private String fileBukti;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "npsn", nullable = false)
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