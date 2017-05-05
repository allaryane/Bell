/**
 *  Utils
 *  [Bell]
 *  Created on : 17-05-01
 *      Author : Ryane Alla
 *  	Email  : allaryane@gmail.com
 *    Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs;

import dnl.utils.text.table.TextTable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utils class.
 */
public class XSUtils
{
    /**
     * Gets the list of all attribute names of a given type including superclass declared fields, using reflection.
     * @param type input type.
     * @return list of all attribute names of the given type.
     */
    public static List<java.lang.reflect.Field> getObjectReflectFieldsList(Class<?> type)
    {
        if(type == null) throw new RuntimeException("Error [XSUtils.getObjectReflectFieldsList] : type is null");
        List<Field> fields = new ArrayList<Field>();
        for (Class<?> c = type; c != null; c = c.getSuperclass())
        {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }
    
    /**
     * Print a list of objects using reflection.
     * @param resultsList list of objects to print.
     * @param <T> any object.
     */
    public static <T> void print(List<T> resultsList)
    {
        print(resultsList, null, null, 50);
    }
    
    /**
     * Print a list of objects using reflection.
     * @param resultsList list of objects to print.
     * @param columnNamesToIgnore list of column names to ignore.
     * @param <T> any object.
     */
    public static <T> void print(List<T> resultsList, List<String> columnNamesToIgnore)
    {
        print(resultsList, null, columnNamesToIgnore, 50);
    }
    
    /**
     * Print a list of objects using reflection.
     * @param resultsList list of objects to print.
     * @param columnNamesToPrint list of column names to print. Note a column's name is define by the attribute's name.
     * @param columnNamesToIgnore list of column names to ignore. Ignore list will be considered only in case of columnNamesToPrint is nul or empty.
     * @param limit number max of results to print.
     * @param <T> any object.
     */
    public static <T> void print(List<T> resultsList, List<String> columnNamesToPrint, List<String> columnNamesToIgnore, int limit)
    {
        if(resultsList == null || resultsList.size() == 0 || (resultsList.size() == 1 && resultsList.get(0) == null))
        {
            System.out.println(">> Warning [XSUtils.print] : number of result(s) : 0 [null|empty list of results]");
            return;
        }
        int n = resultsList.size();
        
        List<java.lang.reflect.Field> fieldsList = XSUtils.getObjectReflectFieldsList(resultsList.get(0).getClass());
        Field field = null;
        List<String> columnNames = new ArrayList<String>();
        if(columnNamesToPrint != null && columnNamesToPrint.size() > 0) columnNames = columnNamesToPrint;
        else
        {
            String fName = "";
            List<java.lang.reflect.Field> tmpFieldList = new ArrayList<java.lang.reflect.Field>();
            
            for (int i = 0; i < fieldsList.size(); i ++)
            {
                field = fieldsList.get(i);
                fName = field.getName();
                if(columnNamesToIgnore != null && columnNamesToIgnore.contains(fName)) continue;
                columnNames.add(fName);
                tmpFieldList.add(field);
            }
            fieldsList = tmpFieldList;
        }
        
        if(limit > 0 && n > limit) n = limit;
        String[ ][ ] data = new String[n][columnNames.size()];

        for (int i = 0; i < n; i++)
        {
            Object object = resultsList.get(i);
            for (int j = 0; j < columnNames.size(); j++)
            {
                try
                {
                    if(object == null)
                    {
                        data[i][j] = "null";
                        continue;
                    }
                    field = fieldsList.get(j);
                    field.setAccessible(true);
                    Object fieldObject = field.get(object);
                    if(fieldObject == null)
                    {
                        data[i][j] = "null";
                        continue;
                    }
                    data[i][j] = fieldObject.toString();
                }
                catch (IllegalArgumentException | IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            }
        }
        TextTable tt = new TextTable(columnNames.toArray(new String[0]), data);
        tt.printTable();
        
        if(resultsList.size() > limit) System.out.println("\n [ ... " + n + " / " + resultsList.size() + " Result(s) ... ] \n");
        else System.out.println("\n [ " + resultsList.size() + " Result(s) ] \n");
    }
    
}
