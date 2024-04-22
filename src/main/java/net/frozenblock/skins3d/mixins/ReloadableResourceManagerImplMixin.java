package net.frozenblock.skins3d.mixins;

import net.frozenblock.skins3d.Config;
import net.frozenblock.skins3d.Skins3D;
import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.ResourcePack;
import net.minecraft.resource.ResourceReload;
import net.minecraft.util.Unit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(ReloadableResourceManagerImpl.class)
public final class ReloadableResourceManagerImplMixin {
    @Inject(at = @At("HEAD"), method = "reload")
    private void reload(final Executor prepareExecutor,
                        final Executor applyExecutor,
                        final CompletableFuture<Unit> initialStage,
                        final List<ResourcePack> packs,
                        final CallbackInfoReturnable<ResourceReload> cir) {
        Skins3D.configRes1 = Boolean.parseBoolean((String) Config.getConfig("player"));
        Skins3D.configRes2 = Boolean.parseBoolean((String) Config.getConfig("player.heads"));
        Skins3D.configRes3 = Integer.parseInt((String) Objects.requireNonNull(Config.getConfig("resolution")));
    }
}
