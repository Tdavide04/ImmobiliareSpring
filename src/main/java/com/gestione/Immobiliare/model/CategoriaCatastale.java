package com.gestione.Immobiliare.model;

public enum CategoriaCatastale {

    // Abitazioni
    A1("A/1", "Abitazioni di tipo signorile"),
    A2("A/2", "Abitazioni civili"),
    A3("A/3", "Abitazioni economiche"),
    A4("A/4", "Abitazioni popolari"),
    A5("A/5", "Abitazioni ultrapopolari"),
    A6("A/6", "Abitazioni rurali"),
    A7("A/7", "Ville"),
    A8("A/8", "Abitazioni in villini"),
    A9("A/9", "Castelli e palazzi di pregio storico"),
    A10("A/10", "Uffici e studi privati"),
    A11("A/11", "Abitazioni particolari (coloniche)"),

    // Collegi, convitti, pensioni
    B1("B/1", "Collegi e convitti"),
    B2("B/2", "Ospizi e pensioni"),

    // Negozi e laboratori
    C1("C/1", "Negozi e botteghe"),
    C2("C/2", "Magazzini e locali di deposito"),
    C3("C/3", "Laboratori per arti e mestieri"),

    // Fabbricati produttivi e speciali
    D1("D/1", "Opifici industriali"),
    D2("D/2", "Alberghi"),
    D3("D/3", "Teatri e cinema"),
    D4("D/4", "Case di cura e ospedali"),
    D5("D/5", "Istituti di credito e banche"),
    D6("D/6", "Fabbricati sportivi e per divertimento"),
    D7("D/7", "Fabbricati agricoli per lavorazione prodotti"),

    // Fabbricati pubblici e particolari
    E1("E/1", "Stazioni, porti, aeroporti"),
    E2("E/2", "Monumenti, chiese, musei"),

    // Terreni
    F1("F/1", "Terreni agricoli"),
    F2("F/2", "Boschi e terreni forestali");

    private final String codice;
    private final String descrizione;

    CategoriaCatastale(String codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

}
