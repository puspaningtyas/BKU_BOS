package com.project.bku.excelreader;

import java.util.Date;

/**
 *
 * @author user only
 */
public class Bku {

    private long npsn;
    private String kodeAkreditasi;
    private String kodeBkd;
    private String kodeKementrian;
    private String kodeLaporanBos;
    private String noBukti;
    private String noKode;
    private Integer penerimaan;
    private Integer pengeluaran;

    //default null
    private String statusPemeriksa;
    private Date tanggal;
    private Date tanggalPelunasan;
    private String uraian;

    public Bku() {
    }

    public Bku(long npsn, String kodeAkreditasi, String kodeBkd, String kodeKementrian, String kodeLaporanBos, String noBukti, String noKode, Integer penerimaan, Integer pengeluaran, String statusPemeriksa, Date tanggal, Date tanggalPelunasan, String uraian) {
        this.npsn = npsn;
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

    /**
     * @return the npsn
     */
    public long getNpsn() {
        return npsn;
    }

    /**
     * @param npsn the npsn to set
     */
    public void setNpsn(long npsn) {
        this.npsn = npsn;
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