/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.pojos;

import java.util.Date;

/**
 *
 * @author user only
 */
public class Bku {

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

    public Bku() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the sekolah
     */
    public Sekolah getSekolah() {
        return sekolah;
    }

    /**
     * @param sekolah the sekolah to set
     */
    public void setSekolah(Sekolah sekolah) {
        this.sekolah = sekolah;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the createdBy
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the fileBukti
     */
    public String getFileBukti() {
        return fileBukti;
    }

    /**
     * @param fileBukti the fileBukti to set
     */
    public void setFileBukti(String fileBukti) {
        this.fileBukti = fileBukti;
    }

    /**
     * @return the kodeAkreditasi
     */
    public String getKodeAkreditasi() {
        return kodeAkreditasi;
    }

    /**
     * @param kodeAkreditasi the kodeAkreditasi to set
     */
    public void setKodeAkreditasi(String kodeAkreditasi) {
        this.kodeAkreditasi = kodeAkreditasi;
    }

    /**
     * @return the kodeBkd
     */
    public String getKodeBkd() {
        return kodeBkd;
    }

    /**
     * @param kodeBkd the kodeBkd to set
     */
    public void setKodeBkd(String kodeBkd) {
        this.kodeBkd = kodeBkd;
    }

    /**
     * @return the kodeKementrian
     */
    public String getKodeKementrian() {
        return kodeKementrian;
    }

    /**
     * @param kodeKementrian the kodeKementrian to set
     */
    public void setKodeKementrian(String kodeKementrian) {
        this.kodeKementrian = kodeKementrian;
    }

    /**
     * @return the kodeLaporanBos
     */
    public String getKodeLaporanBos() {
        return kodeLaporanBos;
    }

    /**
     * @param kodeLaporanBos the kodeLaporanBos to set
     */
    public void setKodeLaporanBos(String kodeLaporanBos) {
        this.kodeLaporanBos = kodeLaporanBos;
    }

    /**
     * @return the noBukti
     */
    public String getNoBukti() {
        return noBukti;
    }

    /**
     * @param noBukti the noBukti to set
     */
    public void setNoBukti(String noBukti) {
        this.noBukti = noBukti;
    }

    /**
     * @return the noKode
     */
    public String getNoKode() {
        return noKode;
    }

    /**
     * @param noKode the noKode to set
     */
    public void setNoKode(String noKode) {
        this.noKode = noKode;
    }

    /**
     * @return the penerimaan
     */
    public Integer getPenerimaan() {
        return penerimaan;
    }

    /**
     * @param penerimaan the penerimaan to set
     */
    public void setPenerimaan(Integer penerimaan) {
        this.penerimaan = penerimaan;
    }

    /**
     * @return the pengeluaran
     */
    public Integer getPengeluaran() {
        return pengeluaran;
    }

    /**
     * @param pengeluaran the pengeluaran to set
     */
    public void setPengeluaran(Integer pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    /**
     * @return the statusPemeriksa
     */
    public String getStatusPemeriksa() {
        return statusPemeriksa;
    }

    /**
     * @param statusPemeriksa the statusPemeriksa to set
     */
    public void setStatusPemeriksa(String statusPemeriksa) {
        this.statusPemeriksa = statusPemeriksa;
    }

    /**
     * @return the tanggal
     */
    public Date getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * @return the tanggalPelunasan
     */
    public Date getTanggalPelunasan() {
        return tanggalPelunasan;
    }

    /**
     * @param tanggalPelunasan the tanggalPelunasan to set
     */
    public void setTanggalPelunasan(Date tanggalPelunasan) {
        this.tanggalPelunasan = tanggalPelunasan;
    }

    /**
     * @return the uraian
     */
    public String getUraian() {
        return uraian;
    }

    /**
     * @param uraian the uraian to set
     */
    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

}
