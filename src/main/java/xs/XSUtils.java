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
 *
 */
public class XSUtils
{
    /**
     * Gets the list of all attribute names of a given type including superclass declared fields.
     * @param type input type.
     * @return list of all attribute names of a given type.
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
     * Print single object using reflection.
     * @param object
     * @param <T>
     */
    public static <T> void print(T object)
    {
        print(Arrays.asList(object), null, 1);
    }
    
    /**
     * Print a list of objects using reflection.
     * @param resultsList list of objects to print.
     * @param <T> any object.
     */
    public static <T> void print(List<T> resultsList)
    {
        print(resultsList, null, 50);
    }
    
    /**
     * Print a list of objects using reflection.
     * @param resultsList list of objects to print.
     * @param columnNamesToPrint list of columns to print. Note a column's name is define by the attribute's name.
     * @param limit number max of results to print
     * @param <T> any object.
     */
    public static <T> void print(List<T> resultsList, String[] columnNamesToPrint, int limit)
    {
        if(resultsList == null || resultsList.size() == 0 || (resultsList.size() == 1 && resultsList.get(0) == null))
        {
            System.out.println(">> Warning [XSUtils.print] : number of result(s) : 0 [null|empty list of results]");
            return;
        }
        int n = resultsList.size();
        
        List<java.lang.reflect.Field> fieldsList = XSUtils.getObjectReflectFieldsList(resultsList.get(0).getClass());
        
        String[] columnNames = new String[fieldsList.size()];
        for (int i = 0; i < columnNames.length; i++){columnNames[i] = fieldsList.get(i).getName();}
        
        if(limit > 0 && n > limit) n = limit;
        String[ ][ ] data = new String[n][columnNames.length];
        for (int i = 0; i < n; i++)
        {
            Object object = resultsList.get(i);
            for (int j = 0; j < columnNames.length; j++)
            {
                try
                {
                    if(object == null)
                    {
                        data[i][j] = "null";
                        continue;
                    }
                    fieldsList.get(j).setAccessible(true);
                    Object fieldObject = fieldsList.get(j).get(object);
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
        TextTable tt = new TextTable(columnNames, data);
        tt.printTable();
        
        if(resultsList.size() > limit) System.out.println("\n [ ... " + n + " / " + resultsList.size() + " Result(s) ... ] \n");
        else System.out.println("\n [ " + resultsList.size() + " Result(s) ] \n");
    }
    
}
