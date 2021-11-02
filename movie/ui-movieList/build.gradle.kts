apply {
    from("$rootDir/android-library-build.gradle")
}

dependencies{

    "implementation"(project(Modules.core))
    "implementation"(project(Modules.movieDomain))
    "implementation"(project(Modules.movieInteractors))
    "implementation"(project(Modules.components))

    "implementation"(Hilt.android)
    "kapt"(Hilt.compiler)


    "implementation"(SqlDelight.androidDriver)

    
}