package com.mycompany.villagonzalo_lab2._oop;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Tester {
    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    private static Field getField(Object obj, String fieldName) {
        List<Field> fields = getAllFields(new LinkedList<>(), obj.getClass());
        for(Field f : fields){
            if (f.getName().equals(fieldName)) {
                return f;
            }
        }
        return null;
    }

    private static Method getMethod(Object obj, String methodName) {
        Method[] methods = obj.getClass().getMethods();
        for (Method m : methods) {
            if (m.getName().equals(methodName)) {
                return m;
            }
        }
        return null;
    }

    public static void test(TextEditor editor) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter code: ");
        int code = scanner.nextInt();

        if (code == 1) {
            Field text = Tester.getField(editor, "text");
            if (text != null && Modifier.isPrivate(text.getModifiers())) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILED");
            }
        } else if (code == 2) {
            Method getText = Tester.getMethod(editor, "getText");
            Method setText = Tester.getMethod(editor, "setText");
            try {
                System.out.println(getText.invoke(editor));
                setText.invoke(editor, "New Text");
                System.out.println(getText.invoke(editor));
                System.out.println("SUCCESS");
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("FAILED");
            }
        } else if (code == 3) {
            Method append = Tester.getMethod(editor, "append");
            Method delete = Tester.getMethod(editor, "delete");
            try {
                append.invoke(editor, " Added Text");
                System.out.println("After append: " + editor.getText());
                delete.invoke(editor, 5);
                System.out.println("After delete: " + editor.getText());
                System.out.println("SUCCESS");
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("FAILED");
            }
        } else if (code == 4) {
            if(editor instanceof PrintTextEditor) {
                Method print = Tester.getMethod(editor, "print");
                try {
                    print.invoke(editor);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("FAILED");
                }
            } else {
                System.out.println("FAILED");
            }
        } else if (code == 5) {
            AdvancedTextEditor testEditor = new AdvancedTextEditor("abc");
            System.out.println(testEditor.getText());
            testEditor.append("defg");
            System.out.println(testEditor.getText());
            testEditor.append("hijkl");
            System.out.println(testEditor.getText());
            testEditor.undo();
            System.out.println(testEditor.getText());
            testEditor.undo();
            System.out.println(testEditor.getText());

            if (!testEditor.getText().equals("abc"))
            {
                System.out.println("FAILED");
                return;
            }

            testEditor.append("defg");
            testEditor.append("hijkl");
            testEditor.delete(5);
            testEditor.undo();

            if (!testEditor.getText().equals("abcdefghijkl"))
            {
                System.out.println("FAILED");
                return;
            }

            System.out.println("SUCCESS");
        } else if (code == 6) {
            TextEditor testEditor = new TextEditor("abc");

            testEditor.delete(4);

            if (!testEditor.getText().equals("abc"))
            {
                System.out.println("FAILED");
                return;
            }

            System.out.println("SUCCESS");
        }
    }
}

