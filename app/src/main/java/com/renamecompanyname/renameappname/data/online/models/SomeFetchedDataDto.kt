package com.renamecompanyname.renameappname.data.online.models

import com.renamecompanyname.renameappname.domain.model.SomeFetchedData
import kotlinx.serialization.Serializable

@Serializable
data class SomeFetchedDataDto(
    val name_en: String,
    val flag_url_32: String,
)

fun SomeFetchedDataDto.toDomainSomeFetchedData(): SomeFetchedData {
    return SomeFetchedData(name = name_en, flagUrl32 = flag_url_32)
}
