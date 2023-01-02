package ru.toxyxd.feature.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import ru.toxyxd.feature.core.FeatureEntry
import ru.toxyxd.feature.core.di.FeatureEntryKey
import ru.toxyxd.feature.home.HomeFeature
import ru.toxyxd.feature.home.HomeFeatureImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface HomeFeatureModule {
    @Singleton
    @Binds
    @IntoMap
    @FeatureEntryKey(value = HomeFeature::class)
    fun homePageEntry(entry: HomeFeatureImpl): FeatureEntry
}