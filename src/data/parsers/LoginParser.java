package data.parsers;

import model.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

public class LoginParser implements Parser<String, List<Login>>{

    @Override
    public List<Login> parseData(String data) {

        LinkedList<Login> logins = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(new StringReader(data))) {

            reader.lines().forEach(line -> {
                String[] parts = line.split(";");

                logins.add(new Login(parts[0], parts[1], parts[2]));
            });

        } catch (IOException e){
            e.printStackTrace();
        }

        return logins;
    }

    @Override
    public String unparseData(List<Login> logins) {

        StringBuilder builder = new StringBuilder();

        logins.forEach(login -> {
            builder.append(login.getUserId()).append(';');
            builder.append(login.getLogin()).append(';');
            builder.append(login.getPassword()).append('\n');
        });

        return builder.toString();
    }




}
