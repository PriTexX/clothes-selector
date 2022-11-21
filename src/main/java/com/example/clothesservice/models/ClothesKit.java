package com.example.clothesservice.models;

import java.util.List;

public class ClothesKit {
    private List<String> upperClothes;
    private List<String> lowerClothes;
    private List<String> shoes;

    public ClothesKit(List<String> upperClothes, List<String> lowerClothes, List<String> shoes) {
        this.upperClothes = upperClothes;
        this.lowerClothes = lowerClothes;
        this.shoes = shoes;
    }

    public List<String> getShoes() {
        return shoes;
    }

    public void setShoes(List<String> shoes) {
        this.shoes = shoes;
    }

    public List<String> getUpperClothes() {
        return upperClothes;
    }

    public void setUpperClothes(List<String> upperClothes) {
        this.upperClothes = upperClothes;
    }

    public List<String> getLowerClothes() {
        return lowerClothes;
    }

    public void setLowerClothes(List<String> lowerClothes) {
        this.lowerClothes = lowerClothes;
    }
}
