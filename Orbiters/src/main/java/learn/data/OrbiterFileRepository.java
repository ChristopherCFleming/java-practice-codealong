package learn.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import learn.models.Orbiter;
import learn.models.OrbiterType;

public class OrbiterFileRepository {
    private final String filePath;

    public OrbiterFileRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<Orbiter> findAll() throws DataAccessException {
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
        }catch (FileNotFoundException ex) {
            //okay to ignore.
        }catch (IOException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }
        return result;
    }

    public Orbiter findByID(int orbiterID) throws DataAccessException {
        for (Orbiter orbiter: findAll()) {//here, findAll() returns an ArrayList of orbiter objects!
            if (orbiter.getOrbiterID() == orbiterID){
                return orbiter;
            }
        }
        return null;
    }

    public List<Orbiter> findByType(OrbiterType type) throws DataAccessException {
        ArrayList<Orbiter> result = new ArrayList<>();
        for (Orbiter orbiter : findAll()) {
            if (orbiter.getType() == type) {
                result.add(orbiter);
            }
        }
        return result;
    }

    public Orbiter add(Orbiter orbiter) throws DataAccessException {
        List<Orbiter> all = findAll();
        int nextId = 0;
        for (Orbiter o : all) {
            nextId = Math.max(nextId, o.getOrbiterID());
        }
        nextId++; //Need to add one because orbiter ids start at 1, not 0.
        orbiter.setOrbiterID(nextId);
        all.add(orbiter);
        writeAll(all);
        return orbiter;
    }

    public boolean update(Orbiter orbiter) throws DataAccessException {
        List<Orbiter> all = findAll();

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getOrbiterID() == orbiter.getOrbiterID()){
                all.set(i, orbiter);
                writeAll(all);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(int orbiterId) throws DataAccessException {
        List<Orbiter> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getOrbiterID() == orbiterId){
                all.remove(i);
                writeAll(all);
                return true;
            }
        }
        return false;
    }

    private void writeAll(List<Orbiter> orbiters) throws DataAccessException {
        try(PrintWriter writer = new PrintWriter(filePath)){
            writer.println("orbiterId,name,type,sponsor");
            for (Orbiter o : orbiters) {
                writer.println(serialize(o));
            }
        } catch(IOException ex){
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }

    private String serialize(Orbiter orbiter) {
        return String.format("%s,%s,%s,%s",
                orbiter.getOrbiterID(),
                orbiter.getName(),
                orbiter.getType(),
                orbiter.getSponsor());
    }
}//end of class
