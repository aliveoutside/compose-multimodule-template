package ru.toxyxd.feature.core.di

import dagger.MapKey
import ru.toxyxd.feature.core.FeatureEntry
import kotlin.reflect.KClass

@MapKey
annotation class FeatureEntryKey(
    val value: KClass<out FeatureEntry>
)