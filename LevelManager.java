package candycrush;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class LevelManager {
    private static final ArrayList<Level> levels = new ArrayList<>();
    private static LevelManager levelManager = null;

    private LevelManager() {
        System.out.println("Start loading level configs!");
        loadLevelConfig();
        System.out.println("Loaded level configs!");
    }

    public static LevelManager getInstance() {
        if (levelManager == null) {
            levelManager = new LevelManager();
        }
        return levelManager;
    }

    private void loadLevelConfig() {
        String path = "src/candycrush/res/level";
        Properties properties;
        File folder = new File(path);
        File[] fileList = folder.listFiles();

        if (fileList != null) {
            for (File file : fileList) {
                properties = new Properties();
                try {
                    properties.load(new FileInputStream(file));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                levels.add(new Level(properties, Integer.parseInt(file.getName().substring(0, file.getName().indexOf(".")))));
            }
        } else {
            System.out.println("Level folder not found!");
        }

        Collections.sort(levels);
        levels.get(0).setLock(false);
    }

    public void save() {
        String path = "src/candycrush/res/level";
        Properties properties;
        File folder = new File(path);
        File[] fileList = folder.listFiles();

        if (fileList != null) {
            for (File file : fileList) {
                properties = new Properties();
                try {
                    properties.load(new FileInputStream(file));
                    String fileName = file.getName().substring(0, file.getName().indexOf("."));
                    properties.setProperty("lock", "" + levels.get(Integer.parseInt(fileName) - 1).isLock());
                    properties.store(new FileOutputStream(file), null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Level folder not found!");
        }
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public int getNumberOfLevel() {
        return levels.size();
    }
}
