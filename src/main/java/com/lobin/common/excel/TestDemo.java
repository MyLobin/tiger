package com.lobin.common.excel;

import com.alibaba.fastjson.JSON;
import com.lobin.model.KnowledgeCategoryDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


/**
 * 这个类是用来把一个树形结构给excel添加输入约束
 */
public class TestDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream=new FileOutputStream("template.xlsx");
        createTemplate(outputStream);
    }


    static String json = "[{\"category\":{\"id\":171,\"name\":\"1一级分类\",\"level\":0,\"sort\":0,\"parentId\":0,\"createTime\":1513046549000,\"updateTime\":153073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":173,\"name\":\"二级分类\",\"level\":1,\"sort\":0,\"parentId\":171,\"createTime\":1513046549000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":174,\"name\":\"三级分类\",\"level\":2,\"sort\":0,\"parentId\":173,\"createTime\":1513046549000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]},{\"category\":{\"id\":1145,\"name\":\"疾病简介\",\"level\":2,\"sort\":0,\"parentId\":173,\"createTime\":1513061296000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]},{\"category\":{\"id\":1144,\"name\":\"科室基础知识\",\"level\":1,\"sort\":0,\"parentId\":171,\"createTime\":1513061296000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]},{\"category\":{\"id\":172,\"name\":\"2一级分类\",\"level\":0,\"sort\":0,\"parentId\":0,\"createTime\":1513046549000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1056,\"name\":\"二级分类\",\"level\":1,\"sort\":0,\"parentId\":172,\"createTime\":1513046549000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1057,\"name\":\"三级分类\",\"level\":2,\"sort\":0,\"parentId\":1056,\"createTime\":1513046549000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]}]},{\"category\":{\"id\":1042,\"name\":\"test\",\"level\":0,\"sort\":0,\"parentId\":0,\"createTime\":1513046549000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1141,\"name\":\"xxx\",\"level\":1,\"sort\":0,\"parentId\":1042,\"createTime\":1513060379000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1142,\"name\":\"xxx\",\"level\":2,\"sort\":0,\"parentId\":1141,\"createTime\":1513060379000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]}]},{\"category\":{\"id\":1080,\"name\":\"sadf\",\"level\":0,\"sort\":0,\"parentId\":0,\"createTime\":1513046549000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1082,\"name\":\"sadf\",\"level\":1,\"sort\":0,\"parentId\":1080,\"createTime\":1513046549000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1084,\"name\":\"asfd\",\"level\":2,\"sort\":0,\"parentId\":1082,\"createTime\":1513046549000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]}]},{\"category\":{\"id\":1081,\"name\":\"afsd\",\"level\":0,\"sort\":0,\"parentId\":0,\"createTime\":1513046549000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1083,\"name\":\"asfd\",\"level\":1,\"sort\":0,\"parentId\":1081,\"createTime\":1513046549000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1085,\"name\":\"afsd\",\"level\":2,\"sort\":0,\"parentId\":1083,\"createTime\":1513046549000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]}]},{\"category\":{\"id\":1128,\"name\":\"我不知道\",\"level\":0,\"sort\":0,\"parentId\":0,\"createTime\":1513058229000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1129,\"name\":\"我不知道1\",\"level\":1,\"sort\":0,\"parentId\":1128,\"createTime\":1513058229000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1130,\"name\":\"我不知道2\",\"level\":2,\"sort\":0,\"parentId\":1129,\"createTime\":1513058229000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]},{\"category\":{\"id\":1132,\"name\":\"我不知道1111\",\"level\":1,\"sort\":0,\"parentId\":1128,\"createTime\":1513058254000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]},{\"category\":{\"id\":1143,\"name\":\"科室--甲状腺\",\"level\":0,\"sort\":0,\"parentId\":0,\"createTime\":1513061296000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1148,\"name\":\"疾病知识\",\"level\":1,\"sort\":0,\"parentId\":1143,\"createTime\":1513061393000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1150,\"name\":\"疾病简介\",\"level\":2,\"sort\":0,\"parentId\":1148,\"createTime\":1513061393000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]},{\"category\":{\"id\":1151,\"name\":\"疾病诊疗路径\",\"level\":2,\"sort\":0,\"parentId\":1148,\"createTime\":1513061393000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]},{\"category\":{\"id\":1155,\"name\":\"患教文章\",\"level\":1,\"sort\":0,\"parentId\":1143,\"createTime\":1513061505000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1159,\"name\":\"就医流程\",\"level\":2,\"sort\":0,\"parentId\":1155,\"createTime\":1513061505000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]},{\"category\":{\"id\":1160,\"name\":\"医院位置\",\"level\":2,\"sort\":0,\"parentId\":1155,\"createTime\":1513061505000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]},{\"category\":{\"id\":1161,\"name\":\"检查流程\",\"level\":2,\"sort\":0,\"parentId\":1155,\"createTime\":1513061505000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]}]},{\"category\":{\"id\":1162,\"name\":\"骨科\",\"level\":0,\"sort\":0,\"parentId\":0,\"createTime\":1513073254000,\"updateTime\":1513073356000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1164,\"name\":\"腰椎间盘突出\",\"level\":1,\"sort\":0,\"parentId\":1162,\"createTime\":1513073357000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[{\"category\":{\"id\":1166,\"name\":\"腰背肌锻炼\",\"level\":2,\"sort\":0,\"parentId\":1164,\"createTime\":1513073357000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]},{\"category\":{\"id\":1165,\"name\":\"膝关节痛\",\"level\":1,\"sort\":0,\"parentId\":1162,\"createTime\":1513073357000,\"updateTime\":1513073357000,\"status\":1,\"operator\":\"韦丹丽\"},\"subCategoryList\":[]}]}]";

    private static final String OUTPUT_PATH = "/Volumes/G/mac/template.xlsx";

    public static void createTemplate(OutputStream outputStream) throws IOException {
        //get data
        List<KnowledgeCategoryDTO> categoryDTOList = JSON.parseArray(json, KnowledgeCategoryDTO.class);

        //构建数据有效性列表

// 创建一个excel
        Workbook book = new XSSFWorkbook();
        XSSFFont font = (XSSFFont) book.createFont();
        font.setBold(true);
        XSSFCellStyle titleStyle = (XSSFCellStyle) book.createCellStyle();
        // 设置单元格填充颜色
        titleStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 设置单元格字体
        titleStyle.setFont(font);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);



        // 创建需要用户填写的数据页
        // 设计表头
        Sheet sheet1 = book.createSheet("sheet1");
        Row row0 = sheet1.createRow(0);

        row0.setHeightInPoints(30);

        row0.createCell(0).setCellValue("资料标题");
        row0.getCell(0).setCellStyle(titleStyle);
        row0.createCell(1).setCellValue("资料内容");
        row0.getCell(1).setCellStyle(titleStyle);
        row0.createCell(2).setCellValue("一级分类");
        row0.getCell(2).setCellStyle(titleStyle);

        row0.createCell(3).setCellValue("二级分类");
        row0.getCell(3).setCellStyle(titleStyle);
        row0.createCell(4).setCellValue("三级分类");
        row0.getCell(4).setCellStyle(titleStyle);

        row0.createCell(5).setCellValue("一级分类ID");
        row0.createCell(6).setCellValue("二级分类ID");
        row0.createCell(7).setCellValue("三级分类ID");


