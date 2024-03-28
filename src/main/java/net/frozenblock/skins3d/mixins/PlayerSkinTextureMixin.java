package net.frozenblock.skins3d.mixins;

import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.PlayerSkinTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerSkinTexture.class)
public class PlayerSkinTextureMixin {

    @Inject(at = @At("HEAD"), method = "stripAlpha", cancellable = true)
    private static void onStrip(NativeImage image, int x1, int y1, int x2, int y2, CallbackInfo ci) {
        if(x1 == 0 && y1 == 0) {
            ci.cancel();
        }

    }
}
