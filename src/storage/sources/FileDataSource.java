package storage.sources;

import java.io.*;

public class FileDataSource implements DataSource<String> {

    private String path;

    public FileDataSource(String path){
        this.path = path;
    }

    @Override
    public String importData() {

        StringBuilder builder = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){

            reader.lines().forEach( line -> {
                builder.append(line);
                builder.append("\n");
            });

        } catch (IOException e){
            e.printStackTrace();
        }

        return builder.toString();
    }

    @Override
    public void exportData(String data) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){

            writer.write(data);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
