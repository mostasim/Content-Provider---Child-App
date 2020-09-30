package com.mbsoft.intentexample

import android.net.Uri
import com.mbsoft.intentexample.db.model.User

const val TABLE_NAME = "simpleDB"
const val PROVIDER_NAME = "com.mbsoft.daggerhilt"
const val URL = "content://$PROVIDER_NAME/$TABLE_NAME"
val CONTENT_URI:Uri = Uri.parse(URL)