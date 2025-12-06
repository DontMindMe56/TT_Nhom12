package com.example.tt_nhom12.model;

public class Expense {

    private int expenseId;
    private String uid;
    private int categoryId;
    private double amount;
    private long date;        // timestamp
    private String note;
    private long createdAt;
    private long updatedAt;
    private int isSynced;

    public Expense() {
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
    }
    public Expense(String uid, int categoryId, double amount, long date, String note) {
        this.uid = uid;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
    }
    public Expense(int expenseId, String uid, int categoryId, double amount,
                   long date, String note, long createdAt, long updatedAt, int isSynced) {
        this.expenseId = expenseId;
        this.uid = uid;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isSynced = isSynced;
    }

    // Getters and Setters
    public int getExpenseId() { return expenseId; }
    public void setExpenseId(int expenseId) { this.expenseId = expenseId; }

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
        return "Expense: " + amount + " (Category: " + categoryId + ")";
    }
}
