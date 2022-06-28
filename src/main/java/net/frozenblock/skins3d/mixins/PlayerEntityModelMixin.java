package net.frozenblock.skins3d.mixins;

import net.frozenblock.skins3d.Config;
import net.frozenblock.skins3d.model.CustomPlayerModel;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;

@Mixin(PlayerEntityModel.class)
public class PlayerEntityModelMixin {

    @Inject(at = @At("RETURN"), method = "getTexturedModelData", cancellable = true)
    private static void newModel(Dilation dilation, boolean slim, CallbackInfoReturnable<ModelData> cir) throws IOException {
        if(Config.getConfig("enable")) {
            cir.setReturnValue(CustomPlayerModel.getCustomPlayerFinalShape(dilation, slim));
        }
    }
}
