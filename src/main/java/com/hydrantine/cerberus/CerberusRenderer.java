package com.hydrantine.cerberus;

import com.hydrantine.Ref;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CerberusRenderer extends MobRenderer<CerberusEntity, CerberusModel>{

	public static final ResourceLocation CERBERUS_TEXTURE = new ResourceLocation(Ref.MODID, "textures/entity/cerberus.png");
	
	public CerberusRenderer(Context context) {
		super(context, new CerberusModel(context.bakeLayer(CerberusModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CerberusEntity p_115812_) {
		return CERBERUS_TEXTURE;
	}

}
