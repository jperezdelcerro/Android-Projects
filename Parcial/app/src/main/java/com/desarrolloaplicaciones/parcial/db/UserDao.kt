package com.desarrolloaplicaciones.parcial.db

import androidx.room.*
import com.desarrolloaplicaciones.parcial.clases.User

@Dao
public interface UserDao {

    @Query("SELECT * FROM users ORDER BY id")
    fun loadAllPersons(): MutableList<User?>?

  /*  @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(user: User?)

    @Update
    fun updatePerson(user: User?)

    @Delete
    fun delete(user: User?)

    @Query("SELECT * FROM users WHERE id = :id")
    fun loadPersonById(id: Int): User?*/

}