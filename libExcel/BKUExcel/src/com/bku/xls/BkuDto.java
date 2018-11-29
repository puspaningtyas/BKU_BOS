package com.bku.xls;

import java.util.Date;

public class BkuDto {

    private Long id;

    private Date tanggal;

    private String noKode;

    private String noBukti;

    private String uraian;

    private Integer penerimaan;

    private Integer pengeluaran;
    
    private Integer saldo;

    private Date tanggalPelunasan;

    private String kodeAkreditasi;

    private String kodeKementrian;

    private String kodeBkd;

    private String kodeLaporanBos;

    private String statusPemeriksa;

    private Long npsn;

    private String fileName;

    private String fileType;

    public BkuDto() {

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getNpsn() {
        return npsn;
    }

    public void setNpsn(Long npsn) {
        this.npsn = npsn;
    }

    /**
     * @return the saldo
     */
    public Integer getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

}
