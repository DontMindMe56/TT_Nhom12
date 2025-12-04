package com.example.tt_nhom12.model;

public class Income {

    private int incomeId;
    private int userId;
    private int categoryId;
    private double amount;
    private long date;          // timestamp
    private String note;
    private long createdAt;
    private int isSynced;
    private long updatedAt;

    public Income() {
    }
    public Income(int userId, int categoryId, double amount, long date, String note) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.createdAt = System.currentTimeMillis();
        this.isSynced = 0;
        this.updatedAt = System.currentTimeMillis();
    }
    public Income(int incomeId, int userId, int categoryId, double amount,
                  long date, String note, long createdAt, int isSynced, long updatedAt) {
        this.incomeId = incomeId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.note = note;
        this.createdAt = createdAt;
        this.isSynced = isSynced;
        this.updatedAt = updatedAt;
    }

    // Getters & setters
    public int getIncomeId() { return incomeId; }
    public void setIncomeId(int incomeId) { this.incomeId = incomeId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

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
