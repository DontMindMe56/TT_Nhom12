package com.example.tt_nhom12.model;

public class Income {

    private int incomeId;
    private String uid;
    private int categoryId;
    private double amount;
    private long date;          // timestamp
    private String note;
    private long createdAt;
    private long updatedAt;
    private int isSynced;

    public Income() {
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
    }
    public Income(String uid, int categoryId, double amount, long date, String note) {
        this.uid = uid;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
    }
    public Income(int incomeId, String uid, int categoryId, double amount,
                  long date, String note, long createdAt, long updatedAt, int isSynced) {
        this.incomeId = incomeId;
        this.uid = uid;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isSynced = isSynced;
    }

    // Getters & setters
    public int getIncomeId() { return incomeId; }
    public void setIncomeId(int incomeId) { this.incomeId = incomeId; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public long getDate() { return date; }
    public void setDate(long date) { this.date = date; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public int isSynced() { return isSynced; }
    public void setSynced(int synced) { isSynced = synced; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Income: " + amount + " (Category: " + categoryId + ")";
    }
}
