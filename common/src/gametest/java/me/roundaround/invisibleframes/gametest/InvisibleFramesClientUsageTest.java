package me.roundaround.invisibleframes.gametest;

import me.roundaround.allay.api.gametest.ClientGameTest;
import me.roundaround.trove.gametest.ClientTest;
import me.roundaround.trove.gametest.ClientTestContext;
import me.roundaround.trove.gametest.ClientWorld;
import me.roundaround.trove.gametest.GameTestAssertionException;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.decoration.ItemFrame;

/**
 * Drives the mod's one feature through the real interaction path: place an item
 * frame holding an item, hold sneak so the server player enters the crouch pose,
 * then right-click the frame. The {@code ItemFrameMixin} hook fires off the
 * frame's interact {@code playSound} and, because the player is crouching,
 * toggles the frame invisible — which we assert syncs back to the client entity.
 * Single-player, creative.
 */
@ClientGameTest
public class InvisibleFramesClientUsageTest implements ClientTest {
  @Override
  public void runTest(ClientTestContext context) {
    try (ClientWorld world = context.worldBuilder().creative().stopTime(true).create()) {
      world.fill(new BlockPos(-1, 64, -1), new BlockPos(1, 64, 1), "minecraft:smooth_stone");
      world.setBlock(new BlockPos(2, 65, 0), "minecraft:stone");
      world.teleport(0.5, 65.0, 0.5);
      context.waitTicks(2);

      // A frame on the west face of the stone block, already holding an item so
      // the interact path reaches the rotation branch (and the mixin's playSound).
      ItemFrame frame = world.summon(
          EntityTypes.ITEM_FRAME,
          new BlockPos(2, 65, 0),
          "{facing:west,Item:{id:\"minecraft:diamond\",count:1}}"
      );
      world.setMainHandItem("minecraft:air");
      context.waitTicks(2);

      if (frame.isInvisible()) {
        throw new GameTestAssertionException("frame should start visible");
      }

      // Hold the real sneak key so the server player adopts the crouch pose the
      // mixin checks (isCrouching()), then right-click the frame while crouched.
      context.runOnClient((mc) -> mc.options.keyShift.setDown(true));
      world.lookAt(frame);
      context.waitFor(
          (mc) -> mc.player != null && mc.player.isCrouching(),
          20
      );
      world.useItemOn(frame);
      world.settle();
      context.runOnClient((mc) -> mc.options.keyShift.setDown(false));

      if (!frame.isInvisible()) {
        throw new GameTestAssertionException("sneak + interact should have made the frame invisible");
      }
    }
  }
}
