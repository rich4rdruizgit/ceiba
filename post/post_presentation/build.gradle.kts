apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.postDomain))
    "implementation"(project(Modules.postData))


    "implementation"(Coil.coilCompose)
}