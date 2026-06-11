plugins {
  id("me.roundaround.allay")
}

repositories {
  mavenLocal()
}

allay {
  modrinth {
    dependencies {
      required("fabric-api")
    }
  }

  // Fabric build runs on Quilt too — advertise both on Modrinth/CurseForge.
  // Name/slug/artifact stay "Fabric"; this only widens the Loaders field.
  release {
    loaders.set(listOf("fabric", "quilt"))
  }
}

dependencies {
  libBundle(platform(libs.trove.bom))
  libBundle(libs.trove.fabric.core)
}
