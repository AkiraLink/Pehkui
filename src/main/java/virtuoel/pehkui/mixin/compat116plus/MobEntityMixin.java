package virtuoel.pehkui.mixin.compat116plus;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import virtuoel.pehkui.util.ScaleUtils;

@Mixin(MobEntity.class)
public class MobEntityMixin
{
	@Inject(at = @At("RETURN"), method = "method_29243")
	private <T extends MobEntity> void onMethod_29243(EntityType<T> entityType, boolean bl, CallbackInfoReturnable<T> info)
	{
		final MobEntity e = info.getReturnValue();
		
		if (e != null)
		{
			ScaleUtils.loadScale(e, this);
		}
	}
}
