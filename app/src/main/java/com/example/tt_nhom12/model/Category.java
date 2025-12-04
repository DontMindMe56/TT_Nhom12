package com.example.tt_nhom12.model;

public class Category {

    private int categoryId;
    private int userId;
    private String name;
    private String type;      // income | expense
    private long createdAt;   // timestamp
    private int isSynced;
    private long updatedAt;

    public Category() {
    }
    //Constructor không có categoryId
    public Category(int userId, String name, String type) {
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.createdAt = System.currentTimeMillis();
        this.isSynced = 0;
        this.updatedAt = System.currentTimeMillis();
    }
    //Constructor có categoryId
    public Category(int categoryId, int userId, String name, String type,
                    long createdAt, int isSynced, long updatedAt) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
        this.isSynced = isSynced;
        this.updatedAt = updatedAt;
    }

    // Getters & setters
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public int isSynced() { return isSynced; }
    public void setSynced(int synced) { isSynced = synced; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}
