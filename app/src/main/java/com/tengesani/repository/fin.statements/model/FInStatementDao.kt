package com.tengesani.repository.fin.statements.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FInStatementDao {

    @Query("SELECT * FROM finstatement")
    fun getAllFinStatements(): Flow<List<FinStatement>>


}