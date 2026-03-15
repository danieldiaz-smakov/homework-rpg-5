package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    private static final int FIRE_BONUS = 5;

    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return getWrappedAction().getActionName() + " (Fire)";
    }

    @Override
    public int getDamage() {
        return getWrappedAction().getDamage() + FIRE_BONUS;
    }

    @Override
    public String getEffectSummary() {
        return getWrappedAction().getEffectSummary() + "; + Fire";
    }
}
