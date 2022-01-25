package com.example.mymobileapplication.data;

public class Cart {
    public int transaction_id;
    public int product_id;
    public int qty;
    public int amount;
    public int status;

    public Cart(int transaction_id, int product_id, int qty, int amount, int status) {
        this.transaction_id = transaction_id;
        this.product_id = product_id;
        this.qty = qty;
        this.amount = amount;
        this.status = status;
    }

    public Cart() {
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
