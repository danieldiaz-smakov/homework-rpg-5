package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Knight", 80);
        BossEnemy boss = new BossEnemy("Dragon", 100, 12);

        AttackAction basic = new BasicAttack("Strike", 10);
        AttackAction withFire = new FireRuneDecorator(basic);
        AttackAction fullChain = new FireRuneDecorator(
                new PoisonCoatingDecorator(
                        new CriticalFocusDecorator(new BasicAttack("Strike", 10))
                )
        );

        System.out.println("--- 1) Base vs single decorator ---");
        System.out.println("Base:    " + basic.getActionName() + " | damage=" + basic.getDamage() + " | " + basic.getEffectSummary());
        System.out.println("+ Fire:  " + withFire.getActionName() + " | damage=" + withFire.getDamage() + " | " + withFire.getEffectSummary());

        System.out.println("\n--- 2) Multi-layer decorator chain ---");
        System.out.println("Action: " + fullChain.getActionName());
        System.out.println("Damage: " + fullChain.getDamage());
        System.out.println("Effects: " + fullChain.getEffectSummary());

        System.out.println("\n--- 3) Full dungeon run (via Facade) ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, fullChain);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
        System.out.println("Log:");
        for (String line : result.getLog()) {
            System.out.println("  " + line);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
