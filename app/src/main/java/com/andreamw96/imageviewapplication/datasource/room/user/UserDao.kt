package com.andreamw96.imageviewapplication.datasource.room.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity LIMIT 1")
    fun getLoginUser(): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLoginUser(user: UserEntity)

    @Query("DELETE FROM UserEntity")
    fun deleteLoginUser()
}