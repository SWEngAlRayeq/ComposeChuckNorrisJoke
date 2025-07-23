package app.chuck_norris_joke.di

import app.chuck_norris_joke.data.api.ChuckNorrisApi
import app.chuck_norris_joke.data.repo_impl.ChuckNorrisRepositoryImpl
import app.chuck_norris_joke.domain.repository.ChuckNorrisRepository
import app.chuck_norris_joke.domain.usecase.GetChuckNorrisJokeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideChuckApi(client: OkHttpClient): ChuckNorrisApi =
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ChuckNorrisApi::class.java)

    @Provides
    @Singleton
    fun provideChuckRepository(api: ChuckNorrisApi): ChuckNorrisRepository =
        ChuckNorrisRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideChuckUseCase(repo: ChuckNorrisRepository): GetChuckNorrisJokeUseCase =
        GetChuckNorrisJokeUseCase(repo)

}