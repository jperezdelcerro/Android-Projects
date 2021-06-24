package com.desarrolloaplicaciones.parcial.db

import androidx.room.*
import com.desarrolloaplicaciones.parcial.clases.Subject

@Dao
public interface SubjectDao {

    @Query("SELECT * FROM subjects ORDER BY id")
    fun loadAllPersons(): MutableList<Subject?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(user: Subject?)

    @Update
    fun updatePerson(user: Subject?)

    @Delete
    fun delete(user: Subject?)

    @Query("SELECT * FROM subjects WHERE id = :id")
    fun loadPersonById(id: Int): Subject?

}