package com.malec.ino.di

import com.malec.ino.di.activity.ActivityModule
import com.malec.ino.di.module.NavigationModule
import com.malec.ino.di.viewModel.ViewModelModule
import com.malec.ino.repo.RoomRepo
import com.malec.ino.service.localDb.RoomsDao
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module(includes = [ActivityModule::class, ViewModelModule::class, NavigationModule::class])
class AppModule {
	@Provides
	@Singleton
	fun boardsRepo(dao: RoomsDao): RoomRepo = RoomRepo(dao)
}