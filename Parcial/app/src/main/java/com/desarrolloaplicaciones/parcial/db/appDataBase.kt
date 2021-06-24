package com.desarrolloaplicaciones.parcial.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.desarrolloaplicaciones.parcial.clases.Subject

import com.desarrolloaplicaciones.parcial.clases.User

@Database(entities = [User::class, Subject::class], version = 7, exportSchema = false)
public  abstract class appDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
   abstract fun subjectDao(): SubjectDao



    companion object {
        var INSTANCE: appDatabase? = null

        fun getAppDataBase(context: Context): appDatabase? {
            if (INSTANCE == null) {
                synchronized(appDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        appDatabase::class.java,
                        "db"
                    ).allowMainThreadQueries().fallbackToDestructiveMigration().build() // No es lo mas recomendable que se ejecute en el mainthread
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}
