package com.bku.pojos;
// Generated Nov 1, 2018 9:41:32 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Bku2025 generated by hbm2java
 */
public class Bku2025  implements java.io.Serializable {


     private long id;
     private Sekolah sekolah;
     private Date createdAt;
     private Date updatedAt;
     private Long createdBy;
     private Long updatedBy;
     private String fileBukti;
     private String kodeAkreditasi;
     private String kodeBkd;
     private String kodeKementrian;
     private String kodeLaporanBos;
     private String noBukti;
     private String noKode;
     private Integer penerimaan;
     private Integer pengeluaran;
     private String statusPemeriksa;
     private Date tanggal;
     private Date tanggalPelunasan;
     private String uraian;

    public Bku2025() {
    }

	
    public Bku2025(long id, Sekolah sekolah, Date createdAt, Date updatedAt) {
        this.id = id;
        this.sekolah = sekolah;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Bku2025(long id, Sekolah sekolah, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy, String fileBukti, String kodeAkreditasi, String kodeBkd, String kodeKementrian, String kodeLaporanBos, String noBukti, String noKode, Integer penerimaan, Integer pengeluaran, String statusPemeriksa, Date tanggal, Date tanggalPelunasan, String uraian) {
       this.id = id;
       this.sekolah = sekolah;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.createdBy = createdBy;
       this.updatedBy = updatedBy;
       this.fileBukti = fileBukti;
       this.kodeAkreditasi = kodeAkreditasi;
       this.kodeBkd = kodeBkd;
       this.kodeKementrian = kodeKementrian;
       this.kodeLaporanBos = kodeLaporanBos;
       this.noBukti = noBukti;
       this.noKode = noKode;
       this.penerimaan = penerimaan;
       this.pengeluaran = pengeluaran;
       this.statusPemeriksa = statusPemeriksa;
       this.tanggal = tanggal;
       this.tanggalPelunasan = tanggalPelunasan;
       this.uraian = uraian;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Sekolah getSekolah() {
        return this.sekolah;
    }
    
    public void setSekolah(Sekolah sekolah) {
        this.sekolah = sekolah;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getFileBukti() {
        return this.fileBukti;
    }
    
    public void setFileBukti(String fileBukti) {
        this.fileBukti = fileBukti;
    }
    public String getKodeAkreditasi() {
        return this.kodeAkreditasi;
    }
    
    public void setKodeAkreditasi(String kodeAkreditasi) {
        this.kodeAkreditasi = kodeAkreditasi;
    }
    public String getKodeBkd() {
        return this.kodeBkd;
    }
    
    public void setKodeBkd(String kodeBkd) {
        this.kodeBkd = kodeBkd;
    }
    public String getKodeKementrian() {
        return this.kodeKementrian;
    }
    
    public void setKodeKementrian(String kodeKementrian) {
        this.kodeKementrian = kodeKementrian;
    }
    public String getKodeLaporanBos() {
        return this.kodeLaporanBos;
    }
    
    public void setKodeLaporanBos(String kodeLaporanBos) {
        this.kodeLaporanBos = kodeLaporanBos;
    }
    public String getNoBukti() {
        return this.noBukti;
    }
    
    public void setNoBukti(String noBukti) {
        this.noBukti = noBukti;
    }
    public String getNoKode() {
        return this.noKode;
    }
    
    public void setNoKode(String noKode) {
        this.noKode = noKode;
    }
    public Integer getPenerimaan() {
        return this.penerimaan;
    }
    
    public void setPenerimaan(Integer penerimaan) {
        this.penerimaan = penerimaan;
    }
    public Integer getPengeluaran() {
        return this.pengeluaran;
    }
    
    public void setPengeluaran(Integer pengeluaran) {
        this.pengeluaran = pengeluaran;
    }
    public String getStatusPemeriksa() {
        return this.statusPemeriksa;
    }
    
    public void setStatusPemeriksa(String statusPemeriksa) {
        this.statusPemeriksa = statusPemeriksa;
    }
    public Date getTanggal() {
        return this.tanggal;
    }
    
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    public Date getTanggalPelunasan() {
        return this.tanggalPelunasan;
    }
    
    public void setTanggalPelunasan(Date tanggalPelunasan) {
        this.tanggalPelunasan = tanggalPelunasan;
    }
    public String getUraian() {
        return this.uraian;
    }
    
    public void setUraian(String uraian) {
        this.uraian = uraian;
    }




}


