package com.neuedu.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * easyExcel中间件的工具类, 包含readExcel方法负责读取excel文件,并把内容加入到java程序中
 * 
 * 还包含writeExcel ,将java数据写入到excel中
 * 
 * 还包含判断是否是xls和xlsx类型的问题,如果不是就不能读写那个文件
 * @author lgp
 *
 */
public class ExcelUtil {
    /**
     * 读取 Excel(多个 sheet)
     *
     * @param excel    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel) {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        for (Sheet sheet : reader.getSheets()) {
            if (rowModel != null) {
                sheet.setClazz(rowModel.getClass());
            }
            reader.read(sheet);
        }
        return excelListener.getDatas();
    }

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel    文件
     * @param rowModel 实体类映射，继承 BaseRowModel 类
     * @param sheetNo  sheet 的序号 从1开始
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel, int sheetNo) {
        return readExcel(excel, rowModel, sheetNo, 1);
    }

    /**
     * 读取某个 sheet 的 Excel
     *
     * @param excel       文件
     * @param rowModel    实体类映射，继承 BaseRowModel 类
     * @param sheetNo     sheet 的序号 从1开始
     * @param headLineNum 表头行数，默认为1
     * @return Excel 数据 list
     */
    public static List<Object> readExcel(MultipartFile excel, BaseRowModel rowModel, int sheetNo,
                                         int headLineNum) {
        ExcelListener excelListener = new ExcelListener();
        ExcelReader reader = getReader(excel, excelListener);
        if (reader == null) {
            return null;
        }
        reader.read(new Sheet(sheetNo, headLineNum, rowModel.getClass()));
        return excelListener.getDatas();
    }

    /**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param object    映射实体类，Excel 模型
     */
    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list,
                                  String fileName, String sheetName, BaseRowModel object) {
        ExcelWriter writer = new ExcelWriter(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, object.getClass());
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        writer.finish();
    }

    /**
     * 导出 Excel ：多个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param object    映射实体类，Excel 模型
     */
    public static ExcelWriterFactroy writeExcelWithSheets(HttpServletResponse response, List<? extends BaseRowModel> list,
                                                          String fileName, String sheetName, BaseRowModel object) {
        ExcelWriterFactroy writer = new ExcelWriterFactroy(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, object.getClass());
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        return writer;
    }

    /**
     * 导出文件时为Writer生成OutputStream
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        try {
            if (!dbfFile.exists() || dbfFile.isDirectory()) {
                dbfFile.createNewFile();
            }
            fileName = new String(filePath.getBytes(), "ISO-8859-1");
            response.addHeader("Content-Disposition", "filename=" + fileName);
            return response.getOutputStream();
        } catch (IOException e) {
            throw new ExcelException("创建文件失败！");
        }
    }

    /**
     * 返回 ExcelReader
     *
     * @param excel         需要解析的 Excel 文件
     * @param excelListener new ExcelListener()
     */
    private static ExcelReader getReader(MultipartFile excel,
                                         ExcelListener excelListener) {
        String filename = excel.getOriginalFilename();
        if (filename == null || (!filename.toLowerCase().endsWith(".xls") && !filename.toLowerCase().endsWith(".xlsx"))) {
            throw new ExcelException("文件格式错误！");
        }
        InputStream inputStream;
        try {
            inputStream = new BufferedInputStream(excel.getInputStream());
            return new ExcelReader(inputStream, null, excelListener, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
