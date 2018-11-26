package com.project.bku.payload;

public class SekolahDtoSimple {

    private Long npsn;

    private String namaSekolah;

    public SekolahDtoSimple(Long npsn, String namaSekolah) {
        this.npsn = npsn;
        this.namaSekolah = namaSekolah;
    }

    public SekolahDtoSimple() {
    }

    public Long getNpsn() {
        return npsn;
    }

    public void setNpsn(Long npsn) {
        this.npsn = npsn;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }
}
