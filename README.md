![Invisible Frames](https://i.imgur.com/8hsV9XT.png)

[![Modrinth Downloads](https://img.shields.io/modrinth/dt/invisible-frames-mod?style=flat&logo=modrinth&color=00AF5C)](https://modrinth.com/mod/invisible-frames-mod)
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/1295518?style=flat&logo=curseforge&color=F16436)](https://www.curseforge.com/minecraft/mc-mods/rounds-invisible-frames)
[![GitHub Repo stars](https://img.shields.io/github/stars/Roundaround/mc-invisible-frames?style=flat&logo=github)](https://github.com/Roundaround/mc-invisible-frames)

[![Support me on Ko-fi](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/donate/kofi-singular-alt_vector.svg)](https://ko-fi.com/roundaround)

Toggle invisibility on an item frame by sneaking as you right click it.

## Installing

Grab a build from [Modrinth](https://modrinth.com/mod/invisible-frames-mod) or [CurseForge](https://www.curseforge.com/minecraft/mc-mods/rounds-invisible-frames). Fabric builds need [Fabric API](https://modrinth.com/mod/fabric-api).

## Building from source

```sh
./gradlew build
```

Dev runs are per loader: `:fabric:runClient`, `:neoforge:runClient`, `:forge:runClient`, and the `runServer` equivalents. Game tests run with `./gradlew :fabric:runClientGameTests` and `:fabric:runServerGameTests`.

The build is an [Allay](https://github.com/Roundaround/allay) consumer and bundles [Trove](https://github.com/Roundaround/trove).

Shared code lives in `common/` and is added to each loader subproject via `srcDir`.

## Contributing

Issues and pull requests are welcome at [the issue tracker](https://github.com/Roundaround/mc-invisible-frames/issues).

- Branch from `main`, which tracks the newest supported Minecraft version. Older lines live on their own version-named branches.
- Keep loader-agnostic code in `common/`; only genuinely loader-specific glue belongs in a loader subproject.
- Run `./gradlew build` plus the Fabric game tests before opening a PR, and add a changelog entry under `changelogs/` named for the version you're targeting.

## License

[MIT](LICENSE)
