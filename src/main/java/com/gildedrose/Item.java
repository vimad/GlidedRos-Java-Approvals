package com.gildedrose;

public class Item {

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
        boolean agedBrie = name.equals("Aged Brie");
        boolean backstagePasses = name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean sulfuras = name.equals("Sulfuras, Hand of Ragnaros");
        if (agedBrie) {
            incrementQualityIfNotMaxQuality();
            decrementSellIn();
            incrementQualityIfExpired();
        } else if (backstagePasses) {
            increaseQualityForBackstagePasses();
            decrementSellIn();
            zeroQualityIfExpired();
        } else if (sulfuras){

        } else {
            decremetQualityIfPossible();
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
            decremetQualityIfPossible();
        }
    }

    private void zeroQualityIfExpired() {
        if (isExpired()) {
            zeroQuality();
        }
    }

    private void decremetQualityIfPossible() {
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
