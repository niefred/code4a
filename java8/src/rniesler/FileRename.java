package rniesler;

import java.io.IOException;
import java.nio.file.*;

class FileRename {
    private String dirPath;

    protected FileRename(String dirPath) {
        this.dirPath = dirPath;
    }

    public void doRename() {
        try {
            Files.list(Paths.get(dirPath)).forEach((Path fromPath) -> {
                        Path toPath = convertPath(fromPath);
                        System.out.println("Renaming: " + fromPath + " to " + toPath);
                        try {
                            Files.move(fromPath, toPath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Path convertPath(Path fromPath) {
        String fileName=fromPath.getFileName().toString();
        if(Character.isUpperCase(fileName.charAt(0))) {
            fileName = fileName.toLowerCase();
        } else {
            fileName = fileName.toUpperCase();
        }
        Path toPath;
        if(fromPath.getParent() != null) {
            toPath = fromPath.getParent().resolve(fileName);
        } else {
            toPath = Paths.get(fileName);
        }
        return toPath;
    }

    public static void main(String[] args) {
        new FileRename("test").doRename();
    }
}