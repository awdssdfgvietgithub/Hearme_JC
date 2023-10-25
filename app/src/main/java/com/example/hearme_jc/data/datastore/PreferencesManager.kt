package com.example.hearme_jc.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.hearme_jc.data.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferenceDatastore(private val context: Context) {
    companion object {
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore("ACCOUNT")
        var email = stringPreferencesKey("EMAIL")
        var password = stringPreferencesKey("PASSWORD")
        var isRemember = booleanPreferencesKey("IS_REMEMBER")
    }

    suspend fun setDetails(account: Account) {
        context.dataStore.edit {
            it[email] = account.email
            it[password] = account.password
            it[isRemember] = account.isRemember
        }
    }

    val getEmail: Flow<String>
        get() = context.dataStore.data.map {
            it[email] ?: ""
        }

    val getPassword: Flow<String>
        get() = context.dataStore.data.map {
            it[password] ?: ""
        }

    val getIsRemember: Flow<Boolean>
        get() = context.dataStore.data.map {
            it[isRemember] ?: false
        }
}