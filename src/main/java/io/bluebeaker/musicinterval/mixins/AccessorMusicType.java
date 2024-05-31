package io.bluebeaker.musicinterval.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.audio.MusicTicker.MusicType;

@Mixin(MusicType.class)
public interface AccessorMusicType {
    @Accessor(remap = true)
    void setMinDelay(int delay);
    @Accessor(remap = true)
    void setMaxDelay(int delay);
}
