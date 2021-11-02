
apply {
    from("$rootDir/library-build.gradle")
}
plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
    id(SqlDelight.plugin)
}

dependencies{
    "implementation"(project(Modules.movieDomain))

    "implementation"(Ktor.core)
    "implementation"(Ktor.clientSerialization)
    "implementation"(Ktor.android)

    "implementation"(SqlDelight.runtime)

}


sqldelight {
    database("MovieDatabase") {
        packageName = "com.ultradcr.movie_datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}