//        sheet1.setColumnHidden(5,true);
//        sheet1.setColumnHidden(6,true);
//        sheet1.setColumnHidden(7,true);

        //创建一个专门用来存放地区信息的隐藏sheet页
        //因此也不能在现实页之前创建，否则无法隐藏。
        Sheet hideSheet = book.createSheet("site");
        book.setSheetHidden(book.getSheetIndex(hideSheet), false);
        String sheetName = hideSheet.getSheetName();
        long parentId=0L;
        //创建需要验的数据
        createNameRefer(categoryDTOList, book, hideSheet, sheetName, parentId);
        //加入数据校验
        for(int row=1;row<=200;row++) {
            createDataRefer(sheet1, row);
        }
//OutputStream outputStream=new ByteArrayOutputStream();
        book.write(outputStream);
//        return outputStream;
//        FileOutputStream os = null;
//        try {
//            os = new FileOutputStream(OUTPUT_PATH);
//            book.write(os);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietly(os);
//        }

    }

    private static void createDataRefer(Sheet sheet1,Integer row) {
        // 设置数据验证
        Row row1 = sheet1.createRow(row);
        Integer natureRow=row+1;
        //设置ID
        row1.createCell(5).setCellFormula("HLOOKUP(C"+natureRow+",_0_id,2,FALSE)");
        row1.createCell(6).setCellFormula("HLOOKUP(sheet1!D"+natureRow+",INDIRECT(CONCATENATE(\"_\",sheet1!F"+natureRow+",\"_id\")),2,FALSE)");
        row1.createCell(7).setCellFormula("HLOOKUP(sheet1!E"+natureRow+",INDIRECT(CONCATENATE(\"_\",sheet1!G"+natureRow+",\"_id\")),2,FALSE)");
        // 设置名称
        String promptBoxStr = "请使用下拉方式选择合适的值！";
        String errorBoxStr = "你输入的值不合法，请不要手动输入！";
        setDataValidationByFormula(sheet1, "_0_name", natureRow, 3, promptBoxStr, errorBoxStr);
        // 这里只是为了设置id值单元格的错误提示语，公式并不会生效
//        setDataValidationByFormula(sheet1, "HLOOKUP(C2,_0_id,2,FALSE)", 2, 4, "", errorBoxStr);

        setDataValidationByFormula(sheet1, "INDIRECT(CONCATENATE(\"_\",sheet1!F"+natureRow+",\"_name\"))", natureRow, 4, promptBoxStr, errorBoxStr);
//        setDataValidationByFormula(sheet1, "HLOOKUP(sheet1!E2,INDIRECT(CONCATENATE(\"_\",sheet1!D2,\"_id\")),2,FALSE)", 6, 4, "", errorBoxStr);

        setDataValidationByFormula(sheet1, "INDIRECT(CONCATENATE(\"_\",sheet1!G"+natureRow+",\"_name\"))", natureRow, 5, promptBoxStr, errorBoxStr);
//        setDataValidationByFormula(sheet1, "HLOOKUP(sheet1!G2,INDIRECT(CONCATENATE(\"_\",sheet1!F2,\"_id\")),2,FALSE)", 2, 8, "", errorBoxStr);
    }

    private static int rowIndex=0;
    private static void createNameRefer(List<KnowledgeCategoryDTO> categoryDTOList, Workbook book, Sheet hideSheet, String sheetName, Long parentId) {
        Row nameRow = hideSheet.createRow(rowIndex++);//0;
        Row idRow = hideSheet.createRow(rowIndex++);//1;
        for(KnowledgeCategoryDTO cate:categoryDTOList){
            Cell nameCell=nameRow.createCell(categoryDTOList.indexOf(cate));
            Cell idCell=idRow.createCell(categoryDTOList.indexOf(cate));
            nameCell.setCellValue(cate.getCategory().getName());
            idCell.setCellValue(cate.getCategory().getId());
            if(CollectionUtils.isNotEmpty(cate.getSubCategoryList())){
                //todo
                createNameRefer(cate.getSubCategoryList(),book,hideSheet,sheetName,cate.getCategory().getId());
            }
        }
        String   endColumnIndex = CellReference.convertNumToColString(nameRow.getLastCellNum());
        int tempRow=nameRow.getRowNum()+1;
        String tagName=sheetName+"!$A$"+tempRow+":$"+endColumnIndex+"$"+tempRow;
        String tagId=sheetName+"!$A$"+tempRow+":$"+endColumnIndex+"$"+(tempRow+1);
        Name nameTag=book.createName();
        nameTag.setNameName("_"+parentId+"_name");
        nameTag.setRefersToFormula(tagName);

        Name idTag=book.createName();
        idTag.setNameName("_"+parentId+"_id");
        idTag.setRefersToFormula(tagId);
    }

    /**
     * 给工作簿添加数据验证
     *
     * @param sheet              工作簿
     * @param formulaString      公式
     * @param naturalRowIndex    验证的行
     * @param naturalColumnIndex 验证的列
     * @param promptBoxStr       单元格提示语
     * @param errorBoxStr        单元格错误提示语
     */
    private static void setDataValidationByFormula(Sheet sheet, String formulaString, int naturalRowIndex,
                                                   int naturalColumnIndex, String promptBoxStr, String errorBoxStr) {
        //加载下拉列表内容
        DVConstraint constraint = DVConstraint.createFormulaListConstraint(formulaString);
        //设置数据有效性加载在哪个单元格上。
        //四个参数分别是：起始行、终止行、起始列、终止列
        int firstRow = naturalRowIndex - 1;
        int lastRow = naturalRowIndex - 1;
        int firstCol = naturalColumnIndex - 1;
        int lastCol = naturalColumnIndex - 1;
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                .createFormulaListConstraint(formulaString);
        //数据有效性对象
        XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, regions);
        //设置输入信息提示信息
        validation.createPromptBox("提示", promptBoxStr);
        //设置输入错误提示信息
        validation.createErrorBox("提示", errorBoxStr);
        validation.setSuppressDropDownArrow(true);
        validation.setShowPromptBox(true);
        validation.setShowErrorBox(true);
        sheet.addValidationData(validation);
    }

}
