package com.skeleton.rickandmorty.data.mapper

import com.skeleton.rickandmorty.data.local.entity.CharacterEntity
import com.skeleton.rickandmorty.data.remote.response.CharacterDto
import com.skeleton.rickandmorty.domain.model.Karakter



fun CharacterEntity.toDomain(): Karakter = Karakter(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = originName,
    location = locationName,
    image = image,
    episode = episode,
    url = url,
    created = created
)

fun CharacterDto.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = id ?: 0,
        name = name.orEmpty(),
        status = status.orEmpty(),
        species = species.orEmpty(),
        type = type.orEmpty(),
        gender = gender.orEmpty(),
        originName = origin.name.orEmpty(),
        locationName = location.name.orEmpty(),
        image = image.orEmpty(),
        episode = episode.orEmpty(),
        url = url.orEmpty(),
        created = created.orEmpty()
    )
}

