package by.silebin.shapes.exception;

public class CubeFactoryException extends  Exception{
    public CubeFactoryException() {
    }

    public CubeFactoryException(String message) {
        super(message);
    }

    public CubeFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public CubeFactoryException(Throwable cause) {
        super(cause);
    }
}
