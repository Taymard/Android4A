package com.example.android4a.injection

import com.example.android4a.MainViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule : Module = module {
    factory { MainViewModel() }
}