package com.blogspot.ketikanmd.agenda;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAgeda {
    private String error;
    @SerializedName("hasil")
    private List<AgendaModel> list;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<AgendaModel> getList() {
        return list;
    }

    public void setList(List<AgendaModel> list) {
        this.list = list;
    }
}
