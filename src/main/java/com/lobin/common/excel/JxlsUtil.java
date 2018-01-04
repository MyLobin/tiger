package com.lobin.common.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JxlsUtil {
    public static void main(String[] args) throws InvalidFormatException, SAXException, IOException {
        JxlsUtil util=new JxlsUtil();
        util.test();
    }

    public  void test() throws IOException, SAXException, InvalidFormatException {

        InputStream inputXML = new BufferedInputStream(getClass().getResourceAsStream("/jxls/department.xml"));
        XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );
        InputStream inputXLS = new BufferedInputStream(getClass().getResourceAsStream("/jxls/department.xls"));
        List departments = new ArrayList();
        Map beans = new HashMap();
        beans.put("departments", departments);
        XLSReadStatus readStatus = mainReader.read( inputXLS, beans);
        System.out.println(departments.size());
        int i=0;

    }
}
