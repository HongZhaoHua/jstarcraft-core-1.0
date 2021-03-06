package com.jstarcraft.core.resource.path;

import java.io.InputStream;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HadoopPathAdapter implements PathAdapter {

    private FileSystem fileSystem;

    private Path directory;

    public HadoopPathAdapter(FileSystem fileSystem, String directory) {
        this.fileSystem = fileSystem;
        this.directory = new Path(directory);
    }

    @Override
    public InputStream getStream(String path) throws Exception {
        InputStream stream = fileSystem.open(new Path(directory, path));
        return stream;
    }

}
