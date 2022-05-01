package com.neobis.deliveryemployee.koin

import android.content.Context
import com.example.evergreenclient.data.localDatabase.LocalDatabase
import com.neobis.deliveryclient.data.entity.mapper.mappers.JWTTokenMapper
import com.neobis.deliveryclient.data.repository.UserRepositoryImpl
import com.neobis.deliveryclient.data.rest.client.RestClient
import com.neobis.deliveryclient.data.rest.client.RestClientImpl
import com.neobis.deliveryclient.domain.interactor.repository.LoginRepository
import com.neobis.deliveryclient.domain.interactor.usecase.login.LoginUseCase
import com.neobis.deliveryemployee.app.fragments.courier.home.OrdersViewModel
import com.neobis.deliveryemployee.app.fragments.florist.PlantViewModel
import com.neobis.deliveryemployee.app.fragments.login.LoginViewModel
import com.neobis.deliveryemployee.data.entity.mapper.mappers.PlantMapper
import com.neobis.deliveryemployee.data.repository.OrdersRepositoryImpl
import com.neobis.deliveryemployee.data.repository.PlantsRepositoryImpl
import com.neobis.deliveryemployee.domain.interactor.repository.OrdersRepository
import com.neobis.deliveryemployee.domain.interactor.repository.PlantsRepository
import com.neobis.deliveryemployee.domain.interactor.usecase.courier.GetNewOrders
import com.neobis.deliveryemployee.domain.interactor.usecase.florist.CreatePlantUseCase
import com.neobis.deliveryemployee.domain.interactor.usecase.florist.GetListOfPlants
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val retrofitModule = module {
    single { provideRestClient() }
}

val preferencesModule = module {
    single { provideSharedPreferences(androidContext()) }
}

val repositoryModule = module {

    single { tokenDataMapper() }
    single { plantMapper() }

    single {
        provideUserRepository(
            restClient = get(),
            mapper = tokenDataMapper()
        )
    }
    single {
        providePlantRepository(
            restClient = get(),
            mapper = get()
        )
    }
    single {
        provideOrdersRepository(
            restClient = get(),
            mapper = get()
        )
    }

}

val viewModels = module {

    factory { provideLoginUseCase(repository = get()) }
    factory { provideCreatePlantUseCase(repository = get()) }
    factory { provideGetPlantsUseCase(repository = get()) }
    factory { provideGetNewOrdersUseCase(repository = get()) }
    single { provideSharedPreferences(androidContext()) }


    viewModel { LoginViewModel(loginUseCase = get(), get()) }
    viewModel { OrdersViewModel(get()) }
    viewModel { PlantViewModel(createPlantUseCase = get(), getListOfPlants = get()) }
}


fun provideLoginUseCase(repository: LoginRepository) = LoginUseCase(repository)
fun provideCreatePlantUseCase(repository: PlantsRepository) = CreatePlantUseCase(repository)
fun provideGetPlantsUseCase(repository: PlantsRepository) = GetListOfPlants(repository)
fun provideGetNewOrdersUseCase(repository: OrdersRepository) = GetNewOrders(repository)
fun provideSharedPreferences(context: Context) = LocalDatabase(context)

fun provideUserRepository(
    restClient: RestClient,
    mapper: JWTTokenMapper
): LoginRepository {
    return UserRepositoryImpl(restClient, mapper)
}

fun providePlantRepository(
    restClient: RestClient,
    mapper: PlantMapper
): PlantsRepository {
    return PlantsRepositoryImpl(restClient, mapper)
}

fun provideOrdersRepository(
    restClient: RestClient,
    mapper: PlantMapper
): OrdersRepository {
    return OrdersRepositoryImpl(restClient, mapper)
}

fun provideRestClient(): RestClient {
    return RestClientImpl()
}


fun tokenDataMapper() = JWTTokenMapper()
fun plantMapper() = PlantMapper()
