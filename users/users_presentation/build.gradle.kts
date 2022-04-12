apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.usersDomain))
    "implementation"(project(Modules.usersData))


    "implementation"(Coil.coilCompose)
}