package com.example.clothesservice.models;

import java.util.List;

public class ClothesKit {
    private List<String> clothes;

    public ClothesKit(List<String> clothes) {
        this.clothes = clothes;
    }

    public List<String> getClothes() {
        return clothes;
    }

    public void setClothes(List<String> clothes) {
        this.clothes = clothes;
    }

}
