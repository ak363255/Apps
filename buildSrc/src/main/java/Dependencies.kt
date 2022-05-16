import org.gradle.api.artifacts.dsl.DependencyHandler

private val IMPLEMENTATION = "implementation"
private val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
private val TEST_IMPLEMENTATION = "testImplementation"

object Deps {
        // Integration with activities
         private val activity_compose = "androidx.activity:activity-compose:1.4.0"
        // Compose Material Design
        private val compose_material =  "androidx.compose.material:material:1.1.1"
        // Animations
        private val compose_animation = "androidx.compose.animation:animation:1.1.1"
        // Tooling support (Previews, etc.)
        private val compose_tooling = "androidx.compose.ui:ui-tooling:1.1.1"
        // Integration with ViewModels
        private val compose_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
        // UI Tests
        private val compose_junit_text= "androidx.compose.ui:ui-test-junit4:1.1.1"

        fun addComposeDependencies(handler:DependencyHandler){
                handler.add(IMPLEMENTATION, activity_compose)
                handler.add(IMPLEMENTATION, compose_material)
                handler.add(IMPLEMENTATION, compose_animation)
                handler.add(IMPLEMENTATION, compose_tooling)
                handler.add(IMPLEMENTATION, compose_viewmodel)
                handler.add(ANDROID_TEST_IMPLEMENTATION, compose_viewmodel)
        }

        private val  core_ktx = "androidx.core:core-ktx:1.7.0"
        private val  androidx_appcompat = "androidx.appcompat:appcompat:1.4.1"
        private val  androidx_material = "com.google.android.material:material:1.6.0"
        private val  androidx_constraint = "androidx.constraintlayout:constraintlayout:2.1.3"
        private val  junit_lib = "junit:junit:4.+"
        private val  androidx_junit = "androidx.test.ext:junit:1.1.3"
        private val  androidx_expresso = "androidx.test.espresso:espresso-core:3.4.0"


        fun addAndroidxCoreDependencies(handler: DependencyHandler){
                handler.add(IMPLEMENTATION, core_ktx)
                handler.add(IMPLEMENTATION, androidx_appcompat)
                handler.add(IMPLEMENTATION, androidx_constraint)
                handler.add(IMPLEMENTATION, androidx_material)
                handler.add(TEST_IMPLEMENTATION, junit_lib)
                handler.add(ANDROID_TEST_IMPLEMENTATION, androidx_junit)
                handler.add(TEST_IMPLEMENTATION, androidx_expresso)
        }

        private val gson_dependencies = "com.google.code.gson:gson:2.9.0"
        fun addGsonDependencies(handler: DependencyHandler){
                handler.add(IMPLEMENTATION, gson_dependencies)
        }

        private val retrofit_dependency = "com.squareup.retrofit2:retrofit:2.9.0"
        private val retrofit_gson = "com.squareup.retrofit2:converter-gson:2.9.0"

        fun addRetrofitDependencies(handler: DependencyHandler){
                handler.add(IMPLEMENTATION, retrofit_dependency)
                handler.add(IMPLEMENTATION, retrofit_gson)
        }

        private val kotlinCoroutineDep = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"

        fun addKotlinCoroutineDependency(handler: DependencyHandler){
                handler.add(IMPLEMENTATION, kotlinCoroutineDep)
        }
        private val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:3.9.0"
        fun addLoggingInterceptorDep(handler: DependencyHandler){
                handler.add(IMPLEMENTATION, LOGGING_INTERCEPTOR)
        }





}