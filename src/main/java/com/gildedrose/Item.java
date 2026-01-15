package com.gildedrose;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private static final int MAX_QUALITY = 50;
    private static final int GOOD_CONDITION = 11;
    private static final int EXCELLENT_CONDITION = 6;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void updateQuality() {
        boolean isAgedBrie = name.equals(AGED_BRIE);
        boolean isBackstagePasses = name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
        boolean isSulfuras = name.equals(SULFURAS_HAND_OF_RAGNAROS);

        if (isAgedBrie) {
            incrementQualityIfNotMaxQuality();
            decrementSellIn();
            incrementQualityIfExpired();
        } else if (isBackstagePasses) {
            increaseQualityForBackstagePasses();
            decrementSellIn();
            zeroQualityIfExpired();
        } else if (isSulfuras){

        } else {
            decrementQualityIfPossible();
            decrementSellIn();
            decerementQualityIfExpired();
        }
    }

    private void increaseQualityForBackstagePasses() {
        if (qualityIsNotMAx()) {
            incrementQuality();
            incrementQualityIfInGoodCondition();
            incrementQualityIfInExcellentCondition();
        }
    }

    private void incrementQualityIfInExcellentCondition() {
        if (isInExcellentCondition()) {
            incrementQualityIfNotMaxQuality();
        }
    }

    private void incrementQualityIfInGoodCondition() {
        if (isInGoodCondition()) {
            incrementQualityIfNotMaxQuality();
        }
    }

    private boolean isInExcellentCondition() {
        return sellIn < EXCELLENT_CONDITION;
    }

    private boolean isInGoodCondition() {
        return sellIn < GOOD_CONDITION;
    }

    private void incrementQualityIfExpired() {
        if (isExpired()) {
            incrementQualityIfNotMaxQuality();
        }
    }

    private void decerementQualityIfExpired() {
        if (isExpired()) {
            decrementQualityIfPossible();
        }
    }

    private void zeroQualityIfExpired() {
        if (isExpired()) {
            zeroQuality();
        }
    }

    private void decrementQualityIfPossible() {
        if (hasSomeQuality()) {
            decrementQuality();
        }
    }

    private boolean hasSomeQuality() {
        return quality > 0;
    }

    private void decrementQuality() {
        quality = quality - 1;
    }

    private void zeroQuality() {
        quality = 0;
    }

    private void decrementSellIn() {
        sellIn = sellIn - 1;
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    private void incrementQualityIfNotMaxQuality() {
        if (qualityIsNotMAx()) {
            incrementQuality();
        }
    }

    private boolean qualityIsNotMAx() {
        return quality < MAX_QUALITY;
    }

    private void incrementQuality() {
        quality = quality + 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
