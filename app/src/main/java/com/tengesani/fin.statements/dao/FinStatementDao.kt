package com.tengesani.repository.fin.statements.dao

import androidx.room.*
import com.tengesani.repository.fin.statements.model.FinStatement
import kotlinx.coroutines.flow.Flow

@Dao
interface FinStatementDao {

    @Query("SELECT * FROM finstatement")
    fun getAllFinStatements(): Flow<List<FinStatement>>


}