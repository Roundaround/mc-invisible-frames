plugins {
  id("me.roundaround.allay")
}

allay {
  displayName.set("Invisible Frames")
  description.set("Easily toggle invisibility on your item frames by sneaking.")
  authors.set(listOf("Roundaround"))
  license.set("MIT")
  homepage.set("https://modrinth.com/mod/invisible-frames-mod")
  repository.set("https://github.com/Roundaround/mc-fabric-invisible-frames")
  issues.set("https://github.com/Roundaround/mc-fabric-invisible-frames/issues")

  modrinth {
    projectId.set("invisible-frames")
  }

  curseforge {
    projectId.set(1295518)
  }

  release {
    versionType.set("release")
    sourcesJar.set(true)
  }
}
