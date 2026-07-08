package main.Items;


import main.Screens.RuinedPageScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class RuinedPaper extends Item {
    public RuinedPaper(Properties properties) {

        super(properties);
    }
    @Override
    public void appendHoverText(ItemStack p_41421_, TooltipContext p_339594_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(Component.literal("A worn out Scroll with ancient texts.."));
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide) {
            Minecraft.getInstance().setScreen(new RuinedPageScreen(Component.literal("Ruined Scroll")));
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
