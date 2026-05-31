package me.roundaround.invisibleframes.forge;

import me.roundaround.trove.forge.TroveForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("invisibleframes")
public final class InvisibleFramesForgeMod {
  public InvisibleFramesForgeMod(FMLJavaModLoadingContext context) {
    TroveForge.bootstrap(context);
    // Mixin-only mod: nothing else to register.
  }
}
