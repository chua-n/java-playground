package com.chuan.overload;

import java.util.List;

public class FakeList<T> {

    public FakeList(List<T> innerList) {
        this.innerList = innerList;
    }

    private final List<T> innerList;

    public T remove(int i) {
        return innerList.remove(i);
    }

    public boolean remove(Object element) {
        return innerList.remove(element);
    }

}
