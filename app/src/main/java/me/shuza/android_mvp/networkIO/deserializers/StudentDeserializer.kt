package me.shuza.android_mvp.networkIO.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import me.shuza.android_mvp.models.StudentModel
import me.shuza.android_mvp.utils.getIntFromJson
import me.shuza.android_mvp.utils.hasValidValue
import java.lang.reflect.Type

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  3/23/2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.me
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/
class StudentDeserializer : JsonDeserializer<StudentModel> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): StudentModel {
        val model = StudentModel()
        val jsonObj = json.asJsonObject
        if (hasValidValue(jsonObj, "id")) {
            model.id = getIntFromJson(jsonObj, "id")
        }
        if (hasValidValue(jsonObj, "name")) {
            model.name = jsonObj.get("name").asString
        }
        if (hasValidValue(jsonObj, "age")) {
            model.age = getIntFromJson(jsonObj, "age")
        }
        return model
    }
}