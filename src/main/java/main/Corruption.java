package main;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public interface Corruption {
    default Component SetDescription(String type, ChatFormatting color){
        return Component.literal("Corruption : "+type).withStyle(color);
    }
}
