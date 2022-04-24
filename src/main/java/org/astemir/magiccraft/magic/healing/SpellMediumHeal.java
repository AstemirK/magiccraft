package org.astemir.magiccraft.magic.healing;

import org.astemir.magiccraft.config.SpellsConfiguration;
import org.astemir.magiccraft.graphics.UnicodeSymbols;
import org.astemir.magiccraft.magic.MagicSpell;
import org.astemir.magiccraft.magic.MasterSpell;
import org.astemir.magiccraft.magic.Spells;
import org.astemir.magiccraft.utils.MagicUtils;
import org.astemir.magiccraft.utils.RandomUtils;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpellMediumHeal extends MasterSpell {


    public SpellMediumHeal() {
        super(SpellsConfiguration.MEDIUM_HEAL);
    }

    @Override
    public void onUse(Player player) {
        player.addPotionEffect(SpellsConfiguration.MEDIUM_HEAL.effect("regeneration").toBukkit());
        MagicUtils.healParticles(player.getLocation().clone().add(0,0.5f,0),10,1f);
        player.getWorld().playSound(player.getLocation(), "magiccraft.items.magic_heal", 1, RandomUtils.randomFloat(0.9f,1.1f));
    }

    @Override
    public MagicSpell getRequiredSpell() {
        return Spells.HEAL_SPELL;
    }

}
