package coda.ratcopter.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RatcopterModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer base;
    public ModelRenderer basket;
    public ModelRenderer tail1;
    public ModelRenderer head;
    public ModelRenderer armLeft1;
    public ModelRenderer armRight1;
    public ModelRenderer tail2;
    public ModelRenderer propellerTail;
    public ModelRenderer tailProp1;
    public ModelRenderer tailProp2;
    public ModelRenderer tailProp3;
    public ModelRenderer snout;
    public ModelRenderer propellerNose;
    public ModelRenderer noseProp1;
    public ModelRenderer noseProp2;
    public ModelRenderer noseProp3;
    public ModelRenderer hat;
    public ModelRenderer hatBrim;
    public ModelRenderer headlamp;
    public ModelRenderer hatLeft;
    public ModelRenderer hatRight;
    public ModelRenderer armLeft2;
    public ModelRenderer propellerArmLeft;
    public ModelRenderer armLeftProp1;
    public ModelRenderer armLeftProp2;
    public ModelRenderer armLeftProp3;
    public ModelRenderer armRight2;
    public ModelRenderer propellerArmLeft_1;
    public ModelRenderer armRightProp1;
    public ModelRenderer armRightProp2;
    public ModelRenderer armRightProp3;

    public RatcopterModel() {
        this.texWidth = 512;
        this.texHeight = 128;
        this.tailProp3 = new ModelRenderer(this, 130, 0);
        this.tailProp3.setPos(0.0F, 0.0F, 0.0F);
        this.tailProp3.addBox(0.0F, -1.0F, -5.0F, 26.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tailProp3, 0.0F, -2.0943951023931953F, 0.0F);
        this.noseProp1 = new ModelRenderer(this, 234, 0);
        this.noseProp1.setPos(0.0F, -0.5F, -5.0F);
        this.noseProp1.addBox(-3.0F, -10.0F, -1.0F, 6.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tailProp1 = new ModelRenderer(this, 130, 0);
        this.tailProp1.setPos(0.0F, 0.0F, 0.0F);
        this.tailProp1.addBox(0.0F, -1.0F, -5.0F, 26.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tailProp1, 0.0F, 2.0943951023931953F, 0.0F);
        this.propellerArmLeft = new ModelRenderer(this, 0, 0);
        this.propellerArmLeft.setPos(0.0F, -20.0F, 0.0F);
        this.propellerArmLeft.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(propellerArmLeft, 0.0F, 1.5707963267948966F, 0.0F);
        this.armRightProp1 = new ModelRenderer(this, 0, 88);
        this.armRightProp1.setPos(0.0F, 0.0F, 0.0F);
        this.armRightProp1.addBox(0.0F, -1.0F, -5.0F, 30.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(armRightProp1, 0.0F, 2.0943951023931953F, 0.0F);
        this.armRight2 = new ModelRenderer(this, 436, 11);
        this.armRight2.setPos(-36.0F, -4.0F, 0.0F);
        this.armRight2.addBox(-4.0F, -20.0F, -4.0F, 8.0F, 20.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.armLeft1 = new ModelRenderer(this, 348, 85);
        this.armLeft1.mirror = true;
        this.armLeft1.setPos(16.0F, -7.0F, -20.0F);
        this.armLeft1.addBox(0.0F, -4.0F, -4.0F, 40.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 24, 0);
        this.snout.setPos(0.0F, 3.0F, -16.0F);
        this.snout.addBox(-4.0F, -4.5F, -8.0F, 8.0F, 9.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.armRightProp2 = new ModelRenderer(this, 64, 85);
        this.armRightProp2.setPos(0.0F, 0.0F, 0.0F);
        this.armRightProp2.addBox(0.0F, -1.0F, -5.0F, 30.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 0, 0);
        this.tail2.setPos(0.0F, -3.5F, 41.0F);
        this.tail2.addBox(-3.0F, -28.0F, -3.0F, 6.0F, 28.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.armLeft2 = new ModelRenderer(this, 436, 11);
        this.armLeft2.setPos(36.0F, -4.0F, 0.0F);
        this.armLeft2.addBox(-4.0F, -20.0F, -4.0F, 8.0F, 20.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.headlamp = new ModelRenderer(this, 130, 11);
        this.headlamp.setPos(0.0F, -4.5F, -9.0F);
        this.headlamp.addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.armRightProp3 = new ModelRenderer(this, 64, 88);
        this.armRightProp3.setPos(0.0F, 0.0F, 0.0F);
        this.armRightProp3.addBox(0.0F, -1.0F, -5.0F, 30.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(armRightProp3, 0.0F, -2.0943951023931953F, 0.0F);
        this.propellerTail = new ModelRenderer(this, 0, 0);
        this.propellerTail.setPos(0.0F, -28.0F, 0.0F);
        this.propellerTail.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(propellerTail, 0.0F, 1.5707963267948966F, 0.0F);
        this.hatLeft = new ModelRenderer(this, 401, 11);
        this.hatLeft.setPos(10.0F, 1.0F, 0.5F);
        this.hatLeft.addBox(-2.0F, 0.0F, -4.5F, 2.0F, 13.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setPos(0.0F, -9.0F, 0.0F);
        this.base.addBox(-16.0F, -11.0F, -33.0F, 32.0F, 22.0F, 66.0F, 0.0F, 0.0F, 0.0F);
        this.propellerArmLeft_1 = new ModelRenderer(this, 0, 0);
        this.propellerArmLeft_1.setPos(0.0F, -20.0F, 0.0F);
        this.propellerArmLeft_1.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(propellerArmLeft_1, 0.0F, 1.5707963267948966F, 0.0F);
        this.propellerNose = new ModelRenderer(this, 369, 0);
        this.propellerNose.setPos(0.0F, -4.5F, -5.0F);
        this.propellerNose.addBox(-2.5F, -3.0F, -5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.armLeftProp2 = new ModelRenderer(this, 64, 88);
        this.armLeftProp2.setPos(0.0F, 0.0F, 0.0F);
        this.armLeftProp2.addBox(0.0F, -1.0F, -5.0F, 30.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.armRight1 = new ModelRenderer(this, 348, 85);
        this.armRight1.setPos(-16.0F, -7.0F, -20.0F);
        this.armRight1.addBox(-40.0F, -4.0F, -4.0F, 40.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 398, 18);
        this.tail1.setPos(0.0F, -7.5F, 33.0F);
        this.tail1.addBox(-3.0F, -3.5F, 0.0F, 6.0F, 7.0F, 44.0F, 0.0F, 0.0F, 0.0F);
        this.tailProp2 = new ModelRenderer(this, 130, 0);
        this.tailProp2.setPos(0.0F, 0.0F, 0.0F);
        this.tailProp2.addBox(0.0F, -1.0F, -5.0F, 26.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.basket = new ModelRenderer(this, 196, 0);
        this.basket.setPos(0.0F, 11.0F, 0.0F);
        this.basket.addBox(-14.0F, 0.0F, -27.5F, 28.0F, 22.0F, 55.0F, 0.0F, 0.0F, 0.0F);
        this.armLeftProp3 = new ModelRenderer(this, 64, 88);
        this.armLeftProp3.setPos(0.0F, 0.0F, 0.0F);
        this.armLeftProp3.addBox(0.0F, -1.0F, -5.0F, 30.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(armLeftProp3, 0.0F, -2.0943951023931953F, 0.0F);
        this.hat = new ModelRenderer(this, 307, 11);
        this.hat.setPos(0.0F, -2.0F, 13.0F);
        this.hat.addBox(-9.0F, -12.0F, -9.0F, 18.0F, 12.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.hatRight = new ModelRenderer(this, 401, 11);
        this.hatRight.setPos(-10.0F, 1.0F, 0.5F);
        this.hatRight.addBox(0.0F, 0.0F, -4.5F, 2.0F, 13.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 186, 0);
        this.head.setPos(0.0F, -3.5F, -33.0F);
        this.head.addBox(-8.0F, -7.5F, -16.0F, 16.0F, 15.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.armLeftProp1 = new ModelRenderer(this, 64, 88);
        this.armLeftProp1.setPos(0.0F, 0.0F, 0.0F);
        this.armLeftProp1.addBox(0.0F, -1.0F, -5.0F, 30.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(armLeftProp1, 0.0F, 2.0943951023931953F, 0.0F);
        this.noseProp3 = new ModelRenderer(this, 244, 0);
        this.noseProp3.setPos(0.0F, -0.5F, -5.0F);
        this.noseProp3.addBox(-3.0F, -10.0F, -1.0F, 6.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(noseProp3, 0.0F, 0.0F, -2.0943951023931953F);
        this.hatBrim = new ModelRenderer(this, 130, 31);
        this.hatBrim.setPos(0.0F, 0.0F, 0.0F);
        this.hatBrim.addBox(-10.0F, -1.0F, -10.0F, 20.0F, 2.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.noseProp2 = new ModelRenderer(this, 234, 0);
        this.noseProp2.setPos(0.0F, -0.5F, -5.0F);
        this.noseProp2.addBox(-3.0F, -10.0F, -1.0F, 6.0F, 10.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(noseProp2, 0.0F, 0.0F, 2.0943951023931953F);
        this.propellerTail.addChild(this.tailProp3);
        this.propellerNose.addChild(this.noseProp1);
        this.propellerTail.addChild(this.tailProp1);
        this.armLeft2.addChild(this.propellerArmLeft);
        this.propellerArmLeft_1.addChild(this.armRightProp1);
        this.armRight1.addChild(this.armRight2);
        this.base.addChild(this.armLeft1);
        this.head.addChild(this.snout);
        this.propellerArmLeft_1.addChild(this.armRightProp2);
        this.tail1.addChild(this.tail2);
        this.armLeft1.addChild(this.armLeft2);
        this.hat.addChild(this.headlamp);
        this.propellerArmLeft_1.addChild(this.armRightProp3);
        this.tail2.addChild(this.propellerTail);
        this.hat.addChild(this.hatLeft);
        this.armRight2.addChild(this.propellerArmLeft_1);
        this.snout.addChild(this.propellerNose);
        this.propellerArmLeft.addChild(this.armLeftProp2);
        this.base.addChild(this.armRight1);
        this.base.addChild(this.tail1);
        this.propellerTail.addChild(this.tailProp2);
        this.base.addChild(this.basket);
        this.propellerArmLeft.addChild(this.armLeftProp3);
        this.propellerNose.addChild(this.hat);
        this.hat.addChild(this.hatRight);
        this.base.addChild(this.head);
        this.propellerArmLeft.addChild(this.armLeftProp1);
        this.propellerNose.addChild(this.noseProp3);
        this.hat.addChild(this.hatBrim);
        this.propellerNose.addChild(this.noseProp2);
    }

    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        ImmutableList.of(this.base).forEach((modelRenderer) -> {
            modelRenderer.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_, p_225598_5_, p_225598_6_, p_225598_7_, p_225598_8_);
        });
    }
}
