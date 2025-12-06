package com.example.tt_nhom12.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tt_nhom12.model.Budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetDao {
    private SQLiteDatabase db;

    public BudgetDao(SQLiteDatabase db) {
        this.db = db;
    }

    public long insert(Budget budget) {
        ContentValues values = new ContentValues();

        values.put("user_id", budget.getUid());
        values.put("category_id", budget.getCategoryId());
        values.put("name", budget.getName());
        values.put("warning_amount", budget.getWarningAmount());
        values.put("max_amount", budget.getMaxAmount());
        values.put("total_spent", budget.getTotalSpent());
        values.put("period_type", budget.getPeriodType());
        values.put("cycle_start", budget.getCycleStart());
        values.put("cycle_end", budget.getCycleEnd());
        values.put("reset_on_new_cycle", budget.isResetOnNewCycle());
        values.put("created_at", budget.getCreatedAt());
        values.put("updated_at", budget.getUpdatedAt());
        values.put("is_synced", budget.isSynced());

        return db.insert("budgets", null, values);
    }

    public int update(Budget budget) {
        ContentValues values = new ContentValues();

        values.put("name", budget.getName());
        values.put("warning_amount", budget.getWarningAmount());
        values.put("max_amount", budget.getMaxAmount());
        values.put("total_spent", budget.getTotalSpent());
        values.put("period_type", budget.getPeriodType());
        values.put("cycle_start", budget.getCycleStart());
        values.put("cycle_end", budget.getCycleEnd());
        values.put("reset_on_new_cycle", budget.isResetOnNewCycle());
        values.put("updated_at", System.currentTimeMillis());
        values.put("is_synced", 0);

        String[] args = {String.valueOf(budget.getBudgetId())};
        return db.update("budgets", values, "budget_id = ?", args);
    }

    public int delete(int budgetId) {
        String[] args = {String.valueOf(budgetId)};
        return db.delete("budgets", "budget_id = ?", args);
    }

    public Budget getById(int id) {
        String[] args = {String.valueOf(id)};
        Cursor c = db.rawQuery("SELECT * FROM budgets WHERE budget_id = ?", args);

        if (!c.moveToFirst()) {
            c.close();
            return null;
        }

        Budget b = cursorToBudget(c);
        c.close();
        return b;
    }

    //thêm thuộc tính firestore_id
    public List<Budget> getByUser(String uid) {
        List<Budget> list = new ArrayList<>();

        String[] args = {uid};
        Cursor c = db.rawQuery("SELECT * FROM budgets WHERE user_id = ? ORDER BY name ASC", args);

        while (c.moveToNext()) {
            list.add(cursorToBudget(c));
        }
        c.close();
        return list;
    }

    public void addToBudget(int budgetId, double amount) {
        String[] args = {String.valueOf(budgetId)};
        Cursor c = db.rawQuery("SELECT total_spent FROM budgets WHERE budget_id = ?", args);

        if (!c.moveToFirst()) {
            c.close();
            return;
        }

        double current = c.getDouble(0);
        c.close();

        ContentValues values = new ContentValues();
        values.put("total_spent", current + amount);
        values.put("updated_at", System.currentTimeMillis());
        values.put("is_synced", 0);

        db.update("budgets", values, "budget_id = ?", args);
    }

    public void subtractFromBudget(int budgetId, double amount) {
        String[] args = {String.valueOf(budgetId)};
        Cursor c = db.rawQuery("SELECT total_spent FROM budgets WHERE budget_id = ?", args);

        if (!c.moveToFirst()) {
            c.close();
            return;
        }

        double current = c.getDouble(0);
        c.close();

        ContentValues values = new ContentValues();
        values.put("total_spent", Math.max(0, current - amount));
        values.put("updated_at", System.currentTimeMillis());
        values.put("is_synced", 0);

        db.update("budgets", values, "budget_id = ?", args);
    }

    public void resetBudgetCycle(int budgetId, long newStart, long newEnd) {
        ContentValues values = new ContentValues();
        values.put("total_spent", 0);
        values.put("cycle_start", newStart);
        values.put("cycle_end", newEnd);
        values.put("updated_at", System.currentTimeMillis());
        values.put("is_synced", 0);

        String[] args = {String.valueOf(budgetId)};
        db.update("budgets", values, "budget_id = ?", args);
    }

    private Budget cursorToBudget(Cursor c) {
        return new Budget(
                c.getInt(c.getColumnIndexOrThrow("budget_id")),
                c.getString(c.getColumnIndexOrThrow("uid")),
                c.getInt(c.getColumnIndexOrThrow("category_id")),
                c.getString(c.getColumnIndexOrThrow("name")),
                c.getDouble(c.getColumnIndexOrThrow("warning_amount")),
                c.getDouble(c.getColumnIndexOrThrow("max_amount")),
                c.getDouble(c.getColumnIndexOrThrow("total_spent")),
                c.getString(c.getColumnIndexOrThrow("period_type")),
                c.getLong(c.getColumnIndexOrThrow("cycle_start")),
                c.getLong(c.getColumnIndexOrThrow("cycle_end")),
                c.getInt(c.getColumnIndexOrThrow("reset_on_new_cycle")),
                c.getLong(c.getColumnIndexOrThrow("created_at")),
                c.getLong(c.getColumnIndexOrThrow("updated_at")),
                c.getInt(c.getColumnIndexOrThrow("is_synced"))
        );
    }
}
