package com.flowledger.core.storage;

import java.util.ArrayList;

public interface StorageService<T> {
    public ArrayList<T> fetchData();
    public boolean saveData(ArrayList<T> data);
}
