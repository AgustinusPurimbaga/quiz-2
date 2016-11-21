package com.example.pustikom.adapterplay.com.example.pustikom.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.StringBuilderPrinter;
import android.widget.TextView;

import com.example.pustikom.adapterplay.R;
import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;

import static android.os.FileObserver.DELETE;
import static com.example.pustikom.adapterplay.com.example.pustikom.db.StudentContract._ID;

/**
 * Created by user on 11/11/2016.
 */

public class StudentDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "college.db";
    public static final String DATABASE_VERSION = "1";
    public StudentDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public StudentDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_STUDENT_TABLE = "CREATE TABLE " + StudentContract.TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StudentContract.COLUMN_STUDENT_NAME + " TEXT NOT NULL, "
                + StudentContract.COLUMN_STUDENT_NIM + " TEXT, "
                + StudentContract.COLUMN_STUDENT_MAIL + " TEXT, "
                + StudentContract.COLUMN_STUDENT_GENDER + " INTEGER, "
                + StudentContract.COLUMN_STUDENT_PHONE + " INTEGER);";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //empty
    }

    public void insertStudent(SQLiteDatabase db, Student student) {
        ContentValues values = new ContentValues();
        values.put(StudentContract.COLUMN_STUDENT_NIM, student.getNoreg());
        values.put(StudentContract.COLUMN_STUDENT_NAME, student.getName());
        values.put(StudentContract.COLUMN_STUDENT_MAIL, student.getMail());
        values.put(StudentContract.COLUMN_STUDENT_GENDER, student.getGender());
        values.put(StudentContract.COLUMN_STUDENT_PHONE, student.getPhone());
        db.insert(StudentContract.TABLE_NAME, null, values);
    }

    public void updateStudent(SQLiteDatabase db, Student student) {
        ContentValues values = new ContentValues();
        values.put(StudentContract.COLUMN_STUDENT_NIM, student.getNoreg());
        values.put(StudentContract.COLUMN_STUDENT_NAME, student.getName());
        values.put(StudentContract.COLUMN_STUDENT_MAIL, student.getMail());
        values.put(StudentContract.COLUMN_STUDENT_GENDER, student.getGender());
        values.put(StudentContract.COLUMN_STUDENT_PHONE, student.getPhone());
        String conditionArgs = (student.getId()+"");
        db.update(StudentContract.TABLE_NAME, values, _ID + "=" + conditionArgs, null);
    }

    public void deleteStudent(SQLiteDatabase db, Student student) {
        String condition = _ID + " = ?,";
        String conditionArgs = (student.getId()+"");
        db.delete(condition, conditionArgs, null);
    }

    public void truncateStudent(SQLiteDatabase db){
        String SQL_DELETE_STUDENT_TABLE = "DELETE FROM " + StudentContract.TABLE_NAME + ";";
        String SQL_VACUUM_STUDENT_TABLE = "VACUUM;";
        db.execSQL(SQL_DELETE_STUDENT_TABLE);
        db.execSQL(SQL_VACUUM_STUDENT_TABLE);
    }

    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db;
        db = StudentDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                StudentContract._ID,
                StudentContract.COLUMN_STUDENT_GENDER,
                StudentContract.COLUMN_STUDENT_NAME,
                StudentContract.COLUMN_STUDENT_MAIL,
                StudentContract.COLUMN_STUDENT_NIM,
                StudentContract.COLUMN_STUDENT_PHONE};

        // Perform a query on the pets table
        Cursor cursor = db.query(
                StudentContract.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order
    }


}