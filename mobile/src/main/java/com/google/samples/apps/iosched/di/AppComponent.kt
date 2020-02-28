/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.iosched.di

import com.google.samples.apps.iosched.MainApplication
import com.google.samples.apps.iosched.shared.di.BroadcastReceiverBindingModule
import com.google.samples.apps.iosched.shared.di.FeatureFlagsModule
import com.google.samples.apps.iosched.shared.di.ServiceBindingModule
import com.google.samples.apps.iosched.shared.di.SharedModule
import com.google.samples.apps.iosched.shared.di.ViewModelModule
import com.google.samples.apps.iosched.ui.appupdate.AppUpdateModule
import com.google.samples.apps.iosched.ui.signin.SignInViewModelDelegateModule
import com.google.samples.apps.iosched.ui.theme.ThemedActivityDelegateModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Main component of the app, created and persisted in the Application class.
 *
 * Whenever a new module is created, it should be added to the list of modules.
 * [AndroidSupportInjectionModule] is the module from Dagger.Android that helps with the
 * generation and location of subcomponents.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        AppUpdateModule::class,
        CoroutinesModule::class,
        ActivityBindingModule::class,
        BroadcastReceiverBindingModule::class,
        ViewModelModule::class,
        ServiceBindingModule::class,
        SharedModule::class,
        FeatureFlagsModule::class,
        SignInModule::class,
        SignInViewModelDelegateModule::class,
        ThemedActivityDelegateModule::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MainApplication): AppComponent
    }
}
