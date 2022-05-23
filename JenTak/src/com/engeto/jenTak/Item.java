package com.engeto.jenTak;

import java.math.BigDecimal;

public class Item {
    private String desc;
    private int pieces;
    private BigDecimal pricePerPiece;


    public Item(String desc, int pieces, BigDecimal pricePerPiece) {
        this.desc = desc;
        this.pieces = pieces;
        this.pricePerPiece = pricePerPiece;
    }
    public Item(String desc, int pieces, String pricePerPiece) {
        this(desc,pieces,new BigDecimal(pricePerPiece));
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public BigDecimal getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(BigDecimal pricePerPiece) {
        this.pricePerPiece = pricePerPiece;
    }

    public String getDescription() {
        return desc+" "+pieces+" ks ("+pricePerPiece.multiply(BigDecimal.valueOf(pieces))+" Kč";
    };
    @Override
    public String toString() {
        return super.toString()+" "+desc;
    }
}
