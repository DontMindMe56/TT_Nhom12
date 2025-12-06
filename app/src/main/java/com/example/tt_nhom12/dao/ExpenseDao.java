package com.example.tt_nhom12.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tt_nhom12.model.Category;
import com.example.tt_nhom12.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
    private SQLiteDatabase db;

    public ExpenseDao(SQLiteDatabase db) {
        this.db = db;
    }

    // Insert
    public long insert(Expense expense) {
        ContentValues values = new ContentValues();
        values.put("user_id", expense.getUid());
        values.put("category_id", expense.getCategoryId());
        values.put("amount", expense.getAmount());
        values.put("date", expense.getDate());
        values.put("note", expense.getNote());
        values.put("created_at", expense.getCreatedAt());
        values.put("is_synced", expense.isSynced());
        values.put("updated_at", expense.getUpdatedAt());

        return db.insert("expenses", null, values);
    }

    // Update
    public int update(Expense expense) {
        ContentValues values = new ContentValues();
        values.put("category_id", expense.getCategoryId());
        values.put("amount", expense.getAmount());
        values.put("date", expense.getDate());
        values.put("note", expense.getNote());
        values.put("is_synced", expense.isSynced());
        values.put("updated_at", expense.getUpdatedAt());

        String[] args = {String.valueOf(expense.getExpenseId())};
        return db.update("expenses", values, "expense_id = ?", args);
    }

    // Delete
    public int delete(int expenseId) {
        String[] args = {String.valueOf(expenseId)};
        return db.delete("expenses", "expense_id = ?", args);
    }

    // Get all expenses of user
    public List<Expense> getByUser(String uid) {
        List<Expense> list = new ArrayList<>();

        String[] args = {uid};
        Cursor c = db.rawQuery("SELECT * FROM expenses WHERE user_id = ?", args);

        while (c.moveToNext()) {
            Expense expense = cursorToExpense(c);
            list.add(expense);
        }
        c.close();
        return list;
    }
    public Expense cursorToExpense(Cursor c){
        return new Expense(
                c.getInt(c.getColumnIndexOrThrow("expense_id")),
                c.getString(c.getColumnIndexOrThrow("uid")),
                c.getInt(c.getColumnIndexOrThrow("category_id")),
                c.getDouble(c.getColumnIndexOrThrow("amount")),
                c.getLong(c.getColumnIndexOrThrow("date")),
                c.getString(c.getColumnIndexOrThrow("note")),
                c.getInt(c.getColumnIndexOrThrow("created_at")),
                c.getLong(c.getColumnIndexOrThrow("updated_at")),
                c.getInt(c.getColumnIndexOrThrow("is_synced"))
        );
    }
}