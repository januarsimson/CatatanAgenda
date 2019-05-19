package com.blogspot.ketikanmd.agenda;

public class AgendaModel {
    private int id;
    private String agenda;
    private String tanggal;
    private String tempat;
    private String keterangan;
    private String status;

    public AgendaModel(){

    }

    public AgendaModel(int id, String agenda, String tanggal, String tempat, String keterangan, String status) {
        this.id = id;
        this.agenda = agenda;
        this.tanggal = tanggal;
        this.tempat = tempat;
        this.keterangan = keterangan;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AgendaModel{" +
                "id=" + id +
                ", agenda='" + agenda + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", tempat='" + tempat + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
