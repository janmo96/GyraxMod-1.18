package com.janmo96.gyraxmod.Utils;

import net.minecraft.nbt.CompoundTag;

public class PlayerMoney
{
    private int money;
    private int MIN_MONEY = 0;

    public int getMoney() {
        return money;
    }

    public void addMoney(int add){
        this.money = Math.min(money + add, 2147483647);
    }

    public void subMoney(int sub){
        this.money = Math.max(money - sub, MIN_MONEY);
    }

    public void copyFrom(PlayerMoney source){
        this.money = source.money;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("money", money);
    }

    public void loadNBTData(CompoundTag nbt){
        money = nbt.getInt("money");
    }

}
