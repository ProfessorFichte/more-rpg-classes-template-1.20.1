package net.more_rpg_classes.client.effect;

import net.more_rpg_classes.MRPGCMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.spell_engine.api.effect.CustomModelStatusEffect;
import net.spell_engine.api.render.CustomLayers;
import net.spell_engine.api.render.CustomModels;
import net.spell_engine.api.render.LightEmission;

public class FrozenSolidRenderer implements CustomModelStatusEffect.Renderer{

    private static final RenderLayer RENDER_LAYER = CustomLayers.spellEffect(LightEmission.RADIATE, true);
    public static final Identifier modelId = Identifier.of(MRPGCMod.MOD_ID, "effect/frozen_solid");

    @Override
    public void renderEffect(int amplifier, LivingEntity livingEntity, float delta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light) {
        matrixStack.push();
        matrixStack.translate(0, 0.6, 0);
        float scale = livingEntity.getScale();
        matrixStack.scale(scale + 0.25F  ,scale  , scale + 0.25F);
        CustomModels.render(RENDER_LAYER, MinecraftClient.getInstance().getItemRenderer(), modelId, matrixStack, vertexConsumers, light, livingEntity.getId());
        matrixStack.pop();
    }
}
