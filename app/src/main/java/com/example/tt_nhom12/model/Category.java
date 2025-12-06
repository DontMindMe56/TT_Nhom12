package com.example.tt_nhom12.model;

public class Category {

    private int categoryId;
    private String uid;
    private String name;
    private String type;      // income | expense
    private long createdAt;   // timestamp
    private long updatedAt;
    private int isSynced;

    public Category() {
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
    }
    //Constructor không có categoryId
    public Category(String uid, String name, String type) {
        this.uid = uid;
        this.name = name;
        this.type = type;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
    }
    //Constructor có categoryId
    public Category(int categoryId, String uid, String name, String type,
                    long createdAt, long updatedAt, int isSynced) {
        this.categoryId = categoryId;
        this.uid = uid;
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isSynced = isSynced;
    }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

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
