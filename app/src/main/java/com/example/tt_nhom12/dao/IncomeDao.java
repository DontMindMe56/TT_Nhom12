package com.example.tt_nhom12.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tt_nhom12.model.Expense;
import com.example.tt_nhom12.model.Income;

import java.util.ArrayList;
import java.util.List;

public class IncomeDao {
    private SQLiteDatabase db;

    public IncomeDao(SQLiteDatabase db) {
        this.db = db;
    }

    public long insert(Income income) {
        ContentValues values = new ContentValues();
        values.put("user_id", income.getUid());
        values.put("category_id", income.getCategoryId());
        values.put("amount", income.getAmount());
        values.put("date", income.getDate());
        values.put("note", income.getNote());
        values.put("created_at", income.getCreatedAt());
        values.put("is_synced", income.isSynced());
        values.put("updated_at", income.getUpdatedAt());

        return db.insert("incomes", null, values);
    }

    public int update(Income income) {
        ContentValues values = new ContentValues();
        values.put("category_id", income.getCategoryId());
        values.put("amount", income.getAmount());
        values.put("date", income.getDate());
        values.put("note", income.getNote());
        values.put("is_synced", income.isSynced());
        values.put("updated_at", income.getUpdatedAt());

        String[] args = {String.valueOf(income.getIncomeId())};
        return db.update("incomes", values, "income_id = ?", args);
    }

    public int delete(int incomeId) {
        String[] args = {String.valueOf(incomeId)};
        return db.delete("incomes", "income_id = ?", args);
    }

    public List<Income> getByUser(String uid) {
        List<Income> list = new ArrayList<>();

        String[] args = {uid};
        Cursor c = db.rawQuery("SELECT * FROM incomes WHERE user_id = ?", args);

        while (c.moveToNext()) {
            Income income = cursorToIncome(c);
            list.add(income);
        }
        c.close();
        return list;
    }
    public Income cursorToIncome(Cursor c){
        return new Income(
                c.getInt(c.getColumnIndexOrThrow("income_id")),
                c.getString(c.getColumnIndexOrThrow("uid")),
                c.getInt(c.getColumnIndexOrThrow("category_id")),
                c.getDouble(c.getColumnIndexOrThrow("amount")),
                c.getLong(c.getColumnIndexOrThrow("date")),
                c.getString(c.getColumnIndexOrThrow("note")),
                c.getLong(c.getColumnIndexOrThrow("created_at")),
                c.getLong(c.getColumnIndexOrThrow("updated_at")),
                c.getInt(c.getColumnIndexOrThrow("is_synced"))
        );
    }
}
