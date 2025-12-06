package com.example.tt_nhom12.model;

public class Budget {

    private int budgetId;
    private String uid;
    private int categoryId;

    private String name;
    private double warningAmount;
    private double maxAmount;
    private double totalSpent;

    private String periodType;
    private long cycleStart;
    private long cycleEnd;
    private int resetOnNewCycle;

    private long createdAt;
    private long updatedAt;
    private int isSynced;

    public Budget() {
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
        this.totalSpent = 0;
    }

    public Budget(String uid, int categoryId, String name,
                  double warningAmount, double maxAmount,
                  String periodType, long cycleStart, long cycleEnd, int resetOnNewCycle) {
        this.uid = uid;
        this.categoryId = categoryId;
        this.name = name;
        this.warningAmount = warningAmount;
        this.maxAmount = maxAmount;
        this.periodType = periodType;
        this.cycleStart = cycleStart;
        this.cycleEnd = cycleEnd;
        this.resetOnNewCycle = resetOnNewCycle;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
        this.totalSpent = 0;
    }
    public Budget(int budgetId, String uid, int categoryId, String name,
                  double warningAmount, double maxAmount, double totalSpent,
                  String periodType, long cycleStart, long cycleEnd, int resetOnNewCycle,
                  long createdAt, long updatedAt, int isSynced) {

        this.budgetId = budgetId;
        this.uid = uid;
        this.categoryId = categoryId;
        this.name = name;
        this.warningAmount = warningAmount;
        this.maxAmount = maxAmount;
        this.totalSpent = totalSpent;
        this.periodType = periodType;
        this.cycleStart = cycleStart;
        this.cycleEnd = cycleEnd;
        this.resetOnNewCycle = resetOnNewCycle;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isSynced = isSynced;
    }

    public int getBudgetId() { return budgetId; }
    public void setBudgetId(int budgetId) { this.budgetId = budgetId; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getWarningAmount() { return warningAmount; }
    public void setWarningAmount(double warningAmount) { this.warningAmount = warningAmount; }

    public double getMaxAmount() { return maxAmount; }
    public void setMaxAmount(double maxAmount) { this.maxAmount = maxAmount; }

    public double getTotalSpent() { return totalSpent; }
    public void setTotalSpent(double totalSpent) { this.totalSpent = totalSpent; }

    public String getPeriodType() { return periodType; }
    public void setPeriodType(String periodType) { this.periodType = periodType; }

    public long getCycleStart() { return cycleStart; }
    public void setCycleStart(long cycleStart) { this.cycleStart = cycleStart; }

    public long getCycleEnd() { return cycleEnd; }
    public void setCycleEnd(long cycleEnd) { this.cycleEnd = cycleEnd; }

    public int isResetOnNewCycle() { return resetOnNewCycle; }
    public void setResetOnNewCycle(int resetOnNewCycle) { this.resetOnNewCycle = resetOnNewCycle; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }

    public int isSynced() { return isSynced; }
    public void setIsSynced(int isSynced) { this.isSynced = isSynced; }
}

