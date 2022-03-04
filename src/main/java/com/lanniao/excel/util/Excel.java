package com.lanniao.excel.util;

import java.util.List;

public class Excel {
    private String excelName;
    private List<Sheet> sheetList;

    public Excel() {
    }

    public Excel(String excelName, List<Sheet> sheetList) {
        this.excelName = excelName;
        this.sheetList = sheetList;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public List<Sheet> getSheetList() {
        return sheetList;
    }

    public void setSheetList(List<Sheet> sheetList) {
        this.sheetList = sheetList;
    }
}
