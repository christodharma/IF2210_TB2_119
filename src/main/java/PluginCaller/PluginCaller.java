package PluginCaller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.lang.reflect.Method;
import BasePlugin.BasePlugin;

public class PluginCaller {

    public static void MainPluginCaller() { 
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    public boolean accept(File file) {
                        return file.getName().toLowerCase().endsWith(".jar") || file.isDirectory();
                    }

                    public String getDescription() {
                        return "Jar Files (*.jar)";
                    }
                });

                int result = fileChooser.showOpenDialog(new JFrame());
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String jarFilePath = selectedFile.getAbsolutePath();
                    try {
                        loadJarFile(jarFilePath);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
    }

    private static void loadJarFile(String filePath) throws Exception {
        ArrayList<Class<?>> classes = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();

        ArrayList<String> classNames = getClassNames(new JarInputStream(new FileInputStream(filePath)));
        File file = new File(filePath);

        URLClassLoader classLoader = new URLClassLoader(new URL[]{file.toURI().toURL()});
        for (String className : classNames) {
            Class<?> loadedClass = classLoader.loadClass(className);
            classes.add(loadedClass);

            // Run the loaded class (assuming it has a default constructor)
            Object instance = loadedClass.getDeclaredConstructor().newInstance();
            Method pluginMethod = loadedClass.getDeclaredMethod("onLoad");
            pluginMethod.invoke(instance);
        }

        // Print the names of the loaded classes
        System.out.println("Classes loaded in plugin: ");
        for (Class<?> c : classes) {
            System.out.println(c.getName());
        }
    }

    private static ArrayList<String> getClassNames(JarInputStream jar) {
        ArrayList<String> list = new ArrayList<>();

        JarEntry entry;
        try {
            while ((entry = jar.getNextJarEntry()) != null) {
                if (entry.getName().endsWith(".class")) {
                    String className = entry.getName().replaceAll("/", "\\.");
                    className = className.substring(0, className.length() - ".class".length());
                    list.add(className);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}