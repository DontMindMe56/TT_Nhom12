package com.example.tt_nhom12.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tt_nhom12.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private SQLiteDatabase db;

    public CategoryDao(SQLiteDatabase db) {
        this.db = db;
    }

    public long insert(Category category) {
        ContentValues values = new ContentValues();
        values.put("user_id", category.getUid());
        values.put("name", category.getName());
        values.put("type", category.getType());
        values.put("created_at", category.getCreatedAt());
        values.put("is_synced", category.isSynced());
        values.put("updated_at", category.getUpdatedAt());

        return db.insert("categories", null, values);
    }

    public int update(Category category) {
        ContentValues values = new ContentValues();
        values.put("name", category.getName());
        values.put("type", category.getType());
        values.put("is_synced", category.isSynced());
        values.put("updated_at", category.getUpdatedAt());

        String[] args = {String.valueOf(category.getCategoryId())};
        return db.update("categories", values, "category_id = ?", args);
    }

    public int delete(int categoryId) {
        String[] args = {String.valueOf(categoryId)};
        return db.delete("categories", "category_id = ?", args);
    }

    public List<Category> getByUser(String uid) {
        List<Category> list = new ArrayList<>();

        String[] args = {uid};
        Cursor c = db.rawQuery("SELECT * FROM categories WHERE user_id = ?", args);

        while (c.moveToNext()) {
            Category category = cursorToCategory(c);
            list.add(category);
        }
        c.close();
        return list;
    }
    public Category cursorToCategory(Cursor c){
        return new Category(
                c.getInt(c.getColumnIndexOrThrow("category_id")),
                c.getString(c.getColumnIndexOrThrow("uid")),
                c.getString(c.getColumnIndexOrThrow("name")),
                c.getString(c.getColumnIndexOrThrow("type")),
                c.getLong(c.getColumnIndexOrThrow("created_at")),
                c.getLong(c.getColumnIndexOrThrow("updated_at")),
                c.getInt(c.getColumnIndexOrThrow("is_synced"))
        );
    }
}
