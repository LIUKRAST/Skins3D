package net.frozenblock.skins3d.mixins;

import net.frozenblock.skins3d.Skins3D;
import net.frozenblock.skins3d.model.CustomPlayerModel;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityModel.class)
public class PlayerEntityModelMixin {

    @Inject(at = @At("RETURN"), method = "getTexturedModelData", cancellable = true)
    private static void newModel(Dilation dilation, boolean slim, CallbackInfoReturnable<ModelData> cir) {
        if (Skins3D.configRes1) {
            cir.setReturnValue(CustomPlayerModel.getCustomPlayerFinalShape(dilation, slim));
        }
    }
}
