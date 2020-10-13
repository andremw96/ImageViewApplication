package com.andreamw96.imageviewapplication.room.user

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity LIMIT 1")
    fun getLoginUser(): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLoginUser(user: UserEntity)

    @Query("DELETE FROM UserEntity")
    fun deleteLoginUser()
}