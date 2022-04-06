package com.neobis.deliveryemployee.koin

import android.content.Context
import com.example.evergreenclient.data.localDatabase.LocalDatabase
import com.neobis.deliveryclient.data.entity.mapper.mappers.JWTTokenMapper
import com.neobis.deliveryclient.data.repository.UserRepositoryImpl
import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.data.rest.client.RestClientImpl
import com.neobis.deliveryclient.domain.interactor.repository.LoginRepository
import com.neobis.deliveryclient.domain.interactor.usecase.login.LoginUseCase
import com.neobis.deliveryemployee.app.fragments.florist.PlantViewModel
import com.neobis.deliveryemployee.app.fragments.login.LoginViewModel
import com.neobis.deliveryemployee.data.repository.PlantsRepositoryImpl
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository
import com.neobis.deliveryemployee.domain.interactor.usecase.florist.CreatePlantUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val retrofitModule = module {
    single { provideRestClient() }
}

val preferencesModule = module {
    single { provideSharedPreferences(androidContext()) }
}

val repositoryModule = module {

    single { tokenDataMapper() }

    single {
        provideUserRepository(
            restClient = get(),
            mapper = tokenDataMapper()
        )
    }
    single {
        providePlantRepository(
            restClient = get(),
        )
    }


}

val viewModels = module {

    factory { provideLoginUseCase(repository = get()) }
    factory { provideCreatePlantUseCase(repository = get()) }
    single { provideSharedPreferences(androidContext()) }

    viewModel { LoginViewModel(loginUseCase = get(), get()) }
    viewModel { PlantViewModel(createPlantUseCase = get()) }
}

fun provideLoginUseCase(repository: LoginRepository) = LoginUseCase(repository)
fun provideCreatePlantUseCase(repository: PlantsRepository) = CreatePlantUseCase(repository)
fun provideSharedPreferences(context: Context) = LocalDatabase(context)

fun provideUserRepository(
    restClient: RestClient,
    mapper: JWTTokenMapper
): LoginRepository {
    return UserRepositoryImpl(restClient, mapper)
}

fun providePlantRepository(
    restClient: RestClient,
): PlantsRepository {
    return PlantsRepositoryImpl(restClient)
}

fun provideRestClient(): RestClient {
    return RestClientImpl()
}


fun tokenDataMapper() = JWTTokenMapper()
