package com.mbsoft.intentexample

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Context
import com.mbsoft.intentexample.db.model.User

class ContentResolverHelper(private var mContext: Context) {

    private val KEY_EMAIL: String = "KEY_EMAIL"
    private val KEY_PASSWORD: String = "KEY_PASSWORD"
    private val KEY_ID: String = "KEY_UID"
    private var contentResolver: ContentResolver = mContext.contentResolver
    val allUser: ArrayList<User>
        get() {
            val userList: ArrayList<User> = ArrayList<User>()
            val projection = arrayOf<String>(KEY_ID, KEY_EMAIL, KEY_PASSWORD) //table column selection
            val cursor = contentResolver.query(CONTENT_URI, null, null, null, null)
            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val user = User(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                    )
                    userList.add(user)
                }
            }
            return userList
        }

    fun clearAllUser() {
        val contentResolver = mContext.contentResolver
        contentResolver.delete(CONTENT_URI, null, null)
    }

    fun insertUser(user: User) {
        val contentValues = ContentValues()
        contentValues.put(KEY_EMAIL, user.email)
        contentValues.put(KEY_PASSWORD, user.password)
        val uri = contentResolver.insert(CONTENT_URI, contentValues)
    }

/* fun getCompanyTMRecord(id: Int): User{
   val user= User()
   val contentResolver = mContext.contentResolver
   val uri: Uri = CONTENT_URI
   val projection = arrayOf<String>(KEY_ID, KEY_NAME, KEY_EMAIL)
   val selection: String = KEY_ID.toString() + "=?"
   val selectionArgs = arrayOf(id.toString())
   val sortOrder: String? = null
   val cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder)
   if (cursor != null && cursor.count > 0) {
       while (cursor.moveToNext()) {
           user.id = cursor.getLong(0)
           user.name = cursor.getString(1)
           user.email = cursor.getString(2)
       }
   }
   return user
}*/

/*fun insertCompanyTMRecord(companyTMRecord: CompanyTMRecord) {
   val contentValues = ContentValues()
   contentValues.put(KEY_NAME, companyTMRecord.name)
   contentValues.put(KEY_EMAIL, companyTMRecord.email)
   val uri = contentResolver.insert(CONTENT_URI, contentValues)
}

fun deleteCompanyTMRecord(index: Long?) {
   val contentResolver = mContext.contentResolver
   val where: String = KEY_ID + "=?"
   val selectionArgs = arrayOf(index.toString())
   contentResolver.delete(CONTENT_URI, where, selectionArgs)
}

fun updateCompanyTMRecord(companyTMRecord: CompanyTMRecord, id: Long?) {
   val contentValues = ContentValues()
   contentValues.put(KEY_ID, companyTMRecord.id)
   contentValues.put(KEY_NAME, companyTMRecord.name)
   contentValues.put(KEY_EMAIL, companyTMRecord.email)

   val where: String = KEY_ID.toString() + "=?"
   val selectionArgs = arrayOf(id.toString())
   val noOfRec = contentResolver.update(CONTENT_URI, contentValues, where, selectionArgs)
   Toast.makeText(mContext, "$noOfRec Record Delete successfully", Toast.LENGTH_SHORT).show()
}*/

}