package com.narxoz.rpg.decorator;

public class CriticalFocusDecorator extends ActionDecorator {
    private static final double CRITICAL_MULTIPLIER = 1.5;

    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return getWrappedAction().getActionName() + " (Critical)";
    }

    @Override
    public int getDamage() {
        return (int) Math.round(getWrappedAction().getDamage() * CRITICAL_MULTIPLIER);
    }

    @Override
    public String getEffectSummary() {
        return getWrappedAction().getEffectSummary() + "; + Critical";
    }
}
