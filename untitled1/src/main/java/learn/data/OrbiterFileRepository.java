package learn.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import learn.models.Orbiter;
import learn.models.OrbiterType;

public class OrbiterFileRepository {
    private final String filePath;

    public OrbiterFileRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<Orbiter> findAll() {
        ArrayList<Orbiter> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
        reader.readLine(); //throws away the first line, the header. If you look in the .csv, the first line tells it what each value is.
            for (String line = reader.readLine() ; line != null; line = reader.readLine()) {
                String[] fields = line.split(",", -1);
                if (fields.length == 4) {
                    Orbiter orbiter = new Orbiter();
                    orbiter.setOrbiterID(Integer.parseInt(fields[0]));
                    orbiter.setName(fields[1]);
                    orbiter.setType(OrbiterType.valueOf(fields[2]));
                    orbiter.setSponsor(fields[3]);
                    result.add(orbiter);
                }
            }
        }catch(IOException ex) {
            //do Nothing for now, because if there's no file, then no big deal.
        }
        return result;
    }

    public Orbiter findByID(int orbiterID) {
        for (Orbiter orbiter: findAll()) {//here, findAll() returns an ArrayList of orbiter objects!
            if (orbiter.getOrbiterID() == orbiterID){
                return orbiter;
            }
        }
        return null;
    }



}//end of class
