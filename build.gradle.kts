import net.minecraftforge.gradle.delayed.DelayedString

plugins {
    java
    id("forge")
}

version = "1.0.0"
group = "com.yourname.modid"


minecraft {
    version = "1.7.10-10.13.4.1614-1.7.10"
    runDir = "run"
}

dependencies {
    // you may put jars on which you depend on in ./libs
    // or you may define them like so..
    //implementation("some.group:artifact:version:classifier")
    //implementation("some.group:artifact:version")


    // real examples
    //implementation("com.mod-buildcraft:buildcraft:6.0.8:dev")  // adds buildcraft to the dev env
    //implementation("com.googlecode.efficient-java-matrix-library:ejml:0.24") // adds ejml to the dev env

    // for more info...
    // http://www.gradle.org/docs/current/userguide/artifact_dependencies_tutorial.html
    // http://www.gradle.org/docs/current/userguide/dependency_management.html
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    downloadClient{
        setUrl(DelayedString(project,"https://launcher.mojang.com/v1/objects/e80d9b3bf5085002218d4be59e668bac718abbc6/client.jar"))
    }
    downloadServer{
        setUrl(DelayedString(project,"https://launcher.mojang.com/v1/objects/952438ac4e01b4d115c5fc38f891710c4941df29/server.jar"))
    }
    getAssetsIndex{
        setUrl("https://launchermeta.mojang.com/v1/packages/1863782e33ce7b584fc45b037325a1964e095d3e/1.7.10.json")
    }
    getVersionJson{
        setUrl("https://launchermeta.mojang.com/v1/packages/ed5d8789ed29872ea2ef1c348302b0c55e3f3468/1.7.10.json")
    }
}

