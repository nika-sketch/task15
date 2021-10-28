package ge.nlatsabidze.datastoreexample

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.map

class WorkManager(context: Context) {

    val Context._dataStore: DataStore<Preferences> by preferencesDataStore("APP_PREFERENCES")
    val dataStore: DataStore<Preferences> = context._dataStore

    val FIRST_NAME_KEY = stringPreferencesKey("first_name")
    val LAST_NAME_KEY = stringPreferencesKey("last_name")
    val AGE = stringPreferencesKey("age")
    val EMAIL = stringPreferencesKey("email")
    val GENDER = stringPreferencesKey("gender")
    val ADDRESS = stringPreferencesKey("address")
    val PHONENUMBER = stringPreferencesKey("number")


    suspend fun savetoDataStore(
        firstName: String,
        lastName: String,
        age: String,
        email: String,
        gender: String,
        address: String,
        phoneNumber: String
    ) {
        dataStore.edit { preferences ->
            preferences[FIRST_NAME_KEY] = firstName
            preferences[LAST_NAME_KEY] = lastName
            preferences[AGE] = age
            preferences[EMAIL] = email
            preferences[GENDER] = gender
            preferences[ADDRESS] = address
            preferences[PHONENUMBER] = phoneNumber
        }
    }

    val firstName: LiveData<String> = dataStore.data.map { it[FIRST_NAME_KEY] ?: "" }.asLiveData()
    val lastName: LiveData<String> = dataStore.data.map { it[LAST_NAME_KEY] ?: "" }.asLiveData()
    val age: LiveData<String> = dataStore.data.map { it[AGE] ?: "" }.asLiveData()
    val email: LiveData<String> = dataStore.data.map { it[EMAIL] ?: "" }.asLiveData()
    val gender: LiveData<String> = dataStore.data.map { it[GENDER] ?: "" }.asLiveData()
    val address: LiveData<String> = dataStore.data.map { it[ADDRESS] ?: "" }.asLiveData()
    val phoneNumber: LiveData<String> = dataStore.data.map { it[PHONENUMBER] ?: "" }.asLiveData()
}