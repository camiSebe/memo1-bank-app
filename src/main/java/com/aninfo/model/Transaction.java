package com.aninfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionID;
    private String type;

    private Long cbu;

    private Double amount;


    public Transaction(){
    }

    public Transaction(Double amount) {
        this.amount = amount;
    }


    // transactionID get y set
    public Long getTransactionID() {
        return transactionID;
    }
    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }


    // type get y set
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    // CBU get y set
    public Long getCbu() {
        return cbu;
    }
    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }


    // amount get y set
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

}


