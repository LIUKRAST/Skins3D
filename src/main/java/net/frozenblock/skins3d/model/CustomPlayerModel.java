package net.frozenblock.skins3d.model;

import net.frozenblock.skins3d.Skins3D;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;

public class CustomPlayerModel {

    public static final String FACE = "face";
    private static final String EAR = "ear";
    private static final String CLOAK = "cloak";
    private static final String LEFT_SLEEVE = "left_sleeve";
    private static final String RIGHT_SLEEVE = "right_sleeve";
    private static final String LEFT_PANTS = "left_pants";
    private static final String RIGHT_PANTS = "right_pants";

    public static ModelData getCustomPlayerBasicShape(Dilation dilation, float pivotOffsetY) {
        final ModelData modelData = new ModelData();
        final ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, dilation), ModelTransform.pivot(0.0f, 0.0f + pivotOffsetY, 0.0f));
        final ModelPartData c = !Skins3D.configRes4 ? modelPartData : modelPartData.addChild("face_root", ModelPartBuilder.create(), ModelTransform.pivot(0.0f, 0.0f + pivotOffsetY, 0.0f));
        c.addChild(FACE,
                ModelPartBuilder.create().uv(24, 0)
                        .cuboid(-4.0f, -8.0f, 4.05f * (Skins3D.configRes4 ? 1 : -1), 8.0f, 8.0f, 0, dilation), ModelTransform.pivot(0.0f, 0.0f + pivotOffsetY, 0.0f));

        modelPartData.addChild(EntityModelPartNames.HAT,
                layering(2, dilation, 32, 0, -4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f)
                , ModelTransform.pivot(0.0f, 0.0f + pivotOffsetY, 0.0f));

        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(16, 16).cuboid(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(0.0f, 0.0f + pivotOffsetY, 0.0f));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(40, 16).cuboid(-3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(-5.0f, 2.0f + pivotOffsetY, 0.0f));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(5.0f, 2.0f + pivotOffsetY, 0.0f));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(0, 16).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(-1.9f, 12.0f + pivotOffsetY, 0.0f));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(1.9f, 12.0f + pivotOffsetY, 0.0f));
        return modelData;
    }

    public static ModelData getCustomPlayerFinalShape(Dilation dilation, boolean slim) {
        ModelData modelData = getCustomPlayerBasicShape(dilation, 0.0f);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EAR, ModelPartBuilder.create().uv(24, 0).cuboid(-3.0f, -6.0f, -1.0f, 6.0f, 6.0f, 1.0f, dilation), ModelTransform.NONE);
        modelPartData.addChild(CLOAK, ModelPartBuilder.create().uv(0, 0).cuboid(-5.0f, 0.0f, -1.0f, 10.0f, 16.0f, 1.0f, dilation, 1.0f, 0.5f), ModelTransform.pivot(0.0f, 0.0f, 0.0f));

        ModelPartBuilder SLIM_LEFT_SLEEVE_3D = layering(1, dilation, 48, 48, -1.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f);
        ModelPartBuilder SLIM_RIGHT_SLEEVE_3D = layering(1, dilation, 40, 32, -2.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f);

        ModelPartBuilder LEFT_SLEEVE_3D = layering(1, dilation, 48, 48, -1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        ModelPartBuilder RIGHT_SLEEVE_3D = layering(1, dilation, 40, 32, -3.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f);

        ModelPartBuilder LEFT_PANTS_3D = layering(1, dilation, 0, 48, -2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        ModelPartBuilder RIGHT_PANTS_3D = layering(1, dilation, 0, 32, -2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        ModelPartBuilder JACKET_3D = layering(1, dilation, 16, 32, -4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0f);

        if (slim) {
            modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(32, 48).cuboid(-1.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(5.0f, 2.5f, 0.0f));
            modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(40, 16).cuboid(-2.0f, -2.0f, -2.0f, 3.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(-5.0f, 2.5f, 0.0f));
            modelPartData.addChild(LEFT_SLEEVE, SLIM_LEFT_SLEEVE_3D, ModelTransform.pivot(5.0f, 2.5f, 0.0f));
            modelPartData.addChild(RIGHT_SLEEVE, SLIM_RIGHT_SLEEVE_3D, ModelTransform.pivot(-5.0f, 2.5f, 0.0f));
        } else {
            modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(32, 48).cuboid(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(5.0f, 2.0f, 0.0f));
            modelPartData.addChild(LEFT_SLEEVE, LEFT_SLEEVE_3D, ModelTransform.pivot(5.0f, 2.0f, 0.0f));
            modelPartData.addChild(RIGHT_SLEEVE, RIGHT_SLEEVE_3D, ModelTransform.pivot(-5.0f, 2.0f, 0.0f));
        }
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(16, 48).cuboid(-2.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f, dilation), ModelTransform.pivot(1.9f, 12.0f, 0.0f));
        modelPartData.addChild(LEFT_PANTS, LEFT_PANTS_3D, ModelTransform.pivot(1.9f, 12.0f, 0.0f));
        modelPartData.addChild(RIGHT_PANTS, RIGHT_PANTS_3D, ModelTransform.pivot(-1.9f, 12.0f, 0.0f));
        modelPartData.addChild(EntityModelPartNames.JACKET, JACKET_3D, ModelTransform.NONE);
        return modelData;
    }

    public static ModelPartBuilder layering(int amount, Dilation dilation, int textureX, int textureY, float offsetX, float offsetY, float offsetZ, float sizeX, float sizeY, float sizeZ) {
        ModelPartBuilder LAYER = ModelPartBuilder.create();
        for (int i = amount * Skins3D.configRes3; i > 0; i--) {
            float dil = ((float) i / 100) * (25 / (float) Skins3D.configRes3);
            LAYER.uv(textureX, textureY).cuboid(offsetX, offsetY, offsetZ, sizeX, sizeY, sizeZ, dilation.add(dil));
        }
        return LAYER;
    }
}
