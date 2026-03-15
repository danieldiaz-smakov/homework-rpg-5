package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {
    private static final int POISON_BONUS = 3;

    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return getWrappedAction().getActionName() + " (Poison)";
    }

    @Override
    public int getDamage() {
        return getWrappedAction().getDamage() + POISON_BONUS;
    }

    @Override
    public String getEffectSummary() {
        return getWrappedAction().getEffectSummary() + "; + Poison";
    }
}
