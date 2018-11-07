/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bku.helper;

import com.bku.pojos.Sekolah;
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

    public Bku(Sekolah sekolah, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy, String fileBukti, String kodeAkreditasi, String kodeBkd, String kodeKementrian, String kodeLaporanBos, String noBukti, String noKode, Integer penerimaan, Integer pengeluaran, String statusPemeriksa, Date tanggal, Date tanggalPelunasan, String uraian) {
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

}
