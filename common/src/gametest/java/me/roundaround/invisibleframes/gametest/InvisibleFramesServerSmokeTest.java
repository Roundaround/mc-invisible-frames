package me.roundaround.invisibleframes.gametest;

import me.roundaround.allay.api.gametest.ServerGameTest;
import me.roundaround.trove.gametest.ServerSmokeTest;

/**
 * Asserts Invisible Frames boots a dedicated server cleanly and loads no client
 * code. The body lives in {@link ServerSmokeTest}; this opt-in subclass just
 * carries the {@code @ServerGameTest} marker the build-time scan discovers.
 */
@ServerGameTest
public class InvisibleFramesServerSmokeTest extends ServerSmokeTest {
}
