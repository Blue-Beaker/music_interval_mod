package io.bluebeaker.musicinterval.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.bluebeaker.musicinterval.MusicIntervalConfig;
import io.bluebeaker.musicinterval.MusicIntervalMod;
import net.minecraft.client.audio.MusicTicker.MusicType;
import net.minecraft.util.SoundEvent;

@Mixin(MusicType.class)
public abstract class MixinMusicType {
    @Inject(method = "<init>(Ljava/lang/String;ILnet/minecraft/util/SoundEvent;II)V",at = @At("RETURN"),remap = true)
    private void musicTypeClamp(String name,int index, SoundEvent musicLocationIn, int minDelayIn, int maxDelayIn,CallbackInfo ci){
        minDelayIn=Math.min(Math.max(minDelayIn,MusicIntervalConfig.mininterval),MusicIntervalConfig.maxinterval);
        maxDelayIn=Math.min(Math.max(maxDelayIn,MusicIntervalConfig.mininterval),MusicIntervalConfig.maxinterval);
        if(minDelayIn>0){
            ((AccessorMusicType)this).setMinDelay(minDelayIn);
        }
        ((AccessorMusicType)this).setMaxDelay(maxDelayIn);

        MusicIntervalMod.logInfo("Loading music type "+name+": id="+String.valueOf(index)+",minDelay="+String.valueOf(minDelayIn)+",maxDelay="+String.valueOf(maxDelayIn));
    }
}
