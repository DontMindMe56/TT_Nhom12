package com.example.tt_nhom12.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tt_nhom12.model.User;

public class UserDao {
    private SQLiteDatabase db;

    public UserDao(SQLiteDatabase db) {
        this.db = db;
    }

    public long insert(User user) {
        ContentValues values = new ContentValues();
        values.put("uid", user.getUid());
        values.put("email", user.getEmail());
        values.put("display_name", user.getDisplayName());
        values.put("photo_url", user.getPhotoUrl());
        values.put("provider", user.getProvider());
        values.put("created_at", user.getCreatedAt());
        values.put("last_login", user.getLastLogin());
        values.put("is_synced", user.isSynced());
        values.put("updated_at", user.getUpdatedAt());

        return db.insert("users", null, values);
    }

    public int update(User user) {
        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("display_name", user.getDisplayName());
        values.put("photo_url", user.getPhotoUrl());
        values.put("provider", user.getProvider());
        values.put("last_login", user.getLastLogin());
        values.put("is_synced", user.isSynced());
        values.put("updated_at", user.getUpdatedAt());

        String[] args = {String.valueOf(user.getUserId())};
        return db.update("users", values, "uid = ?", args);
    }

    // Get user by UID not UserId
    public User getByUid(String uid) {
        String[] args = {String.valueOf(uid)};
        Cursor c = db.rawQuery("SELECT * FROM users WHERE uid = ?", args);

        if (c.moveToFirst()) {
            User user = new User(
                    c.getInt(c.getColumnIndexOrThrow("user_id")),
                    c.getString(c.getColumnIndexOrThrow("uid")),
                    c.getString(c.getColumnIndexOrThrow("email")),
                    c.getString(c.getColumnIndexOrThrow("display_name")),
                    c.getString(c.getColumnIndexOrThrow("photo_url")),
                    c.getString(c.getColumnIndexOrThrow("provider")),
                    c.getLong(c.getColumnIndexOrThrow("created_at")),
                    c.getLong(c.getColumnIndexOrThrow("last_login")),
                    c.getInt(c.getColumnIndexOrThrow("is_synced")),
                    c.getLong(c.getColumnIndexOrThrow("updated_at"))
            );
            c.close();
            return user;
        }
        c.close();
        return null;
    }
}
