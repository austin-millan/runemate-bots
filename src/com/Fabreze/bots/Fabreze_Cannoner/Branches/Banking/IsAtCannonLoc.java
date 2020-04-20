package com.Fabreze.bots.Fabreze_Cannoner.Branches.Banking;

import com.Fabreze.bots.Fabreze_Cannoner.Branches.HasFood;
import com.Fabreze.bots.Fabreze_Cannoner.CannonMain;
import com.Fabreze.bots.Fabreze_Cannoner.Leaves.Bank.MoveToCannonLoc;
import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsAtCannonLoc extends BranchTask {
    private CannonMain bot = (CannonMain) Environment.getBot();

    private HasFood hasFood = new HasFood();
    private MoveToCannonLoc moveToCannonLoc = new MoveToCannonLoc();

    @Override
    public boolean validate(){
        return bot.cannon.isLoaded();
    }
    @Override
    public TreeTask successTask() { return hasFood; }

    @Override
    public TreeTask failureTask() { return moveToCannonLoc; }
}
