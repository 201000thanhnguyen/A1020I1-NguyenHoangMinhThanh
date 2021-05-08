package models.bean;

public class Transaction {
    private String nameTransaction;
    private Double amountTransaction;
    private String ulrImgTransaction;

    public Transaction(String nameTransaction, Double amountTransaction, String ulrImgTransaction) {
        this.nameTransaction = nameTransaction;
        this.amountTransaction = amountTransaction;
        this.ulrImgTransaction = ulrImgTransaction;
    }

    public Transaction() {
    }

    public String getNameTransaction() {
        return nameTransaction;
    }

    public void setNameTransaction(String nameTransaction) {
        this.nameTransaction = nameTransaction;
    }

    public Double getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(Double amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public String getUlrImgTransaction() {
        return ulrImgTransaction;
    }

    public void setUlrImgTransaction(String ulrImgTransaction) {
        this.ulrImgTransaction = ulrImgTransaction;
    }
}
