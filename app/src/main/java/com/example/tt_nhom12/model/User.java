package com.example.tt_nhom12.model;

public class User {

    private int userId;            // primary key in local DB
    private String uid;            // Firebase UID (unique)
    private String email;
    private String displayName;
    private String photoUrl;
    private String provider;       // "google", "email", "anonymous", ...
    private long createdAt;        // timestamp (millis)
    private long lastLogin;
    private int isSynced;
    private long updatedAt;

    public User() {
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
    }
    public User(String uid, String email, String displayName,
                String photoUrl, String provider, long lastLogin) {
        this.uid = uid;
        this.email = email;
        this.displayName = displayName;
        this.photoUrl = photoUrl;
        this.provider = provider;
        this.lastLogin = lastLogin;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.isSynced = 0;
    }
    public User(int userId, String uid, String email, String displayName,
                String photoUrl, String provider, long createdAt,
                long lastLogin, long updatedAt, int isSynced) {
        this.userId = userId;
        this.uid = uid;
        this.email = email;
        this.displayName = displayName;
        this.photoUrl = photoUrl;
        this.provider = provider;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.updatedAt = updatedAt;
        this.isSynced = isSynced;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public long getLastLogin() { return lastLogin; }
    public void setLastLogin(long lastLogin) { this.lastLogin = lastLogin; }

    public int isSynced() { return isSynced; }
    public void setSynced(int synced) { isSynced = synced; }

    public long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(long updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
