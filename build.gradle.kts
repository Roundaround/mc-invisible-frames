plugins {
  id("me.roundaround.allay")
}

allay {
  displayName.set("Invisible Frames")
  description.set("Easily toggle invisibility on your item frames by sneaking.")
  authors.set(listOf("Roundaround"))
  license.set("MIT")
  homepage.set("https://modrinth.com/mod/invisible-frames-mod")
  repository.set("https://github.com/Roundaround/mc-invisible-frames")
  issues.set("https://github.com/Roundaround/mc-invisible-frames/issues")
  logoFile.set("assets/invisibleframes/banner.png")

  modrinth {
    projectId.set("invisible-frames")
  }

  curseforge {
    projectId.set(1295518)
  }

  release {
    versionType.set("release")
    // sourcesJar stays off: no sources download on Modrinth/CurseForge. The
    // Maven publication (publishLocal / self-hosted) always includes sources.
    // Compatible across the whole 26.1 point-release line. Drives the platform
    // game_versions (26.1, 26.1.1, 26.1.2) + the version title's "26.1-26.1.2".
    minecraftVersions("26.1".."26.1.2")
    changelogDir.set(file("changelogs"))
  }
}
