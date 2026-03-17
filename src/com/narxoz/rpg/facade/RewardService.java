package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward (invalid result)";
        }
        if (!battleResult.isHeroWon()) {
            return "Defeat - no reward";
        }
        int rounds = battleResult.getRounds();
        if (rounds <= 3) {
            return "Victory reward: Legendary (quick win)";
        }
        if (rounds <= 8) {
            return "Victory reward: Rare";
        }
        return "Victory reward: Standard";
    }
}
