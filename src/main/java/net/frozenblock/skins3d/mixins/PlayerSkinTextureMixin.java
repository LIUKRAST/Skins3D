package net.frozenblock.skins3d.mixins;

import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.PlayerSkinTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerSkinTexture.class)
public final class PlayerSkinTextureMixin {
    private PlayerSkinTextureMixin() {}

    @Inject(at = @At("HEAD"), method = "stripAlpha", cancellable = true)
    private static void onStrip(final NativeImage image,
                                final int x1,
                                final int y1,
                                final int x2,
                                final int y2,
                                final CallbackInfo ci) {
        if(x1 == 0 && y1 == 0) ci.cancel();
    }
}
