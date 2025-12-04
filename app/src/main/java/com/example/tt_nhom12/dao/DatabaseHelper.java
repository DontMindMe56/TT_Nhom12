package com.example.tt_nhom12.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "finance.db";
    public static final int DATABASE_VERSION = 1;

    // ------------------- USERS -------------------
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_UID = "uid";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_DISPLAY_NAME = "display_name";
    public static final String COLUMN_USER_PHOTO_URL = "photo_url";
    public static final String COLUMN_USER_PROVIDER = "provider";
    public static final String COLUMN_USER_CREATED_AT = "created_at";
    public static final String COLUMN_USER_LAST_LOGIN = "last_login";
    public static final String COLUMN_USER_IS_SYNCED = "is_synced";
    public static final String COLUMN_USER_UPDATED_AT = "updated_at";

    // ------------------- CATEGORIES -------------------
    public static final String TABLE_CATEGORIES = "categories";
    public static final String COLUMN_CATEGORY_ID = "category_id";
    public static final String COLUMN_CATEGORY_USER_ID = "user_id";
    public static final String COLUMN_CATEGORY_NAME = "name";
    public static final String COLUMN_CATEGORY_TYPE = "type";
    public static final String COLUMN_CATEGORY_CREATED_AT = "created_at";
    public static final String COLUMN_CATEGORY_IS_SYNCED = "is_synced";
    public static final String COLUMN_CATEGORY_UPDATED_AT = "updated_at";

    // ------------------- EXPENSES -------------------
    public static final String TABLE_EXPENSES = "expenses";
    public static final String COLUMN_EXPENSE_ID = "expense_id";
    public static final String COLUMN_EXPENSE_USER_ID = "user_id";
    public static final String COLUMN_EXPENSE_CATEGORY_ID = "category_id";
    public static final String COLUMN_EXPENSE_AMOUNT = "amount";
    public static final String COLUMN_EXPENSE_DATE = "date";
    public static final String COLUMN_EXPENSE_NOTE = "note";
    public static final String COLUMN_EXPENSE_CREATED_AT = "created_at";
    public static final String COLUMN_EXPENSE_IS_SYNCED = "is_synced";
    public static final String COLUMN_EXPENSE_UPDATED_AT = "updated_at";

    // ------------------- INCOMES -------------------
    public static final String TABLE_INCOMES = "incomes";
    public static final String COLUMN_INCOME_ID = "income_id";
    public static final String COLUMN_INCOME_USER_ID = "user_id";
    public static final String COLUMN_INCOME_CATEGORY_ID = "category_id";
    public static final String COLUMN_INCOME_AMOUNT = "amount";
    public static final String COLUMN_INCOME_DATE = "date";
    public static final String COLUMN_INCOME_NOTE = "note";
    public static final String COLUMN_INCOME_CREATED_AT = "created_at";
    public static final String COLUMN_INCOME_IS_SYNCED = "is_synced";
    public static final String COLUMN_INCOME_UPDATED_AT = "updated_at";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {

        // ------------------- CREATE USERS -------------------
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + " ("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USER_UID + " TEXT UNIQUE, "
                + COLUMN_USER_EMAIL + " TEXT UNIQUE, "
                + COLUMN_USER_DISPLAY_NAME + " TEXT, "
                + COLUMN_USER_PHOTO_URL + " TEXT, "
                + COLUMN_USER_PROVIDER + " TEXT, "
                + COLUMN_USER_CREATED_AT + " INTEGER, "
                + COLUMN_USER_LAST_LOGIN + " INTEGER, "
                + COLUMN_USER_IS_SYNCED + " INTEGER DEFAULT 0, "
                + COLUMN_USER_UPDATED_AT + " INTEGER"
                + ");";

        // ------------------- CREATE CATEGORIES -------------------
        String createCategoriesTable = "CREATE TABLE " + TABLE_CATEGORIES + " ("
                + COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CATEGORY_USER_ID + " INTEGER, "
                + COLUMN_CATEGORY_NAME + " TEXT, "
                + COLUMN_CATEGORY_TYPE + " TEXT, "
                + COLUMN_CATEGORY_CREATED_AT + " INTEGER, "
                + COLUMN_CATEGORY_IS_SYNCED + " INTEGER DEFAULT 0, "
                + COLUMN_CATEGORY_UPDATED_AT + " INTEGER, "
                + "FOREIGN KEY(" + COLUMN_CATEGORY_USER_ID + ") REFERENCES "
                + TABLE_USERS + "(" + COLUMN_USER_ID + ") ON DELETE CASCADE"
                + ");";

        // ------------------- CREATE EXPENSES -------------------
        String createExpensesTable = "CREATE TABLE " + TABLE_EXPENSES + " ("
                + COLUMN_EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EXPENSE_USER_ID + " INTEGER, "
                + COLUMN_EXPENSE_CATEGORY_ID + " INTEGER, "
                + COLUMN_EXPENSE_AMOUNT + " REAL, "
                + COLUMN_EXPENSE_DATE + " INTEGER, "
                + COLUMN_EXPENSE_NOTE + " TEXT, "
                + COLUMN_EXPENSE_CREATED_AT + " INTEGER, "
                + COLUMN_EXPENSE_IS_SYNCED + " INTEGER DEFAULT 0, "
                + COLUMN_EXPENSE_UPDATED_AT + " INTEGER, "
                + "FOREIGN KEY(" + COLUMN_EXPENSE_USER_ID + ") REFERENCES "
                + TABLE_USERS + "(" + COLUMN_USER_ID + ") ON DELETE CASCADE, "
                + "FOREIGN KEY(" + COLUMN_EXPENSE_CATEGORY_ID + ") REFERENCES "
                + TABLE_CATEGORIES + "(" + COLUMN_CATEGORY_ID + ") /*ON DELETE SET NULL*/"
                + ");";

        // ------------------- CREATE INCOMES -------------------
        String createIncomesTable = "CREATE TABLE " + TABLE_INCOMES + " ("
                + COLUMN_INCOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_INCOME_USER_ID + " INTEGER, "
                + COLUMN_INCOME_CATEGORY_ID + " INTEGER, "
                + COLUMN_INCOME_AMOUNT + " REAL, "
                + COLUMN_INCOME_DATE + " INTEGER, "
                + COLUMN_INCOME_NOTE + " TEXT, "
                + COLUMN_INCOME_CREATED_AT + " INTEGER, "
                + COLUMN_INCOME_IS_SYNCED + " INTEGER DEFAULT 0, "
                + COLUMN_INCOME_UPDATED_AT + " INTEGER, "
                + "FOREIGN KEY(" + COLUMN_INCOME_USER_ID + ") REFERENCES "
                + TABLE_USERS + "(" + COLUMN_USER_ID + ") ON DELETE CASCADE, "
                + "FOREIGN KEY(" + COLUMN_INCOME_CATEGORY_ID + ") REFERENCES "
                + TABLE_CATEGORIES + "(" + COLUMN_CATEGORY_ID + ") /*ON DELETE SET NULL*/"
                + ");";

        db.execSQL(createUsersTable);
        db.execSQL(createCategoriesTable);
        db.execSQL(createExpensesTable);
        db.execSQL(createIncomesTable);
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INCOMES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
}
