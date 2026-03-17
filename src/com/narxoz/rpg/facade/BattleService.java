package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    private static final int MAX_ROUNDS = 100;

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int heroHp = hero.getHealth();
        int bossHp = boss.getHealth();
        int round = 0;

        while (heroHp > 0 && bossHp > 0 && round < MAX_ROUNDS) {
            round++;
            int heroDamage = action.getDamage();
            bossHp = Math.max(0, bossHp - heroDamage);
            result.addLine(String.format("Round %d: %s hits for %d. Boss HP: %d", round, hero.getName(), heroDamage, bossHp));
            if (bossHp <= 0) break;

            int bossDamage = boss.getAttackPower();
            heroHp = Math.max(0, heroHp - bossDamage);
            result.addLine(String.format("Round %d: %s hits for %d. Hero HP: %d", round, boss.getName(), bossDamage, heroHp));
        }

        result.setRounds(round);
        if (bossHp <= 0) {
            result.setWinner(hero.getName());
            result.setHeroWon(true);
        } else {
            result.setWinner(boss.getName());
            result.setHeroWon(false);
        }
        return result;
    }
}
