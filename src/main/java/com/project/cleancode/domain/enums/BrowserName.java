package com.project.cleancode.domain.enums;

public enum BrowserName {
    UNKNOWN("Unknown"),
    INTERNET_EXPLORER("Internet Explorer"),
    FIREFOX("Firefox"),
    CHROME("Google Chrome"),
    OPERA("Opera"),
    SAFARI("Safari");


    private String descricao;

    BrowserName(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
