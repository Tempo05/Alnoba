
package net.mcreator.alnoba.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.alnoba.world.inventory.IronfurnaceguiMenu;
import net.mcreator.alnoba.procedures.Progressfire4Procedure;
import net.mcreator.alnoba.procedures.Progressfire3Procedure;
import net.mcreator.alnoba.procedures.Progressfire2Procedure;
import net.mcreator.alnoba.procedures.Progressfire1Procedure;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class IronfurnaceguiScreen extends AbstractContainerScreen<IronfurnaceguiMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public IronfurnaceguiScreen(IronfurnaceguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("alnoba_1_17_1:textures/ironfurnacegui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (Progressfire1Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("alnoba_1_17_1:textures/fire_empy.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Progressfire2Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("alnoba_1_17_1:textures/fuego_1.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Progressfire3Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("alnoba_1_17_1:textures/fuego_2.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		if (Progressfire4Procedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("alnoba_1_17_1:textures/fuego_3.png"));
			this.blit(ms, this.leftPos + 61, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Iron Furnace", 3, 3, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}
}
