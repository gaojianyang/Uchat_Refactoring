package com.personal.xiri.uchat.component.skin.model;

import android.util.SparseArray;

import java.util.List;

/**
 * Created by Gaojianyang on 18/9/22.
 * github https://github.com/gaojianyang
 */
public class SkinStyleProvider {
    private List<SkinStyle> skinStylesList;
    private SparseArray<SkinStyle> skinStyleSparseArray;

    public SkinStyleProvider(List<SkinStyle> skinStylesList, SparseArray<SkinStyle> skinStyleSparseArray) {
        this.skinStylesList = skinStylesList;
        this.skinStyleSparseArray = skinStyleSparseArray;
    }

    public SkinStyleProvider() {
    }

    public List<SkinStyle> getSkinStylesList() {
        return skinStylesList;
    }

    public void setSkinStylesList(List<SkinStyle> skinStylesList) {
        this.skinStylesList = skinStylesList;
    }

    public SparseArray<SkinStyle> getSkinStyleSparseArray() {
        return skinStyleSparseArray;
    }

    public void setSkinStyleSparseArray(SparseArray<SkinStyle> skinStyleSparseArray) {
        this.skinStyleSparseArray = skinStyleSparseArray;
    }
}
