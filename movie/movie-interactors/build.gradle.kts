
apply {
    from("$rootDir/library-build.gradle")
}
dependencies{
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.movieDataSource))
    "implementation"(project(Modules.movieDomain))

    "implementation"(Kotlinx.coroutinesCore)

}