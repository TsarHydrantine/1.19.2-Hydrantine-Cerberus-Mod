package com.hydrantine.cerberus;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

// Made with Blockbench 4.5.2
public class CerberusModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "cerberusmodel"), "main");
	private final ModelPart head;
	private final ModelPart head2;
	private final ModelPart body;
	private final ModelPart upperBody;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart tail;

	public CerberusModel(ModelPart root) {
		this.head = root.getChild("head");
		this.head2 = root.getChild("head2");
		this.body = root.getChild("body");
		this.upperBody = root.getChild("upperBody");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 0).addBox(-2.5F, -3.5F, -4.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(-2.5F, -5.5F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(1.5F, -5.5F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 3).addBox(-1.0F, -0.5F, -8.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 11.0F, -10.0F, 0.0F, -0.0436F, 0.0F));

		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(30, 10).addBox(-3.5F, -3.5F, -4.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.5F, -5.5F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(0.5F, -5.5F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 13).addBox(-2.0F, -0.5F, -8.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 11.0F, -10.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 42).addBox(-4.5F, -3.5F, -0.5F, 9.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition upperBody = partdefinition.addOrReplaceChild("upperBody", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, 3.0F, -8.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 14.0F, 2.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(40, 51).addBox(-1.75F, -2.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 16.0F, 7.0F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(52, 51).addBox(0.75F, -2.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 16.0F, 7.0F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(40, 38).addBox(-2.25F, -2.0F, -4.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 16.0F, -4.0F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(52, 38).addBox(1.3173F, -2.0F, -4.0618F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 16.0F, -4.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 13.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-1.5F, 0.0F, -3.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -0.5F, 0.9599F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		upperBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}