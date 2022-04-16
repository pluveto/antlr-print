package com.less_bug.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    private List<SymbolTable> children = new ArrayList<>();
    private Map<String, Object> symbols = new HashMap<>();
    private SymbolTable parent;

    public SymbolTable() {
    }

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
    }

    public SymbolTable getParent() {
        return parent;
    }

    public void set(String name, Object value) {
        symbols.put(name, value);
    }

    public Object lookup(String name) {
        if (symbols.containsKey(name)) {
            return symbols.get(name);
        } else if (parent != null) {
            return parent.lookup(name);
        } else {
            return null;
        }
    }

    public void addChild(SymbolTable child) {
        children.add(child);
    }

    public List<SymbolTable> getChildren() {
        return children;
    }

    private void _print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("SymbolTable");
        for (Map.Entry<String, Object> entry : symbols.entrySet()) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (SymbolTable child : children) {
            child._print(level + 1);
        }
    }

    public void print() {
        this._print(0);
    }



}
