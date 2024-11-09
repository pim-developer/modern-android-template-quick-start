package com.renamecompanyname.renameappname.data.local.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class User : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()

    var name: String = ""
}

fun User.toDomainUser(): com.renamecompanyname.renameappname.domain.model.User {
    return com.renamecompanyname.renameappname.domain.model.User(
        id = this._id.toHexString(),
        name = this.name,
    )
}

fun com.renamecompanyname.renameappname.domain.model.User.toDataUser(): User {
    return User().apply {
        _id = if (this@toDataUser.id.isEmpty()) ObjectId() else ObjectId.invoke(this@toDataUser.id)
        name = this@toDataUser.name
    }
}
