package com.example.lastgradutionproject

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent :: class)
class Hiltmodele {
    @Provides
    fun provideAuthenication() : FirebaseAuth=Firebase.auth

}