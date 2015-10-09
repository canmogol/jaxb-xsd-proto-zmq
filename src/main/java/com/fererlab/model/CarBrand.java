package com.fererlab.model;

public enum CarBrand {
    // order of the enum values are important for proto serialization!
    // proto generator generates the enum ordered by their name
    E1_VOLVO(0), E2_SAAB(1), E3_ABARTH(2);
    private int index;

    CarBrand(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
