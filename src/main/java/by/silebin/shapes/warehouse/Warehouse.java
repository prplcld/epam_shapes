package by.silebin.shapes.warehouse;

import by.silebin.shapes.entity.CubeParameters;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Warehouse instance;

    private Map<Long, CubeParameters> parameters;

    public static Warehouse getInstance(){
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    private Warehouse() {
        parameters = new HashMap<>();
    }

    public void save(long id, CubeParameters cubeParameters){
        parameters.remove(id);
        parameters.put(id, cubeParameters);
    }

    public void delete(long id){
        parameters.remove(id);
    }

    public CubeParameters get(long id){
        return parameters.get(id);
    }

    public Map<Long, CubeParameters> getParameters() {
        return Map.copyOf(parameters);
    }
}
