package com.lanniao.excel.util;

public class Sheet {
    private int sheetIndex;
    private String sheetName;
    private String title;
    private int rowCount;
    private int colCount;
    private String[] colNames;
    private String[][] cells;

    public Sheet() {
    }

    public Sheet(int sheetIndex, String sheetName, String title, int rowCount, int colCount, String[] colNames, String[][] cells) {
        this.sheetIndex = sheetIndex;
        this.sheetName = sheetName;
        this.title = title;
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.colNames = colNames;
        this.cells = cells;
    }

    public Sheet(int sheetIndex, String sheetName, String title, int rowCount, int colCount) {
        this.sheetIndex = sheetIndex;
        this.sheetName = sheetName;
        this.title = title;
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.colNames = new String[colCount];
        this.cells = new String[rowCount][colCount];
    }

    public int getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
    }

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public String[][] getCells() {
        return cells;
    }

    public void setCells(String[][] cells) {
        this.cells = cells;
    }
}
