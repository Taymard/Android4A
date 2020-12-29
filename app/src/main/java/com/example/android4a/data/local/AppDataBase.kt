package com.example.android4a.data.local

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.android4a.data.local.models.UserLocal
import java.time.chrono.HijrahChronology.INSTANCE

@Database(entities = arrayOf(UserLocal::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao



    companion object{
        private var INSTANCE: AppDatabase?= null

        val migration_1_2: Migration = object: Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE UserLocal ADD COLUMN password TEXT NOT NULL DEFAULT ''")
            }
        }


        fun getAppDatabase(context:Context): AppDatabase? {
            if (INSTANCE == null) {

                INSTANCE = Room.databaseBuilder<AppDatabase>(
                    context.applicationContext, AppDatabase::class.java,"DataBaseDao"
                )
                    .addMigrations(migration_1_2)
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}


