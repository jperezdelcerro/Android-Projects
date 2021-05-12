package com.desarrolloaplicaciones.parcial.db

import androidx.room.*
import com.desarrolloaplicaciones.parcial.clases.Subject

@Dao
interface SubjectsDao {

    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllSubjects(): MutableList<Subject?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSubject(user: Subject?)

    @Update
    fun updateSubject(user: Subject?)

    @Delete
    fun delete(user: Subject?)

    @Query("SELECT * FROM users WHERE id = :id")
    fun loadSubjectById(id: Int): Subject?

}

