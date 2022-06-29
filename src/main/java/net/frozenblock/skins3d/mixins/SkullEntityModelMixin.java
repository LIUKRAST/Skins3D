package net.frozenblock.skins3d.mixins;

import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.frozenblock.skins3d.Config;
import net.frozenblock.skins3d.Skins3D;
import net.frozenblock.skins3d.model.CustomPlayerModel;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SkullEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;

@Mixin(SkullEntityModel.class)
public class SkullEntityModelMixin {

    @Inject(at = @At("RETURN"), method = "getHeadTexturedModelData", cancellable = true)
    private static void getHead(CallbackInfoReturnable<TexturedModelData> cir) throws IOException {
        ModelData modelData = SkullEntityModel.getModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.getChild(EntityModelPartNames.HEAD)
                .addChild(EntityModelPartNames.HAT,
                        CustomPlayerModel.layering(1, new Dilation(0), 32, 0, -4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f)
                        , ModelTransform.NONE);

        if(Skins3D.configRes2) {
            cir.setReturnValue(TexturedModelData.of(modelData, 64, 64));
        }
    }
}
