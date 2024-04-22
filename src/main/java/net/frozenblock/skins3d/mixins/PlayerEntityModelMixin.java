package net.frozenblock.skins3d.mixins;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import net.frozenblock.skins3d.Skins3D;
import net.frozenblock.skins3d.model.CustomPlayerModel;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityModel.class)
public final class PlayerEntityModelMixin {
    @Unique
    private ModelPart root;
    @Unique
    private ModelPart face_root;
    @Unique
    private ModelPart face;

    /**
     * We want to store all the variables we will use later for animations*/
    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(final ModelPart root,
                      final boolean thinArms,
                      final CallbackInfo ci) {
        this.root = root;
        if (Skins3D.configRes4) this.face_root = root.getChild("face_root");
        face = Skins3D.configRes4 ? face_root.getChild("face") : root.getChild("face");
    }
    @Inject(at = @At("RETURN"), method = "getTexturedModelData", cancellable = true)
    private static void newModel(final Dilation dilation,
                                 final boolean slim,
                                 final CallbackInfoReturnable<ModelData> cir) {
        if (Skins3D.configRes1) cir.setReturnValue(CustomPlayerModel.getCustomPlayerFinalShape(dilation, slim));
    }
    @Inject(at = @At("TAIL"), method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V")
    private void render(final LivingEntity livingEntity,
                        final float f,
                        final float g,
                        final float time,
                        final float i,
                        final float j,
                        final CallbackInfo ci) {
        face.hidden = Math.cos(time/5f + livingEntity.getUuid().variant()) < 0.95f;
        if(Skins3D.configRes4) {
            face_root.copyTransform(root.getChild("head"));
            face.yaw = (float) Math.PI;
        } else face.copyTransform(root.getChild("head"));
    }
    @Inject(at = @At("RETURN"), method = "getBodyParts", cancellable = true)
    private void getBodyParts(final CallbackInfoReturnable<Iterable<ModelPart>> cir) {
        cir.setReturnValue(
                Iterables.concat(
                        cir.getReturnValue(),
                        ImmutableList.of(Skins3D.configRes4 ? this.face_root : this.face))
        );
    }
}
